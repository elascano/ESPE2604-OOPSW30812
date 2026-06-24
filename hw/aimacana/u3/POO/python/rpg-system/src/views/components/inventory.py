import customtkinter as ctk
import tkinter as tk
from typing import Callable
from controllers.game_controller import GameController
from models.entities.item import Item
from models.entities.potion import Potion
from models.entities.weapon import Weapon
from models.entities.armor import Armor
from models.entities.artifact import Artifact
from models.enums.armor_slot import ArmorSlot
from models.enums.artifact_slot import ArtifactSlot
from models.factories.item_factory import ItemFactory
from models.exceptions.inventory_full_exception import InventoryFullException
from views.image_loader import ImageLoader

class InventoryComponent(ctk.CTkFrame):
    def __init__(self, master, game_controller: GameController, on_update: Callable[[], None], logger: Callable[[str], None]):
        super().__init__(master, fg_color="#1e1e2e", corner_radius=10, border_width=2, border_color="#313244")
        self.game_controller = game_controller
        self.on_update = on_update
        self.logger = logger
        
        self.build_ui()

    def build_ui(self):
        lbl_title = ctk.CTkLabel(self, text="Mochila (Inventario)", font=("Arial", 16, "bold"))
        lbl_title.pack(anchor=tk.W, pady=(10, 10), padx=15)

        self.inventory_frame = ctk.CTkFrame(self, fg_color="transparent")
        self.inventory_frame.pack(fill=tk.BOTH, expand=True, padx=15)

        self.btn_loot = ctk.CTkButton(self, text="🔍 Buscar Botín", fg_color="#f38ba8", text_color="#1e1e2e", font=("Arial", 12, "bold"), command=self.handle_loot, state=tk.DISABLED)
        self.btn_loot.pack(fill=tk.X, pady=(10, 10), padx=15)

    def handle_loot(self):
        c = self.game_controller.get_current_character()
        if c:
            try:
                item = ItemFactory.create_random_loot(c.level)
                c.add_item(item)
                self.logger(f"Has encontrado un ítem: {item.name}")
            except InventoryFullException as ex:
                self.logger(f"❌ {str(ex)}")
            self.update_state()
            self.on_update()

    def update_state(self):
        c = self.game_controller.get_current_character()
        self.btn_loot.configure(state=tk.NORMAL if c else tk.DISABLED)

        for widget in self.inventory_frame.winfo_children():
            widget.destroy()

        if c:
            row = 0
            col = 0
            for item in c.inventory:
                self.add_visual_item(item, row, col)
                col += 1
                if col > 2:
                    col = 0
                    row += 1

    def add_visual_item(self, item: Item, row: int, col: int):
        box = ctk.CTkFrame(self.inventory_frame, fg_color="#313244", width=80, height=80, corner_radius=8)
        box.grid(row=row, column=col, padx=5, pady=5)
        box.grid_propagate(False)

        label_name = "Ítem"
        img_name = "potion.png"
        if isinstance(item, Potion): 
            label_name = "Poción"
            img_name = "potion.png"
        elif isinstance(item, Weapon): 
            label_name = "Arma"
            img_name = "weapon.png"
        elif isinstance(item, Armor):
            img_name = "armor.png"
            if item.slot == ArmorSlot.HELMET: 
                label_name = "Casco"
                img_name = "helmet.png"
            elif item.slot == ArmorSlot.CHEST: 
                label_name = "Pechera"
                img_name = "chest.png"
            elif item.slot == ArmorSlot.LEGS: 
                label_name = "Pantalones"
                img_name = "legs.png"
            elif item.slot == ArmorSlot.BOOTS: 
                label_name = "Botas"
                img_name = "boots.png"
        elif isinstance(item, Artifact):
            label_name = "Artefacto"
            if item.slot == ArtifactSlot.RING: img_name = "ring.png"
            elif item.slot == ArtifactSlot.AMULET: img_name = "amulet.png"

        img = ImageLoader.get_image(img_name, 40)
        
        lbl_icon = tk.Label(box, image=img, bg="#313244")
        lbl_icon.image = img
        lbl_icon.pack(expand=True, pady=(5,0))
        
        lbl_name = ctk.CTkLabel(box, text=label_name, font=("Arial", 10))
        lbl_name.pack(expand=True)

        def equip_or_consume(e, it=item):
            result = self.game_controller.interact_with_item(it)
            self.logger(result)
            self.on_update()

        lbl_icon.bind("<Button-1>", equip_or_consume)
        lbl_name.bind("<Button-1>", equip_or_consume)
        box.bind("<Button-1>", equip_or_consume)

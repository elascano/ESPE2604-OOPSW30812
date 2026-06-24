import customtkinter as ctk
import tkinter as tk
from typing import Callable
from controllers.game_controller import GameController
from models.entities.warrior import Warrior
from models.entities.mage import Mage
from models.enums.armor_slot import ArmorSlot
from models.enums.artifact_slot import ArtifactSlot
from views.image_loader import ImageLoader

class PlayerStatsComponent(ctk.CTkFrame):
    def __init__(self, master, game_controller: GameController, on_update: Callable[[], None], logger: Callable[[str], None]):
        super().__init__(master, fg_color="#1e1e2e", corner_radius=10, border_width=2, border_color="#313244")
        self.game_controller = game_controller
        self.on_update = on_update
        self.logger = logger
        
        self.build_ui()

    def build_ui(self):
        lbl_title = ctk.CTkLabel(self, text="Tu Personaje", font=("Arial", 16, "bold"))
        lbl_title.pack(anchor=tk.W, pady=(10, 10), padx=15)

        top_frame = ctk.CTkFrame(self, fg_color="transparent")
        top_frame.pack(fill=tk.X, pady=5, padx=15)

        self.lbl_avatar = tk.Label(top_frame, text="👤", font=("Arial", 40), bg="#1e1e2e", fg="white")
        self.lbl_avatar.pack(side=tk.LEFT, padx=10)

        info_frame = ctk.CTkFrame(top_frame, fg_color="transparent")
        info_frame.pack(side=tk.LEFT, fill=tk.X, expand=True)

        self.lbl_name_stat = ctk.CTkLabel(info_frame, text="Desconocido", font=("Arial", 18, "bold"))
        self.lbl_name_stat.pack(anchor=tk.W)

        self.lbl_class_stat = ctk.CTkLabel(info_frame, text="Ninguna", text_color="#1e1e2e", fg_color="#89b4fa", font=("Arial", 12, "bold"), corner_radius=5)
        self.lbl_class_stat.pack(anchor=tk.W, pady=5)

        hp_frame = ctk.CTkFrame(self, fg_color="transparent")
        hp_frame.pack(fill=tk.X, pady=10, padx=15)
        ctk.CTkLabel(hp_frame, text="Salud Vital (HP)").pack(anchor=tk.W)
        
        hp_bar_inner = ctk.CTkFrame(hp_frame, fg_color="transparent")
        hp_bar_inner.pack(fill=tk.X)
        self.hp_bar = ctk.CTkProgressBar(hp_bar_inner, height=15, progress_color="#a6e3a1")
        self.hp_bar.pack(side=tk.LEFT, fill=tk.X, expand=True, padx=(0, 10))
        self.hp_bar.set(0)
        self.lbl_hp_text = ctk.CTkLabel(hp_bar_inner, text="0 / 0")
        self.lbl_hp_text.pack(side=tk.RIGHT)

        details_frame = ctk.CTkFrame(self, fg_color="transparent")
        details_frame.pack(fill=tk.X, pady=10, padx=15)

        pri_frame = ctk.CTkFrame(details_frame, fg_color="transparent")
        pri_frame.pack(side=tk.LEFT, fill=tk.X, expand=True)
        ctk.CTkLabel(pri_frame, text="Atributo Primario").pack(anchor=tk.W)
        self.lbl_primary_stat = ctk.CTkLabel(pri_frame, text="-", font=("Arial", 14, "bold"))
        self.lbl_primary_stat.pack(anchor=tk.W)

        sec_frame = ctk.CTkFrame(details_frame, fg_color="transparent")
        sec_frame.pack(side=tk.LEFT, fill=tk.X, expand=True)
        ctk.CTkLabel(sec_frame, text="Recurso Especial").pack(anchor=tk.W)
        self.lbl_secondary_stat = ctk.CTkLabel(sec_frame, text="-", font=("Arial", 14, "bold"))
        self.lbl_secondary_stat.pack(anchor=tk.W)

        combat_frame = ctk.CTkFrame(self, fg_color="transparent")
        combat_frame.pack(fill=tk.X, pady=10, padx=15)

        dmg_frame = ctk.CTkFrame(combat_frame, fg_color="transparent")
        dmg_frame.pack(side=tk.LEFT, fill=tk.X, expand=True)
        ctk.CTkLabel(dmg_frame, text="Bonus Daño").pack(anchor=tk.W)
        self.lbl_bonus_damage = ctk.CTkLabel(dmg_frame, text="0.0", font=("Arial", 14, "bold"), text_color="#a6e3a1")
        self.lbl_bonus_damage.pack(anchor=tk.W)

        def_frame = ctk.CTkFrame(combat_frame, fg_color="transparent")
        def_frame.pack(side=tk.LEFT, fill=tk.X, expand=True)
        ctk.CTkLabel(def_frame, text="Defensa").pack(anchor=tk.W)
        self.lbl_bonus_defense = ctk.CTkLabel(def_frame, text="0.0", font=("Arial", 14, "bold"), text_color="#89b4fa")
        self.lbl_bonus_defense.pack(anchor=tk.W)

        equip_frame = ctk.CTkFrame(self, fg_color="transparent")
        equip_frame.pack(fill=tk.X, pady=10, padx=15)
        ctk.CTkLabel(equip_frame, text="Equipamiento Activo", font=("Arial", 12, "bold")).pack(anchor=tk.W)

        self.equip_pane = ctk.CTkFrame(equip_frame, fg_color="transparent")
        self.equip_pane.pack(fill=tk.X, pady=5)

    def update_state(self):
        c = self.game_controller.get_current_character()
        if not c:
            self.lbl_name_stat.configure(text="Sin Personaje")
            self.lbl_class_stat.configure(text="N/A", fg_color="#45475a")
            self.hp_bar.set(0)
            self.lbl_hp_text.configure(text="0 / 0")
            self.lbl_primary_stat.configure(text="-")
            self.lbl_secondary_stat.configure(text="-")
            self.lbl_bonus_damage.configure(text="0.0")
            self.lbl_bonus_defense.configure(text="0.0")
            for widget in self.equip_pane.winfo_children():
                widget.destroy()
            return

        self.lbl_name_stat.configure(text=f"{c.name} (Nivel {c.level})")
        hp_progress = c.hp / c.max_hp
        self.hp_bar.set(hp_progress)
        self.lbl_hp_text.configure(text=f"{c.hp:.0f} / {c.max_hp:.0f}")

        self.lbl_bonus_damage.configure(text=f"+{c.bonus_damage:.1f}")
        self.lbl_bonus_defense.configure(text=f"+{c.bonus_defense:.1f}")

        for widget in self.equip_pane.winfo_children():
            widget.destroy()

        self.build_slot_ui(c.get_equipped_armor(ArmorSlot.HELMET), "Casco", "helmet.png", lambda: self.game_controller.unequip_armor(ArmorSlot.HELMET), 0, 0)
        self.build_slot_ui(c.get_equipped_armor(ArmorSlot.CHEST), "Pechera", "chest.png", lambda: self.game_controller.unequip_armor(ArmorSlot.CHEST), 0, 1)
        self.build_slot_ui(c.get_equipped_armor(ArmorSlot.LEGS), "Pantalones", "legs.png", lambda: self.game_controller.unequip_armor(ArmorSlot.LEGS), 0, 2)
        self.build_slot_ui(c.get_equipped_armor(ArmorSlot.BOOTS), "Botas", "boots.png", lambda: self.game_controller.unequip_armor(ArmorSlot.BOOTS), 1, 0)
        self.build_slot_ui(c.get_equipped_artifact(ArtifactSlot.RING), "Anillo", "ring.png", lambda: self.game_controller.unequip_artifact(ArtifactSlot.RING), 1, 1)
        self.build_slot_ui(c.get_equipped_artifact(ArtifactSlot.AMULET), "Amuleto", "amulet.png", lambda: self.game_controller.unequip_artifact(ArtifactSlot.AMULET), 1, 2)

        if isinstance(c, Warrior):
            self.lbl_class_stat.configure(text=f" Guerrero | EXP: {c.exp}/100 ", text_color="#1e1e2e", fg_color="#f38ba8")
            self.lbl_primary_stat.configure(text=f"Fuerza: {c.strength}")
            self.lbl_secondary_stat.configure(text=f"{c.rage} Pts")
            img = ImageLoader.get_image("warrior.png", 60)
            self.lbl_avatar.config(image=img, text="")
            self.lbl_avatar.image = img
        elif isinstance(c, Mage):
            self.lbl_class_stat.configure(text=f" Mago | EXP: {c.exp}/100 ", text_color="#1e1e2e", fg_color="#89b4fa")
            self.lbl_primary_stat.configure(text=f"Inteligencia: {c.intelligence}")
            self.lbl_secondary_stat.configure(text=f"{c.mana} Pts")
            img = ImageLoader.get_image("mage.png", 60)
            self.lbl_avatar.config(image=img, text="")
            self.lbl_avatar.image = img

    def build_slot_ui(self, item, empty_name, default_img, unequip_action, row, col):
        bg_color = "#313244" if item is None else "#45475a"
        box = ctk.CTkFrame(self.equip_pane, fg_color=bg_color, width=70, height=70, corner_radius=8)
        box.grid(row=row, column=col, padx=5, pady=5)
        box.grid_propagate(False)

        img_name = default_img
        title = empty_name
        if item is not None:
            title = item.name

        img = ImageLoader.get_image(img_name, 35)
        lbl_icon = tk.Label(box, image=img, bg=bg_color)
        lbl_icon.image = img
        lbl_icon.pack(expand=True, pady=(5,0))
        
        lbl_name = ctk.CTkLabel(box, text=title, font=("Arial", 9))
        lbl_name.pack(expand=True)

        def on_click(e):
            if item is not None:
                result = unequip_action()
                self.logger(result)
                self.on_update()

        lbl_icon.bind("<Button-1>", on_click)
        lbl_name.bind("<Button-1>", on_click)
        box.bind("<Button-1>", on_click)

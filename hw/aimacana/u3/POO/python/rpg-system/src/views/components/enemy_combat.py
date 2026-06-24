import customtkinter as ctk
import tkinter as tk
from typing import Callable
from controllers.game_controller import GameController
from models.factories.enemy_factory import EnemyFactory
from views.image_loader import ImageLoader

class EnemyCombatComponent(ctk.CTkFrame):
    def __init__(self, master, game_controller: GameController, on_update: Callable[[], None], logger: Callable[[str], None]):
        super().__init__(master, fg_color="#1e1e2e", corner_radius=10, border_width=2, border_color="#313244")
        self.game_controller = game_controller
        self.on_update = on_update
        self.logger = logger
        
        self.current_enemy = EnemyFactory.spawn_enemy_for_level(1)
        self.build_ui()
        self.update_state()

    def build_ui(self):
        lbl_title = ctk.CTkLabel(self, text="Zona de Combate", font=("Arial", 16, "bold"))
        lbl_title.pack(anchor=tk.W, pady=(10, 10), padx=15)

        info_frame = ctk.CTkFrame(self, fg_color="transparent")
        info_frame.pack(fill=tk.X, pady=5, padx=15)

        self.lbl_icon = tk.Label(info_frame, bg="#1e1e2e")
        self.lbl_icon.pack(side=tk.LEFT, padx=10)

        details_frame = ctk.CTkFrame(info_frame, fg_color="transparent")
        details_frame.pack(side=tk.LEFT, fill=tk.X, expand=True)

        self.lbl_enemy_name = ctk.CTkLabel(details_frame, text=self.current_enemy.name, font=("Arial", 16, "bold"))
        self.lbl_enemy_name.pack(anchor=tk.W)

        lbl_enemy_type = ctk.CTkLabel(details_frame, text=" Monstruo Salvaje ", text_color="#1e1e2e", fg_color="#f38ba8", font=("Arial", 12, "bold"), corner_radius=5)
        lbl_enemy_type.pack(anchor=tk.W, pady=5)

        hp_frame = ctk.CTkFrame(self, fg_color="transparent")
        hp_frame.pack(fill=tk.X, pady=10, padx=15)

        self.hp_bar = ctk.CTkProgressBar(hp_frame, height=15, progress_color="#f38ba8")
        self.hp_bar.pack(side=tk.LEFT, fill=tk.X, expand=True, padx=(0, 10))

        self.lbl_hp_text = ctk.CTkLabel(hp_frame, text="200 / 200")
        self.lbl_hp_text.pack(side=tk.RIGHT)

        self.btn_attack = ctk.CTkButton(self, text="⚔️ Atacar Enemigo", fg_color="#f38ba8", text_color="#1e1e2e", font=("Arial", 14, "bold"), command=self.handle_attack)
        self.btn_attack.pack(fill=tk.X, pady=(10, 15), padx=15)

    def handle_attack(self):
        if self.current_enemy.hp <= 0:
            self.logger("El enemigo ya está muerto.")
            return
        
        result = self.game_controller.attack_target(self.current_enemy)
        self.logger(result)
        self.update_state()
        self.on_update()

    def update_state(self):
        player_active = self.game_controller.get_current_character() is not None
        self.btn_attack.configure(state=tk.NORMAL if player_active else tk.DISABLED)

        hp_progress = self.current_enemy.hp / self.current_enemy.max_hp
        self.hp_bar.set(hp_progress)
        self.lbl_hp_text.configure(text=f"{self.current_enemy.hp:.0f} / {self.current_enemy.max_hp:.0f}")

        # Update enemy image
        img_name = "orc.png"
        if "Goblin" in self.current_enemy.name: img_name = "goblin.png"
        elif "Dragón" in self.current_enemy.name: img_name = "dragon.png"
        
        try:
            img = ImageLoader.get_image(img_name, 60)
            self.lbl_icon.config(image=img)
            self.lbl_icon.image = img
        except:
            pass

        if self.current_enemy.hp <= 0 and player_active:
            self.logger("¡Has derrotado al monstruo! Buscando botín...")
            player_level = self.game_controller.get_current_character().level
            self.current_enemy = EnemyFactory.spawn_enemy_for_level(player_level)
            self.lbl_enemy_name.configure(text=self.current_enemy.name)
            self.update_state()

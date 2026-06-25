import customtkinter as ctk
import tkinter as tk
from tkinter import messagebox
from typing import Callable
from models.entities.warrior import Warrior
from models.entities.mage import Mage
from controllers.game_controller import GameController
import uuid

class ControlPanelComponent(ctk.CTkFrame):
    def __init__(self, master, game_controller: GameController, on_update: Callable[[], None], logger: Callable[[str], None]):
        super().__init__(master, fg_color="#1e1e2e", corner_radius=10, border_width=2, border_color="#313244")
        self.game_controller = game_controller
        self.on_update = on_update
        self.logger = logger
        
        self.build_ui()
        self.refresh_saved_games_list()

    def build_ui(self):
        # Creation Card
        create_frame = ctk.CTkFrame(self, fg_color="transparent")
        create_frame.pack(fill=tk.X, padx=10, pady=(10, 5))
        
        lbl_create = ctk.CTkLabel(create_frame, text="Crear Nuevo Personaje", font=("Arial", 14, "bold"))
        lbl_create.pack(fill=tk.X, pady=(0, 5))

        self.txt_name = ctk.CTkEntry(create_frame, placeholder_text="Nombre...")
        self.txt_name.pack(fill=tk.X, pady=5)

        self.cmb_class = ctk.CTkOptionMenu(create_frame, values=["Warrior", "Mage"])
        self.cmb_class.pack(fill=tk.X, pady=5)

        btn_create = ctk.CTkButton(create_frame, text="Crear Personaje", fg_color="#89b4fa", text_color="#1e1e2e", font=("Arial", 12, "bold"), command=self.handle_create_character)
        btn_create.pack(fill=tk.X, pady=5)

        # Database Card
        db_frame = ctk.CTkFrame(self, fg_color="transparent")
        db_frame.pack(fill=tk.X, padx=10, pady=(10, 10))
        
        lbl_db = ctk.CTkLabel(db_frame, text="Persistencia (MongoDB)", font=("Arial", 14, "bold"))
        lbl_db.pack(fill=tk.X, pady=(0, 5))

        self.cmb_saved_games = ctk.CTkOptionMenu(db_frame, values=[])
        self.cmb_saved_games.pack(fill=tk.X, pady=5)

        btn_load = ctk.CTkButton(db_frame, text="Cargar Partida", fg_color="#f9e2af", text_color="#1e1e2e", font=("Arial", 12, "bold"), command=self.handle_load_character)
        btn_load.pack(fill=tk.X, pady=5)

        self.btn_save = ctk.CTkButton(db_frame, text="Guardar Partida", fg_color="#a6e3a1", text_color="#1e1e2e", font=("Arial", 12, "bold"), command=self.handle_save_character, state=tk.DISABLED)
        self.btn_save.pack(fill=tk.X, pady=5)

        btn_rest = ctk.CTkButton(db_frame, text="⛺ Descansar (Curar)", fg_color="#89dceb", text_color="#1e1e2e", font=("Arial", 12, "bold"), command=self.handle_rest)
        btn_rest.pack(fill=tk.X, pady=5)

    def refresh_saved_games_list(self):
        saved_games = self.game_controller.get_all_saved_characters()
        self.saved_games_map = {}
        values = []
        for c in saved_games:
            ctype = "Guerrero" if isinstance(c, Warrior) else "Mago"
            display = f"{ctype} - {c.name} (Lvl {c.level})"
            values.append(display)
            self.saved_games_map[display] = c.id
        
        if values:
            self.cmb_saved_games.configure(values=values)
            self.cmb_saved_games.set(values[0])
        else:
            self.cmb_saved_games.configure(values=["- Vacío -"])
            self.cmb_saved_games.set("- Vacío -")

    def handle_create_character(self):
        name = self.txt_name.get()
        if not name or name == "Nombre...":
            messagebox.showwarning("Error", "El nombre no puede estar vacío.")
            return

        cls_val = self.cmb_class.get()
        msg = self.game_controller.create_character(name, cls_val)
        self.logger(msg)
        self.btn_save.configure(state=tk.NORMAL)
        self.on_update()

    def handle_load_character(self):
        selection = self.cmb_saved_games.get()
        if not selection or selection == "- Vacío -":
            messagebox.showwarning("Error", "Selecciona una partida.")
            return

        char_id = self.saved_games_map.get(selection)
        if char_id:
            result = self.game_controller.load_character(char_id)
            self.logger(result)
            if not result.startswith("Error"):
                self.btn_save.configure(state=tk.NORMAL)
                self.on_update()
            else:
                messagebox.showwarning("Error", "Personaje no encontrado.")

    def handle_save_character(self):
        result = self.game_controller.save_game()
        self.logger(result)
        self.refresh_saved_games_list()

    def handle_rest(self):
        c = self.game_controller.get_current_character()
        if c:
            msg = self.game_controller.rest_character()
            self.logger(msg)
            self.on_update()
        else:
            messagebox.showwarning("Error", "No hay personaje activo.")

    def update_state(self):
        state = tk.NORMAL if self.game_controller.get_current_character() else tk.DISABLED
        self.btn_save.configure(state=state)

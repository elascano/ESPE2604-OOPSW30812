import customtkinter as ctk
import tkinter as tk
from controllers.game_controller import GameController
from views.components.control_panel import ControlPanelComponent
from views.components.player_stats import PlayerStatsComponent
from views.components.enemy_combat import EnemyCombatComponent
from views.components.inventory import InventoryComponent

class CharacterDashboard:
    def __init__(self, root: ctk.CTk, controller: GameController):
        self.root = root
        self.game_controller = controller
        self.build_ui()

    def build_ui(self):
        self.root.title("ESPE RPG System")
        self.root.geometry("1150x750")
        
        main_view = ctk.CTkFrame(self.root, fg_color="transparent")
        main_view.pack(fill=tk.BOTH, expand=True, padx=20, pady=20)

        header = ctk.CTkFrame(main_view, fg_color="transparent")
        header.pack(fill=tk.X, pady=(0, 15))
        lbl_title = ctk.CTkLabel(header, text="ESPE RPG System", font=("Arial", 28, "bold"))
        lbl_title.pack(side=tk.LEFT)

        content_frame = ctk.CTkFrame(main_view, fg_color="transparent")
        content_frame.pack(fill=tk.BOTH, expand=True)

        # Left Column
        left_col = ctk.CTkFrame(content_frame, width=280, fg_color="transparent")
        left_col.pack(side=tk.LEFT, fill=tk.Y, padx=(0, 20))
        
        # Center Column
        center_col = ctk.CTkFrame(content_frame, width=400, fg_color="transparent")
        center_col.pack(side=tk.LEFT, fill=tk.Y, expand=True, padx=(0, 20))

        # Right Column
        right_col = ctk.CTkFrame(content_frame, width=280, fg_color="transparent")
        right_col.pack(side=tk.LEFT, fill=tk.Y)

        self.control_panel = ControlPanelComponent(left_col, self.game_controller, self.update_all_components, self.log)
        self.control_panel.pack(fill=tk.X, pady=(0, 15))

        self.txt_console = ctk.CTkTextbox(left_col, wrap=tk.WORD, height=180, border_width=2, border_color="#313244", fg_color="#181825")
        self.txt_console.pack(fill=tk.BOTH, expand=True)
        self.txt_console.configure(state=tk.DISABLED)

        self.player_stats = PlayerStatsComponent(center_col, self.game_controller, self.update_all_components, self.log)
        self.player_stats.pack(fill=tk.X, pady=(0, 20))

        self.enemy_combat = EnemyCombatComponent(center_col, self.game_controller, self.update_all_components, self.log)
        self.enemy_combat.pack(fill=tk.X)

        self.inventory = InventoryComponent(right_col, self.game_controller, self.update_all_components, self.log)
        self.inventory.pack(fill=tk.BOTH, expand=True)

        self.update_all_components()

    def update_all_components(self):
        self.control_panel.update_state()
        self.player_stats.update_state()
        self.enemy_combat.update_state()
        self.inventory.update_state()

    def log(self, message: str):
        self.txt_console.configure(state=tk.NORMAL)
        self.txt_console.insert(tk.END, f"> {message}\n")
        self.txt_console.see(tk.END)
        self.txt_console.configure(state=tk.DISABLED)

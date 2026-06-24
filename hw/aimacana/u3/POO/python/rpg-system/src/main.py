import os
import sys

# Ensure src is in the python path
sys.path.insert(0, os.path.abspath(os.path.dirname(__file__)))

import customtkinter as ctk
from repository.mongo_character_repository import MongoCharacterRepository
from controllers.game_controller import GameController
from views.character_dashboard import CharacterDashboard

def main():
    ctk.set_appearance_mode("dark")
    ctk.set_default_color_theme("blue")
    
    root = ctk.CTk()
    
    # Initialize Architecture Layers
    repository = MongoCharacterRepository()
    game_controller = GameController(repository)
    
    # Initialize Main Layout
    dashboard = CharacterDashboard(root, game_controller)
    
    root.mainloop()

if __name__ == "__main__":
    main()

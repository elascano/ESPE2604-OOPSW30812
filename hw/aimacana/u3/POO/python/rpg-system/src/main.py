import os
import sys

# Ensure src is in the python path
sys.path.insert(0, os.path.abspath(os.path.dirname(__file__)))

# Load .env file from root directory if it exists
env_path = os.path.abspath(os.path.join(os.path.dirname(__file__), "..", ".env"))
if os.path.exists(env_path):
    with open(env_path, "r", encoding="utf-8") as f:
        for line in f:
            line = line.strip()
            if line and not line.startswith("#"):
                parts = line.split("=", 1)
                if len(parts) == 2:
                    os.environ[parts[0].strip()] = parts[1].strip()

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

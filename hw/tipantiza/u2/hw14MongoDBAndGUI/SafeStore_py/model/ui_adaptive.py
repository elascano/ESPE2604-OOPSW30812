"""
Adaptive UI Module
@author Alexander Tipantiza, The Softwarriors, @ESPE
"""

class UIAdaptive:
    """Adaptive UI management"""
    
    _shortcuts = {}
    
    @classmethod
    def menu(cls):
        """Display adaptive UI menu"""
        print("\n--- ADAPTIVE UI ---")
        print("1. Apply theme")
        print("2. High contrast")
        print("3. Restore default")
        print("4. Assign shortcut")
        print("5. List shortcuts")
        print("0. Exit")
        return input("Option: ")
    
    @classmethod
    def execute_option(cls, option: str):
        """Execute selected option"""
        if option == "1":
            cls.apply_theme()
        elif option == "2":
            cls.high_contrast()
        elif option == "3":
            cls.restore_default()
        elif option == "4":
            cls.assign_shortcut()
        elif option == "5":
            cls.list_shortcuts()
        else:
            print("Invalid option")
    
    @classmethod
    def apply_theme(cls):
        """Apply UI theme"""
        theme = input("Enter theme name (dark/light): ")
        print(f"Theme '{theme}' applied")
    
    @classmethod
    def high_contrast(cls):
        """Enable high contrast mode"""
        print("High contrast activated")
    
    @classmethod
    def restore_default(cls):
        """Restore default UI settings"""
        cls._shortcuts.clear()
        print("Default values restored")
    
    @classmethod
    def assign_shortcut(cls):
        """Assign keyboard shortcut"""
        action = input("Enter action name: ")
        key = input("Enter shortcut key: ")
        cls._shortcuts[action] = key
        print(f"Shortcut assigned: {action} -> {key}")
    
    @classmethod
    def list_shortcuts(cls):
        """List all shortcuts"""
        if not cls._shortcuts:
            print("No shortcuts assigned")
        else:
            print("Current shortcuts:")
            for action, key in cls._shortcuts.items():
                print(f"  {action}: {key}")
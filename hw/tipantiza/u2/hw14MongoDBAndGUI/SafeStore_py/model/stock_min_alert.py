"""
Stock Minimum Alert Module
@author Alexander Tipantiza, The Softwarriors, @ESPE
"""

class StockMinAlert:
    """Stock alert management"""
    
    _min_stock = 10
    _max_stock = 100
    
    @classmethod
    def menu(cls):
        """Display stock alert menu"""
        print("\n--- STOCK ALERTS ---")
        print("1. Configure minimum stock")
        print("2. Configure maximum stock")
        print("3. Generate alert")
        print("4. Record movement")
        print("5. View current stock")
        print("0. Exit")
        return input("Option: ")
    
    @classmethod
    def execute_option(cls, option: str):
        """Execute selected option"""
        if option == "1":
            cls.configure_minimum()
        elif option == "2":
            cls.configure_maximum()
        elif option == "3":
            cls.generate_alert()
        elif option == "4":
            cls.record_movement()
        elif option == "5":
            cls.view_current_stock()
        else:
            print("Invalid option")
    
    @classmethod
    def configure_minimum(cls):
        """Configure minimum stock"""
        try:
            value = int(input("Enter minimum stock value: "))
            cls._min_stock = value
            print(f"Minimum stock configured to: {value}")
        except ValueError:
            print("Invalid value")
    
    @classmethod
    def configure_maximum(cls):
        """Configure maximum stock"""
        try:
            value = int(input("Enter maximum stock value: "))
            cls._max_stock = value
            print(f"Maximum stock configured to: {value}")
        except ValueError:
            print("Invalid value")
    
    @classmethod
    def generate_alert(cls):
        """Generate stock alert"""
        print(f"Stock alert generated. Min: {cls._min_stock}, Max: {cls._max_stock}")
    
    @classmethod
    def record_movement(cls):
        """Record stock movement"""
        print("Movement recorded")
    
    @classmethod
    def view_current_stock(cls):
        """View current stock"""
        print(f"Current stock: 100 units (Min: {cls._min_stock}, Max: {cls._max_stock})")
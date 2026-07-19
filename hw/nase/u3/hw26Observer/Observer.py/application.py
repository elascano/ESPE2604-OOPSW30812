from view.console import Console
from controller.stock_controller import StockController

# Jennyfer Nase

def main():
    view = Console()
    controller = StockController(view)
    
    controller.start_simulation()

if __name__ == "__main__":
    main()
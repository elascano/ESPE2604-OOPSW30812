from controller.beverage_controller import BeverageController

def main():
    controller = BeverageController()
    controller.prepare_all_beverages()

if __name__ == "__main__":
    main()
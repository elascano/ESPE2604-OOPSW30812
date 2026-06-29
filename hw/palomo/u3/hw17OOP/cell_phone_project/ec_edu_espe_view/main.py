from ec_edu_espe_model.battery import Battery
from ec_edu_espe_model.screen import Screen
from ec_edu_espe_model.sim_card import SIMCard
from ec_edu_espe_model.cell_phone import CellPhone
from ec_edu_espe_controller.phone_controller import PhoneController

def main():

    controller = PhoneController()

    while True:

        print("\n===== PHONE MENU =====")
        print("1. Register phone")
        print("2. Show phones")
        print("3. Exit")

        option = input("Choose an option: ")

        if option == "1":

            brand = input("Brand: ")
            model = input("Model: ")
            imei = input("IMEI: ")

            capacity = int(
                input("Battery capacity (mAh): ")
            )

            size = float(
                input("Screen size (inches): ")
            )

            operator = input("Operator: ")

            battery = Battery(capacity)
            screen = Screen(size)
            sim = SIMCard(operator)

            phone = CellPhone(
                brand,
                model,
                imei,
                battery,
                screen,
                sim
            )

            phone.show_info()

            controller.save_phone(phone)

        elif option == "2":
            controller.show_saved_phones()

        elif option == "3":
            print("Program finished.")
            break

        else:
            print("Invalid option.")

if __name__ == "__main__":
    main()
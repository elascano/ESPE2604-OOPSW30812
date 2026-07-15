from win_factory import WinFactory
from linux_factory import LinuxFactory
from mac_factory import MacFactory

print("===== SELECT OPERATING SYSTEM =====")
print("1. Windows")
print("2. Linux")
print("3. MacOS")

option = int(input("Option: "))

if option == 1:
    factory = WinFactory()

elif option == 2:
    factory = LinuxFactory()

elif option == 3:
    factory = MacFactory()

else:
    print("Invalid option")
    exit()

button = factory.create_button()
menu = factory.create_menu()

button.set_caption("Play")
menu.set_caption("File")

print("\nCreated components:")

button.paint()
menu.paint()
from controller.win_factory import WinFactory
from controller.linux_factory import LinuxFactory
from controller.mac_factory import MacFactory


class ClientApp:
    @staticmethod
    def main():
        factories = [WinFactory(), LinuxFactory(), MacFactory()]
        names = ["WINDOWS", "LINUX", "macOS"]

        for index, factory in enumerate(factories):
            print(f"----- {names[index]} -----")
            button = factory.create_button()
            menu = factory.create_menu()

            button.caption = "Play"
            menu.caption = "File"

            button.paint()
            menu.paint()


if __name__ == "__main__":
    ClientApp.main()

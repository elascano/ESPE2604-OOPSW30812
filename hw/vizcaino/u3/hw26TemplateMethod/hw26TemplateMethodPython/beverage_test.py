from tea import Tea
from coffee import Coffee

class BeverageTest:
    @staticmethod
    def main():
        tea = Tea()
        coffee = Coffee()

        print("\nMaking tea ...")
        tea.prepare_recipe()

        print("\nMaking coffee ...")
        coffee.prepare_recipe()

if __name__ == "__main__":
    BeverageTest.main()
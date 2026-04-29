# author: Didier Elbay
class Chicken:
    def __init__(self, id, name, color, age, is_molting):
        self.id = id
        self.name = name
        self.color = color
        self.age = age
        self.is_molting = is_molting

    def __str__(self):
        return f"Chicken{{id={self.id}, name={self.name}, color={self.color}, age={self.age}, molting={self.is_molting}}}"

def main():
    print("--- Chicken Farm Simulator (Python) ---")
    # Instanciar una gallina
    lucy = Chicken(1, "Lucy", "White", 2, True)
    print(lucy)

if __name__ == "__main__":
    main()
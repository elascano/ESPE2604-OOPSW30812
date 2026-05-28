from model import Truck, Package

def main():
    print("--- TRUCK SYSTEM ---")
    tk = Truck(input("ID: "), "Hino", 500, "Truck")

    while True:
        name = input("Package name (or 'done'): ")
        if name.lower() == 'done': break
        weight = float(input("Weight: "))
        tk.add_package(Package("ID-01", name, weight))

    tk.save_json()
    print("\nSaved! Reading from JSON:")
    print(Truck.read_json())

if __name__ == "__main__":
    main()
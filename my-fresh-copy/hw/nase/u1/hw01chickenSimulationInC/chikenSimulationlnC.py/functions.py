# Jennyfer Nase
def cluck(c):
    print(f"\n[{c.name}] says: CLUCK CLUCK!")

def eat(c):
    if c.daily_food < 50:
        c.daily_food += 6
        print(f"{c.name} food.")
    else:
        print("good.")

def show_status(c):
    print(f"Status de {c.name}: {c.daily_food} the food.")
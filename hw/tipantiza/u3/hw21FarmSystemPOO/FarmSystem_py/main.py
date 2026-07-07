from model.cow import Cow
from model.pig import Pig
from model.slaughter_house import SlaughterHouse
from datetime import datetime

def main():
    print("ANIMAL FARM SYSTEM\n")
    
    slaughter_house = SlaughterHouse(1, "ESPE SlaughterHouse", "Sangolqui, Matriz ESPE", "0997515132")
    
    pig = Pig(120.0, False, 88.0, "Duroc", datetime.now(), 1, slaughter_house, None, [])
    
    cow = Cow(2, False, "Holstein", datetime.now(), 450.0, slaughter_house, None, [], 0.0)
    
    print(f"Pig created: {pig.id} - {pig.breed}")
    print(f"Cow created: {cow.id} - {cow.breed}")
    
    print("\n---> Sending to SlaughterHouse")
    pig.send_to_slaughter_house(slaughter_house)
    cow.send_to_slaughter_house(slaughter_house)
    
    print("\nPROGRAM COMPLETED")

if __name__ == "__main__":
    main()
def manage_truck():
    maximum_capacity = 500
    current_weight = 0
  
    packages = []
    weights = []

    print(f"Maximum Capacity: {maximum_capacity}kg\n")

    while True:
        item_name = input("Enter package name (or type 'done' to finish): ")
        if item_name.lower() == 'done':
            break
            
        try:
            item_weight = float(input(f"Enter the weight of '{item_name}' in kg: "))
          
            if current_weight + item_weight <= maximum_capacity:
          
                packages.append(item_name)
                weights.append(item_weight)
                
                current_weight += item_weight
                print(f" Loaded! Current weight: {current_weight}kg / {maximum_capacity}kg")
            else:
                print(f" Too heavy! No space left for {item_name}.")
                
        except ValueError:
            print("Invalid input. Please enter a number for the weight.")

    
    print("\n" + "="*30)
    print("FINAL LOADING SUMMARY:")
    print("="*30)
    
    for i in range(len(packages)):
        print(f"Package {i+1}: {packages[i]} - {weights[i]}kg")
        
    print("-" * 30)
    print(f"Total packages: {len(packages)}")
    print(f"Total weight loaded: {current_weight}kg")
    print(f"Remaining space: {maximum_capacity - current_weight}kg")


manage_truck()

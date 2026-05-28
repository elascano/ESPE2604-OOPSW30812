┌─────────────────────────────────────────────┐
│      CONSTRUCTORS - CHICKEN FARM SIMULATOR EXAMPLE       │
├─────────────────────────────────────────────┤
│  Author: Alexander Tipantiza                             │
│  University: Universidad de las Fuerzas Armadas - ESPE   │
├─────────────────────────────────────────────┤
│  WHAT IS A CONSTRUCTOR?                                  │
│  A special method that INITIALIZES an object when it     │
│  is created. Same name as the class. No return type.     │
├─────────────────────────────────────────────┤
│  CLASSES USED                                            │
│  - ChickenFarm (main simulator class)                    │
│  - Chicken (individual chicken entity)                   │
├─────────────────────────────────────────────┤
│  CONSTRUCTOR - ChickenFarm                               │
│  Receives farm name and capacity. Initializes farm       │
│  attributes like name, max chickens, and an empty coop.  │
├─────────────────────────────────────────────┤
│  CONSTRUCTOR - Chicken                                   │
│  Receives ID and color. Initializes each chicken         │
│  with its own attributes (plus default eggs = 0).        │
├─────────────────────────────────────────────┤
│  HOW TO USE (CREATING OBJECTS)                           │
│  Use the keyword "new" followed by the constructor.      │
│  Example: new ChickenFarm("Sunny Coop", 10)              │
│  Example: new Chicken(1, "Brown")                        │
├─────────────────────────────────────────────┤
│  KEY RULES ABOUT CONSTRUCTORS                            │
│  1. Same name as the class                               │
│  2. No return type (not even void)                       │
│  3. Called automatically with 'new'                      │
│  4. You can have MULTIPLE constructors (overloading)     │
│  5. If none is written, Java provides a DEFAULT one      │
├─────────────────────────────────────────────┤
│  Alexander Tipantiza - ESPE                              │
└─────────────────────────────────────────────┘
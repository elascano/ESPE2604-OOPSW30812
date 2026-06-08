┌─────────────────────────────────────────────┐
│          ARRAYS IN PROGRAMMING - CHICKEN COOP EXAMPLE    │
├─────────────────────────────────────────────┤
│  Author: Alexander Tipantiza                             │
│  University: Universidad de las Fuerzas Armadas - ESPE   │
├─────────────────────────────────────────────┤
│  WHAT IS AN ARRAY?                                       │
│  A structure that stores MULTIPLE values of the same     │
│  type in a single variable. Access is by INDEX           │
│  (starts at 0).                                          │
├─────────────────────────────────────────────┤
│  MVC STRUCTURE USED                                      │
│  - package model: Chicken.java, ChickenFarm.java         │
│    (contains the ARRAY)                                  │
│  - package view: ChickenView.java                        │
│  - package controller: ChickenController.java            │
├─────────────────────────────────────────────┤
│  ARRAY CODE (inside ChickenFarm)                         │
│  private Chicken[] chickens;          // declare array   │
│  chickens = new Chicken[maxSize];     // create array    │
│  chickens[index] = newChicken;        // save            │
│  chickens[index]                     // access           │
├─────────────────────────────────────────────┤
│  KEY RULES                                               │
│  1. FIXED size when created                              │
│  2. First index = 0                                      │
│  3. Last index = size - 1                                │
│  4. Stores objects or primitive types                    │
├─────────────────────────────────────────────┤
│  Alexander Tipantiza - ESPE                              │
└─────────────────────────────────────────────┘
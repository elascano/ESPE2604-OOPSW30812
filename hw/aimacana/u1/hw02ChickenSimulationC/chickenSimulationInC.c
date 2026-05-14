#include <stdio.h>
#include <stdbool.h>
#include <string.h>
#include <stdlib.h>
#include <time.h>

typedef struct {
    char name[20];
    char featherColor[20];
    int age;
    bool isMolting;
    int number_of_eggs;
} Chicken;

void initializeChicken(Chicken* chicken, const char name[], const char featherColor[], int age, bool isMolting, int number_of_eggs) {
    strcpy(chicken->name, name);
    strcpy(chicken->featherColor, featherColor);
    chicken->age = age;
    chicken->isMolting = isMolting;
    chicken->number_of_eggs = number_of_eggs;
}

void cluck_chicken(Chicken chicken) {
    printf("%s says: '¡Coo-coo!'\n", chicken.name);
}

void wander_chicken(Chicken chicken) {
    printf("%s wanders around the coop.\n", chicken.name);
}

void eat_chicken(Chicken chicken) {
    printf("%s eats something.\n", chicken.name);
}

void drink_chicken(Chicken chicken) {
    printf("%s drinks water.\n", chicken.name);
}

void poop_chicken(Chicken chicken) {
    printf("%s poops.\n", chicken.name);
}

void lay_egg_chicken(Chicken* chicken) {
    if (chicken->isMolting) {
        chicken->number_of_eggs++;
        printf("%s lays an egg.\n", chicken->name);
    } else {
        printf("%s is molting and cannot lay eggs today.\n", chicken->name);
    }
}

void display_chicken(Chicken chicken) {
    printf("Name: %s | Color: %s | Age: %d | Molting: %s | Eggs: %d\n", 
           chicken.name, 
           chicken.featherColor, 
           chicken.age, 
           chicken.isMolting ? "Yes" : "No", 
           chicken.number_of_eggs);
}

void simulate_chicken(Chicken *chicken, int simulation_steps){
    for (int i = 0; i < simulation_steps; i++) {

        int random_chicken = rand() % 5;

        int random_action = rand() % 6;

        printf("[Event %d] ", i + 1);
        
        switch(random_action) {
            case 0: 
                cluck_chicken(chicken[random_chicken]); 
                break;
            case 1: 
                wander_chicken(chicken[random_chicken]); 
                break;
            case 2: 
                eat_chicken(chicken[random_chicken]); 
                break;
            case 3: 
                drink_chicken(chicken[random_chicken]); 
                break;
            case 4: 
                poop_chicken(chicken[random_chicken]); 
                break;
            case 5: 
                lay_egg_chicken(&chicken[random_chicken]); 
                break;
        }
    }
}

int main() {
    srand(time(NULL));

    Chicken chickens[5];

    initializeChicken(&chickens[0], "Colorada", "Brown", 2, false, 0);
    initializeChicken(&chickens[1], "Negrita", "White", 3, true, 0);
    initializeChicken(&chickens[2], "Lucy", "Black & White", 5, true, 0);
    initializeChicken(&chickens[3], "Pintadita", "Brown & White", 4, false, 0);
    initializeChicken(&chickens[4], "Josefina", "White", 1, true, 0);

    int simulation_steps = 15;

    printf("--- STARTING CHICKEN COOP SIMULATION ---\n\n");
    
    simulate_chicken(chickens, simulation_steps);
    
    printf("\n--- FINAL RESULTS OF THE CHICKEN COOP ---\n");
    for (int i = 0; i < 5; i++) {
        display_chicken(chickens[i]);
    }

    return 0;
}
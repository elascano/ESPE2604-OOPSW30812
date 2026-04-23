#include <stdio.h>
#include <string.h>
struct Chicken {
    char name[20];
    char color[30];
    int age;
    int eggs;
    int clucks;
    int timesEaten;
    int timesWandered;
};
void layEgg(struct Chicken *c) {
    c->eggs++;
    printf("%s laid an egg. Total eggs: %d\n", c->name, c->eggs);
}
void cluck(struct Chicken *c) {
    c->clucks++;
    printf("%s clucked. Total clucks: %d\n", c->name, c->clucks);
}
void eat(struct Chicken *c) {
    c->timesEaten++;
    printf("%s is eating. Times eaten: %d\n", c->name, c->timesEaten);
}
void wander(struct Chicken *c) {
    c->timesWandered++;
    printf("%s is wandering. Times wandered: %d\n", c->name, c->timesWandered);
}
void showChicken(struct Chicken c) {
    printf("\n--- Chicken State ---\n");
    printf("Name: %s\n", c.name);
    printf("Color: %s\n", c.color);
    printf("Age: %d\n", c.age);
    printf("Eggs: %d\n", c.eggs);
    printf("Clucks: %d\n", c.clucks);
    printf("Times eaten: %d\n", c.timesEaten);
    printf("Times wandered: %d\n", c.timesWandered);
}
int main() {
    struct Chicken lucy;
    int option;
    strcpy(lucy.name, "Lucy");
    strcpy(lucy.color, "Brown & White");
    lucy.age = 2;
    lucy.eggs = 0;
    lucy.clucks = 0;
    lucy.timesEaten = 0;
    lucy.timesWandered = 0;
    do {
        printf("\n***MENU***\n");
        printf("1. Lay an egg\n");
        printf("2. Cluck\n");
        printf("3. Eat\n");
        printf("4. Wander\n");
        printf("5. Show chicken data\n");
        printf("0. Exit\n");
        printf("Choose an option: ");
        scanf("%d", &option);
        switch(option) {
            case 1:
                layEgg(&lucy);
                break;
            case 2:
                cluck(&lucy);
                break;
            case 3:
                eat(&lucy);
                break;
            case 4:
                wander(&lucy);
                break;
            case 5:
                showChicken(lucy);
                break;
            case 0:
                printf("Program Terminated.\n");
                break;
            default:
                printf("Invalid option\n");
        }
    } while(option != 0);
    return 0;
}

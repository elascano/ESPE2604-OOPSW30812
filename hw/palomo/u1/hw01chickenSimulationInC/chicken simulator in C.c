#include <stdio.h>
char name[] = "Lucy";
char color[] = "Brown & White";
int age = 2;
int molting = 0;
int eggs = 0;
int poop = 0;
void cluck() {
    printf("%s says: Cluck!\n", name);
}

void wander() {
    printf("%s is walking and exploring.\n", name);
}

void eat() {
    printf("%s is eating.\n", name);
}

void drink() {
    printf("%s is drinking water.\n", name);
}

void doPoop() {
    poop++;
    printf("%s pooped. Total: %d\n", name, poop);
}

void layEgg() {
    eggs++;
    printf("%s laid an egg! Total: %d\n", name, eggs);
}

void showState() {
    printf("\nChicken state:\n");
    printf("Name: %s\n", name);
    printf("Color: %s\n", color);
    printf("Age: %d years\n", age);
    printf("Molting?: %s\n", molting ? "Yes" : "No");
    printf("Eggs laid: %d\n", eggs);
    printf("Poop count: %d\n\n", poop);
}

int main() {
    int option;
    do {
        printf("\n--- LUCY MENU ---\n");
        printf("1. Show state\n");
        printf("2. Cluck\n");
        printf("3. Walk\n");
        printf("4. Eat\n");
        printf("5. Drink\n");
        printf("6. Poop\n");
        printf("7. Lay an egg\n");
        printf("0. Exit\n");
        printf("Choose an option: ");
        scanf("%d", &option);

        switch(option) {
            case 1: showState(); break;
            case 2: cluck(); break;
            case 3: wander(); break;
            case 4: eat(); break;
            case 5: drink(); break;
            case 6: poop(); break;
            case 7: layAyEgg(); break;
            case 0: printf("Exiting program...\n"); break;
            default: printf("Invalid option try again.\n");
        }
    } while(option != 0);

    return 0;
}

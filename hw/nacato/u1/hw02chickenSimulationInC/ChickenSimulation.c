#include <stdio.h>

char name[] = "Lucy";
char color[] = "Brown and White";
int age = 2;
int eggs = 0;
int poopCount = 0;

void cluck() {
    printf("\nCluck cluck!\n");
}

void eat() {
    printf("\n%s is eating corn...\n", name);
}

void drink() {
    printf("\n%s is drinking water...\n", name);
}

void poop() {
    poopCount++; 
    printf("\n%s pooped. Total: %d\n", name, poopCount);
}

void layAnEgg() {
    eggs++;
    printf("\n%s laid an egg. Total: %d\n", name, eggs);
}

void showInformation() {
    printf("\nCHICKEN INFORMATION\n");
    printf("Name: %s\n", name);
    printf("Color: %s\n", color);
    printf("Age: %d years\n", age);
    printf("Eggs laid: %d\n", eggs);
    printf("Accumulated poop: %d\n", poopCount);
}

int main() {
    int option = -1;

    while (option != 7) {
        printf("\nLUCY'S ACTIONS\n");
        printf("1. Show Information\n");
        printf("2. Cluck\n");
        printf("3. Eat\n");
        printf("4. Drink\n");
        printf("5. Poop\n");
        printf("6. Lay an egg\n");
        printf("7. Exit\n");
        printf("Select an option: ");
        scanf("%d", &option);

        switch (option) {
            case 1: showInformation(); break;
            case 2: cluck(); break;
            case 3: eat(); break;
            case 4: drink(); break;
            case 5: poop(); break;
            case 6: layAnEgg(); break;
            case 7: printf("Exiting...\n"); break;
            default: printf("Invalid option.\n"); break;
        }
    }

    return 0;
}
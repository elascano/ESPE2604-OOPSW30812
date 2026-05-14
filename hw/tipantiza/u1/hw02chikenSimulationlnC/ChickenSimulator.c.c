#include <stdio.h>

typedef struct {
    char name[20];
    char color[20];
    int age;
    int isMolting;
    int eggs;
    int poopCount;
} Chicken;

void showInformation(Chicken chicken) {
    printf("\n--Chicken Information\n");
    printf("Name: %s\n", chicken.name);
    printf("Color: %s\n", chicken.color);
    printf("Age: %d\n", chicken.age);
    printf("Molting: %s\n", chicken.isMolting ? "Yes" : "No");
    printf("Eggs: %d\n", chicken.eggs);
    printf("Poop: %d\n", chicken.poopCount);
}

void cluck() {
    printf("\nCluck cluck!\n");
}

void wander() {
    printf("\nLucy is wandering around the yard.\n");
}

void eat() {
    printf("\nLucy is pecking at some grain. Yum!\n");
}

void drink() {
    printf("\nLucy is taking a sip of water.\n");
}

void poop(Chicken *chicken) {
    chicken->poopCount++;
    printf("\nOops! Lucy just pooped. Total poop: %d\n", chicken->poopCount);
}

void layEgg(Chicken *chicken) {
    chicken->eggs++;
    printf("\nCluck cluck! Lucy laid an egg.\n");
    printf("Total eggs: %d\n", chicken->eggs);
}

int main() {
    Chicken lucy = {"Lucy", "Brown & White", 2, 0, 0, 0};
    int userSelection;

    do {
        printf("\n--Actions\n");
        printf("1. Show information\n");
        printf("2. Cluck\n");
        printf("3. Wander\n");
        printf("4. Eat\n");
        printf("5. Drink\n");
        printf("6. Poop\n");
        printf("7. Lay an egg\n");
        printf("8. Exit\n");
        printf("Select an option: ");

        scanf("%d", &userSelection);

        switch (userSelection) {
            case 1:
                showInformation(lucy);
                break;
            case 2:
                cluck();
                break;
            case 3:
                wander();
                break;
            case 4:
                eat();
                break;
            case 5:
                drink();
                break;
            case 6:
                poop(&lucy);
                break;
            case 7:
                layEgg(&lucy);
                break;
            case 8:
                printf("Goodbye!\n");
                break;
        }

    } while (userSelection != 8);

    return 0;
}


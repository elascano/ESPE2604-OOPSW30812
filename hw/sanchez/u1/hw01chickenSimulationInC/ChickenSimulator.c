#include <stdio.h>
#include <string.h>

struct Chicken{
    char name[30];
    char color[30];
    int ageInYears;
    int molting;
    int numberOfEggs;
    int numberOfPoop;
};

void showInformation(struct Chicken *chicken);
void cluck(void);
void wander(struct Chicken *chicken);
void eat(struct Chicken *chicken);
void drink(struct Chicken *chicken);
void poop(struct Chicken *chicken);
void layAnEgg(struct Chicken *chicken);
void clearInputBuffer(void);

int main(){
    struct Chicken lucy;
    int option;

    strcpy(lucy.name, "Lucy");
    strcpy(lucy.color, "Brown & White");
    lucy.ageInYears = 2;
    lucy.molting = 0;
    lucy.numberOfEggs = 0;
    lucy.numberOfPoop = 0;

    do {
        printf("\nCHICKEN ACTIONS\n\n");
        printf("1. Show information\n");
        printf("2. Cluck\n");
        printf("3. Wander\n");
        printf("4. Eat\n");
        printf("5. Drink\n");
        printf("6. Poop\n");
        printf("7. Lay an egg\n");
        printf("8. Exit\n\n");
        printf("Select an option: ");

        scanf("%d", &option);

        switch(option) {
            case 1:
                showInformation(&lucy);
                break;
            case 2:
                cluck();
                break;
            case 3:
                wander(&lucy);
                break;
            case 4:
                eat(&lucy);
                break;
            case 5:
                drink(&lucy);
                break;
            case 6:
                poop(&lucy);
                break;
            case 7:
                layAnEgg(&lucy);
                break;
            case 8:
                printf("\nExited the program\n");
                break;
            default:
                printf("\nInvalid option.\n");
        }

    } while(option != 8);

    return 0;
}

void showInformation(struct Chicken *chicken){
    printf("\nChicken Information\n");
    printf("Name: %s\n", chicken->name);
    printf("Color: %s\n", chicken->color);
    printf("Age: %d years\n", chicken->ageInYears);

    if(chicken->molting == 0){
        printf("Molting: No\n");
    } else {
        printf("Molting: Yes\n");
    }

    printf("Eggs: %d\n", chicken->numberOfEggs);
    printf("Poop: %d\n\n", chicken->numberOfPoop);
}

void cluck(void){
    printf("\nCluck cluck \n");
}

void wander(struct Chicken *chicken){
    printf("\n%s is wandering\n", chicken->name);
}

void eat(struct Chicken *chicken){
    printf("\n%s is eating\n", chicken->name);
}

void drink(struct Chicken *chicken){
    printf("\n%s is drinking water\n", chicken->name);
}

void poop(struct Chicken *chicken){
    chicken->numberOfPoop++;
    printf("\n%s pooped\n", chicken->name);
    printf("Total poop: %d\n", chicken->numberOfPoop);
}

void layAnEgg(struct Chicken *chicken){
    if(chicken->molting == 0) {
        chicken->numberOfEggs++;
        printf("\n%s laid an egg\n", chicken->name);
        printf("Total eggs: %d\n", chicken->numberOfEggs);
    } else {
        printf("\n%s cannot lay eggs\n", chicken->name);
    }
}

#include <stdio.h>
#include <string.h>

struct Chicken{
    char name[20];
    int age;
    float weight;
    int eggsPerWeek;
    char foodType[30];
    char color[20];
};

void showInformation(struct Chicken c){
    printf("\n--- LUCY INFORMATION ---\n");
    printf("Name: %s\n", c.name);
    printf("Age: %d years\n", c.age);
    printf("Weight: %.2f kg\n", c.weight);
    printf("Eggs per week: %d\n", c.eggsPerWeek);
    printf("Food type: %s\n", c.foodType);
    printf("Color: %s\n", c.color);
}

int main(){
    struct Chicken lucy;
    int option;

    strcpy(lucy.name, "Lucy");
    lucy.age = 3;
    lucy.weight = 2.2;
    lucy.eggsPerWeek = 5;
    strcpy(lucy.foodType, "Corn and grains");
    strcpy(lucy.color, "Brown");

    do {
        printf("\n--- MENU ---\n");
        printf("1. Show all information\n");
        printf("2. Show age\n");
        printf("3. Show weight\n");
        printf("4. Show eggs per week\n");
        printf("5. Show food type\n");
        printf("6. Show color\n");
        printf("7. Exit\n");
        printf("Select an option: ");
        scanf("%d", &option);

        switch(option){
            case 1:
                showInformation(lucy);
                break;
            case 2:
                printf("\nAge: %d years\n", lucy.age);
                break;
            case 3:
                printf("\nWeight: %.2f kg\n", lucy.weight);
                break;
            case 4:
                printf("\nEggs per week: %d\n", lucy.eggsPerWeek);
                break;
            case 5:
                printf("\nFood type: %s\n", lucy.foodType);
                break;
            case 6:
                printf("\nColor: %s\n", lucy.color);
                break;
            case 7:
                printf("\nExiting...\n");
                break;
            default:
                printf("\nInvalid option\n");
        }

    } while(option != 7);

    return 0;
}

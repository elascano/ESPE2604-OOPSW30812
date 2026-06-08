#include <stdio.h>
#include <string.h>

struct Chicken{
    char name[50];
    char color[30];
    int ageInYears;
    int molting;
    int numberOfEggs;
    int numberOfPoop;
};

void showInformation(struct Chicken *p){
    printf("\n--Chicken Information\n");
    printf("Name: %s\n", (*p).name);
    printf("Color: %s\n", (*p).color);
    printf("Age: %d\n", (*p).ageInYears);

    if((*p).molting == 0){
        printf("Molting: No\n");
    }else{
        printf("Molting: Yes\n");
    }

    printf("Eggs: %d\n", (*p).numberOfEggs);
    printf("Poop: %d\n", (*p).numberOfPoop);
}

void cluck(){
    printf("\nCluck cluck!\n");
}

void wander(struct Chicken *p){
    printf("\n%s is wandering\n", (*p).name);
}

void eat(struct Chicken *p){
    printf("\n%s is eating\n", (*p).name);
}

void drink(struct Chicken *p){
    printf("\n%s is drinking water\n", (*p).name);
}

void poop(struct Chicken *p){
    (*p).numberOfPoop++;
    printf("\n%s pooped\nTotal poop: %d\n", (*p).name, (*p).numberOfPoop);
}

void layAnEgg(struct Chicken *p){
    if ((*p).molting == 0) {
        (*p).numberOfEggs++;
        printf("\nCluck cluck! %s laid an egg \nTotal eggs: %d\n", (*p).name, (*p).numberOfEggs);
    } else {
        printf("\n%s cannot lay eggs\n", (*p).name);
    }
}

int main(){
    struct Chicken lucy;

    strcpy(lucy.name, "Lucy");
    strcpy(lucy.color, "Brown & White");
    lucy.ageInYears = 2;
    lucy.molting = 0;
    lucy.numberOfEggs = 0;
    lucy.numberOfPoop = 0;

    int option;

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
        scanf("%d", &option);

        switch(option) {
            case 1:
                showInformation(&lucy); break;
            case 2:
                cluck(); break;
            case 3:
                wander(&lucy); break;
            case 4:
                eat(&lucy); break;
            case 5:
                drink(&lucy); break;
            case 6:
                poop(&lucy); break;
            case 7:
                layAnEgg(&lucy); break;
            case 8:
                printf("Exit\n"); break;
            default:
                printf("Invalid option\n");
        }

    } while(option != 8);

    return 0;
}


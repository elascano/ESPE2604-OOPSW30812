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
    struct Chicken leafie;

    strcpy(leafie.name, "Leafie");
    strcpy(leafie.color, "Brown & White");
    leafie.ageInYears = 2;
    leafie.molting = 0;
    leafie.numberOfEggs = 0;
    leafie.numberOfPoop = 0;

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
                showInformation(&leafie); break;
            case 2:
                cluck(); break;
            case 3:
                wander(&leafie); break;
            case 4:
                eat(&leafie); break;
            case 5:
                drink(&leafie); break;
            case 6:
                poop(&leafie); break;
            case 7:
                layAnEgg(&leafie); break;
            case 8:
                printf("Exit\n"); break;
            default:
                printf("Invalid option\n");
        }

    } while(option != 8);

    return 0;
}

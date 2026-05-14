#include <stdio.h>

void makeCluck(int *howManyTimesClucked);
void letWander(int *howManyTimesWandered);
void giveFood(int *howManyTimesAte);
void giveDrink(int *howManyTimesDrank);
void poop(int *howManyTimesPooped);
void layEgg(int *howManyTimesLaidEggs);
void showMenu();
int getValidOption();

int main()
{
    int menuOption;
    int howManyTimesClucked = 0;
    int howManyTimesWandered = 0;
    int howManyTimesAte = 0;
    int howManyTimesDrank = 0;
    int howManyTimesPooped = 0;
    int howManyTimesLaidEggs = 0;

    printf("Chicken care simulator\n");

    do
    {
        showMenu();
        menuOption = getValidOption();

        switch (menuOption)
        {
        case 1:
            makeCluck(&howManyTimesClucked);
            break;
        case 2:
            letWander(&howManyTimesWandered);
            break;
        case 3:
            giveFood(&howManyTimesAte);
            break;
        case 4:
            giveDrink(&howManyTimesDrank);
            break;
        case 5:
            poop(&howManyTimesPooped);
            break;
        case 6:
            layEgg(&howManyTimesLaidEggs);
            break;
        case 7:
            printf("Exiting the simulator...\n");
            break;
        }

    } while (menuOption != 7);

    printf("\nFINAL CHICKEN REPORT\n");
    printf("Clucked: %d times\n", howManyTimesClucked);
    printf("Wandered: %d times\n", howManyTimesWandered);
    printf("Ate: %d times\n", howManyTimesAte);
    printf("Drank: %d times\n", howManyTimesDrank);
    printf("Pooped: %d times\n", howManyTimesPooped);
    printf("Laid eggs: %d times\n", howManyTimesLaidEggs);

    return 0;
}

void showMenu()
{
    printf("\nCHICKEN CARE MENU:\n");
    printf("1) Make the chicken cluck\n");
    printf("2) Let the chicken wander\n");
    printf("3) Give food to the chicken\n");
    printf("4) Give drink to the chicken\n");
    printf("5) Make the chicken poop\n");
    printf("6) Make the chicken lay an egg\n");
    printf("7) Exit\n");
    printf("Select an option: ");
}

int getValidOption()
{
    char userInput[50];
    int menuOption;

    fgets(userInput, sizeof(userInput), stdin);

    if (sscanf(userInput, "%d", &menuOption) != 1)
    {
        printf("Only numbers from 1 to 7, try again: ");
    }
    else if (menuOption < 1 || menuOption > 7)
    {
        printf("Value out of range, try again: ");
    }

    return menuOption;
}

void makeCluck(int *howManyTimesClucked)
{
    (*howManyTimesClucked)++;
    if (*howManyTimesClucked == 4)
        printf("Cluckkk cluckkk cof cof cof\n");
    else
        printf("Cluck Cluck\n");
}

void letWander(int *howManyTimesWandered)
{
    (*howManyTimesWandered)++;
    if (*howManyTimesWandered == 4)
        printf("Chicken lost, wanted\n");
    else
        printf("The chicken is wandering\n");
}

void giveFood(int *howManyTimesAte)
{
    (*howManyTimesAte)++;
    if (*howManyTimesAte == 4)
        printf("It became chicken with rice\n");
    else
        printf("The chicken is eating\n");
}

void giveDrink(int *howManyTimesDrank)
{
    (*howManyTimesDrank)++;
    if (*howManyTimesDrank == 4)
        printf("Chicken soup\n");
    else
        printf("The chicken drank water\n");
}

void poop(int *howManyTimesPooped)
{
    (*howManyTimesPooped)++;
    if (*howManyTimesPooped == 4)
        printf("Chicken emptied\n");
    else
        printf("The chicken pooped\n");
}

void layEgg(int *howManyTimesLaidEggs)
{
    (*howManyTimesLaidEggs)++;
    if (*howManyTimesLaidEggs == 4)
        printf("It resigned\n");
    else
        printf("The chicken laid an egg\n");
}
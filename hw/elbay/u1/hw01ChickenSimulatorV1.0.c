#include <stdio.h>

int main() {
    int option;
    int eggs = 0;
    int age;
    int poop = 0;

    printf("Enter the hen's age: ");
    scanf("%d", &age);

    do {
        printf("\n--- HEN MENU ---\n");
        printf("1. Lay egg\n");
        printf("2. Show number of eggs\n");
        printf("3. Cluck\n");
        printf("4. Poop\n");
        printf("5. Show hen information\n");
        printf("6. Exit\n");
        printf("Select an option: ");
        scanf("%d", &option);

        switch(option) {
            case 1:
                eggs++;
                printf("The hen laid an egg\n");
                break;

            case 2:
                printf("The hen has laid %d eggs\n", eggs);
                break;

            case 3:
                printf("clo clo\n");
                break;

            case 4:
                poop++;
                printf("The hen pooped\n");
                break;

            case 5:
                printf("\n--- INFORMATION ---\n");
                printf("Age: %d years\n", age);
                printf("Eggs: %d\n", eggs);
                printf("Times pooped: %d\n", poop);
                break;

            case 6:
                printf("Exiting program...\n");
                break;

            default:
                printf("Invalid option\n");
        }

    } while(option != 6);

    return 0;
}

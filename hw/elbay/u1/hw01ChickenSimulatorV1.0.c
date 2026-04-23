#include <stdio.h>

int main() {
    int option;
    int eggs = 0;
    int age;
    int poop = 0;
    char name[50];

    printf("Enter the hen's name: ");
    scanf("%s", name);

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
                printf("%s laid an egg\n", name);
                break;

            case 2:
                printf("%s has laid %d eggs\n", name, eggs);
                break;

            case 3:
                printf("%s says: clo clo\n", name);
                break;

            case 4:
                poop++;
                printf("%s pooped\n", name);
                break;

            case 5:
                printf("\n--- INFORMATION ---\n");
                printf("Name: %s\n", name);
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

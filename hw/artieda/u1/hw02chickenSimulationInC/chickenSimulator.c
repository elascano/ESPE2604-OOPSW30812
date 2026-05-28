#include <stdio.h>
#include <string.h>

struct MyChicken {
    char name[20];
    int eggs;
    int poop;
};

void eat(struct MyChicken *c) {
    printf("%s is eating corn\n", c->name);
}

void drink(struct MyChicken *c) {
    printf("%s is drinking water\n", c->name);
}

void poop(struct MyChicken *c) {
    c->poop++;
    printf("%s pooped. Total: %d\n", c->name, c->poop);
}

void layEgg(struct MyChicken *c) {
    c->eggs++;
    printf("%s laid an egg. Total: %d\n", c->name, c->eggs);
}

void cluck(struct MyChicken *c) {
    printf("%s says: cluck cluck\n", c->name);
}

int main() {
    struct MyChicken lucy;
    strcpy(lucy.name, "Lucy");
    lucy.eggs = 0;
    lucy.poop = 0;

    int option;

    do {
        printf("\n--- Lucy the Chicken ---\n");
        printf("Act 1. Eat\n");
        printf("Act 2. Drink\n");
        printf("Act 3. Poop\n");
        printf("Act 4. Lay Egg\n");
        printf("Act 5. Cluck\n");
        printf("Act 6. Exit\n");
        printf("Select an option: ");
        scanf("%d", &option);

        switch(option) {
            case 1: eat(&lucy); break;
            case 2: drink(&lucy); break;
            case 3: poop(&lucy); break;
            case 4: layEgg(&lucy); break;
            case 5: cluck(&lucy); break;
            case 6: printf("Goodbye\n"); break;
            default: printf("Invalid option\n");
        }

    } while(option != 6);

    return 0;
}
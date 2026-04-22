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

void showInformation(struct Chicken *c) {
    printf("\nChicken Information\n");
    printf("Name: %s\n", c->name);
    printf("Color: %s\n", c->color);
    printf("Age: %d\n", c->ageInYears);
    printf("Molting: %s\n", c->molting ? "Yes" : "No");
    printf("Eggs: %d\n", c->numberOfEggs);
	printf("Poop: %d\n", c->numberOfPoop);
}

void cluck(struct Chicken *c) { 
    printf("\n%s says: Cluck cluck!\n", c->name); 
}
void wander(struct Chicken *c) {
    printf("\n%s is wandering\n", c->name);
}
void eat(struct Chicken *c) {
    printf("\n%s is eating\n", c->name);
}
void drink(struct Chicken *c) {
    printf("\n%s drinking water\n", c->name);
}
void poop(struct Chicken *c) {
    printf("\n%s pooped (Total: %d)\n", c->name, ++c->numberOfPoop);
}
void layAnEgg(struct Chicken *c) { 
    if(!c->molting) 
        printf("\n%s laid an egg! (Total: %d)\n", c->name, ++c->numberOfEggs);
    else 
        printf("\n%s is molting, no egg today\n", c->name);
}

int main() {
    struct Chicken lucy = {"Lucy", "Brown & White", 2, 0, 0, 0};
    int option;
    do {
        printf("\n<<Lucy Actions>");
        printf("\n1. Information");    
        printf("\n2. Cluck");
        printf("\n3. Wander");
        printf("\n4. Eat");
        printf("\n5. Drink");
        printf("\n6. Poop"); 
        printf("\n7. Lay an Egg"); 
        printf("\n8. Exit\n");
        printf("Select an option: ");
        scanf("%d", &option);
        
        switch(option) {
            case 1: 
                showInformation(&lucy);
                break;
            case 2: 
                cluck(&lucy); 
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
                printf("\nGoodbye! ??\n");
                break;
            default:                 
                printf("\nInvalid option.\n");
                break;                 
        }
    } while(option!= 8);
    
    return 0;
}

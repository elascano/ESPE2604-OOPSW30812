#include <iostream>

using namespace std;

string name = "Lucy";
int eggs = 0;

void doAction(string action) {
    cout < < ">> " < < name < < " is " < < action < < endl;
}

int main() {
    int opt = 1;

    while (opt >= 1 && opt <= 6) {
        cout < < "\n--- CHICKEN ACTIONS ---" < < endl;
        cout < < "1. Cluck  2. Wander  3. Eat" < < endl;
        cout < < "4. Drink  5. Poop    6. Lay Egg" < < endl;
        cout < < "Select (any other number to exit): ";
        cin > > opt;

        switch(opt) {
            case 1: doAction("clucking: Cluck cluck"); break;
            case 2: doAction("wandering around"); break;
            case 3: doAction("eating corn"); break;
            case 4: doAction("drinking water"); break;
            case 5: doAction("doing poop"); break;
            case 6: 
                eggs++; 
                cout < < ">> Egg laid Total eggs: " < < eggs < < endl; 
                break;
            default: cout < < "Exiting program" < < endl; break;
        }
    }
    return 0;
}

	#include <iostream>
	#include <string>

	using namespace std;

	string name = "Lucy";
	string color = "Brown and White";
	int age = 2;
	bool isMolting = false;
	int eggCounter = 0;

	void cluck() 
	{
    cout << name << ": Cluck cluck!" << endl;
	}

	void wander() 
	{
    cout << name << " is wandering around." << endl;
	}

	void eat() 		
	{
    cout << name << " is eating." << endl;
	}

	void drink() 
	{
    cout << name << " is drinking." << endl;
	}

	void poop() 	
	{
    cout << name << " did poop." << endl;
	}

	void layAnEgg() 
	{
    eggCounter++;
    cout << name << " laid an egg! Total: " << eggCounter << endl;
	}

	void showState() 
	{
    	cout << " Chicken State " << endl;
    	cout << "Name: " << name << endl;
    	cout << "Color: " << color << endl;
    	cout << "Age: " << age << " years old" << endl;
    	cout << "Molting: " << (isMolting ? "Yes" : "No") << endl;
    	cout << "Eggs: " << eggCounter << endl;
    	cout << "---------------------" << endl;
	}

	int main() 
	{
    int option;

    do 
		{
        cout << "1. cluck" << endl;
        cout << "2. wander" << endl;
        cout << "3. eat" << endl;
        cout << "4. drink" << endl;
        cout << "5. poop" << endl;
        cout << "6. lay an egg" << endl;
        cout << "7. show state" << endl;
        cout << "0. exit" << endl;
        cout << "Select behavior: ";
        cin >> option;

        switch(option) 	
			{
            case 1: cluck(); break;
            case 2: wander(); break;
            case 3: eat(); break;
            case 4: drink(); break;
            case 5: poop(); break;
            case 6: layAnEgg(); break;
            case 7: showState(); break;
            case 0: cout << "Exiting..." << endl; break;
            default: cout << "Invalid option." << endl;
        	}
        
    	} while (option != 0);

    return 0;
	}
	 


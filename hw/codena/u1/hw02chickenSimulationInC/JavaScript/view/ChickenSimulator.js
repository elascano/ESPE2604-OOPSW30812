import Chicken from "../model/Chicken.js";
import PromptSync from "prompt-sync";

const prompt = new PromptSync();

let chicken = new Chicken(
    "Lucy",
    "Brown and White",
    2,
    false,
    0,
    0
)

let option = 1;

do {

    console.log("\n---Actions---");
    console.log("1. Show information\n2. Cluck\n3. Wander");
    console.log("4. Eat\n5. Drink\n6. Poop");
    console.log("7. Lay an egg\n8. Exit");

    try{

        option = Number(prompt("Select an option: "));

        switch(option){

            case 1:
                chicken.showInformation();
                break;

            case 2:
                chicken.cluck();
                break;

            case 3:
                chicken.wander();
                break;

            case 4: 
                chicken.eat();
                break;

            case 5:
                chicken.drink();
                break;
            
            case 6:
                chicken.poop();
                break;
            
            case 7:
                chicken.layAnEgg();
                break;
            
            case 8:
                console.log("\nFinish");
                break;

            default:
                console.log("\nIncorrect option.");
        }

    } catch (error){
        console.log("\nEnter a valid number.")
    }
    
    
} while (option != 8);

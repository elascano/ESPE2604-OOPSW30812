/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/ClientSide/javascript.js to edit this template
 */
/**
 *
 * @author Joel Sanchez, The Softwarriors, @ESPE
 */
import { Person } from '../model/Person.js';

function printTheCollection(things) {
    console.log(`\nsize of things --> ${things.length}`);
    console.log("These are my things --> \n", things);
}


function main() {
    let id, fullName, bornOnDate, alive;
    
    
    id = 1;
    fullName = "Sanchez Joel";
    bornOnDate = new Date(2006, 6, 4);  
    alive = true;
    
    let person = new Person(id, fullName, bornOnDate, alive);
    
    console.log(person.toString());
    console.log(`Age of person 1 is ${person.computeAgeInYears()}`);
    
    
    id = 2;
    fullName = "Veronica Lanchimba";
    bornOnDate = new Date(1982, 0, 4);  
    alive = false;
    
    let person2 = new Person(id, fullName, bornOnDate, alive);
    
    console.log(`Age of person 2 is ${person2.computeAgeInYears()}`);
    
   
    let things = [];
    console.log(`\nsize of things --> ${things.length}`);
    
    things.push(8000);
    things.push(3.5);
    things.push("Quito");
    things.push(true);
    
    printTheCollection(things);
    
    things.push(person);
    things.push(person2);
    
    printTheCollection(things);
    
    things.push(4078.76);
    things.push("a");
    
    printTheCollection(things);
    
    
    let people = [];
    people.push(person);
    people.push(person2);
    
    console.log("\npeople -->", people);
    console.log("");
    
    people.forEach((p) => {
        console.log(`Person --> ${p.toString()}`);
    });
}

main();


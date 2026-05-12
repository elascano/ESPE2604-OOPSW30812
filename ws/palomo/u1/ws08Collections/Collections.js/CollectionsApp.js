/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/ClientSide/javascript.js to edit this template
 */

const Person = require('./Person.js');

let id = 1;
let fullName = "Cristian Palomo";
let bornOnDate = "2005-01-23";
let alive = true;

const person = new Person(id, fullName, bornOnDate, alive);
console.log(person.toString());
console.log("Age of person 1 is " + person.computeAge());

id = 2;
fullName = "Monica Perez";
bornOnDate = "2000-11-23";
alive = false;

const person2 = new Person(id, fullName, bornOnDate, alive);
console.log("Age of person 2 is " + person2.computeAge());

let things = [];
console.log("size of things --> []");

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

let integers = [];
integers.push(5);
integers.push(id);

let people = [];
people.push(person);
people.push(person2);

console.log("");
console.log("people --> [" + people.map(p => p.toString()).join(", ") + "]");
console.log("");

people.forEach((p) => {
    console.log("Person --> " + p.toString());
});

people.forEach((p) => {
    console.log("Person --> " + p.toString());
});

function printTheCollection(collection) {
    console.log("\nsize of things --> " + collection.length);
    
    const elements = collection.map(item => {
        if (item && typeof item.toString === 'function' && item.toString !== Object.prototype.toString && item.toString !== Array.prototype.toString) {
            return item.toString();
        }
        return String(item);
    }).join(", ");
    
    console.log("These are my things --> \n[" + elements + "]");
}

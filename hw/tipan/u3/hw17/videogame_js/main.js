const Warrior = require("./warrior");
const Mage = require("./mage");
const Archer = require("./archer");
const Team = require("./team");

const w = new Warrior(1, "Arthur", 10, 100);
const m = new Mage(2, "Merlin", 12, 80);
const a = new Archer(3, "Robin", 11, 90);

console.log("--- CHARACTERS ---");
w.displayInfo();
m.displayInfo();
a.displayInfo();

console.log("\n--- POLYMORPHISM ---");
w.attack();
m.attack();
a.attack();

console.log("\n--- TEAM ---");
const team = new Team("Legends");
team.addMember(w);
team.addMember(m);
team.addMember(a);
team.showTeam();
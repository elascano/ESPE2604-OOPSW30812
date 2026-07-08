import { Cow } from './model/cow.js';
import { Pig } from './model/pig.js';
import { SlaughterHouse } from './model/slaughter-house.js';

function main() {
    console.log("ANIMAL FARM SYSTEM\n");
    
    const slaughterHouse = new SlaughterHouse(1, "ESPE SlaughterHouse", "Sangolqui, Matriz ESPE", "0997515132");
    
    const pig = new Pig(120.0, false, 88.0, "Duroc", new Date(), 1, slaughterHouse, null, []);
    
    const cow = new Cow(2, false, "Holstein", new Date(), 450.0, slaughterHouse, null, [], 0.0);
    
    console.log(`Pig created: ${pig.id} - ${pig.breed}`);
    console.log(`Cow created: ${cow.id} - ${cow.breed}`);
    
    console.log("\n---> Sending to SlaughterHouse");
    pig.sendToSlaughterHouse(slaughterHouse);
    cow.sendToSlaughterHouse(slaughterHouse);
    
    console.log("\nPROGRAM COMPLETED");
}

main();
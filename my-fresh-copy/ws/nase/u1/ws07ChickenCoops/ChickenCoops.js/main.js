//author Jennyfer Nase
import { Chicken } from './chicken.js';

function main() {
    console.log("Quiez 2026-04-26 Jennyfer Nase");

    const chickens = [
        new Chicken(1, "Lucy", "brown and white", 0, false, "Sat May 09 15:10:16 ECT 2026"),
        new Chicken(2, "Jennyfer Nase", "Black", 0, false, "Fri Aug 10 00:00:00 ECT 1906"),
        new Chicken(3, "Fernanda", "Red", 0, true, "Fri Aug 10 00:00:00 ECT 1906"),
        new Chicken(4, "Maria", "Brown", 0, true, "Fri Aug 10 00:00:00 ECT 1906"),
        new Chicken(5, "Maria", "Brown", 0, true, "Fri Aug 10 00:00:00 ECT 1906")
    ];

    chickens.forEach((chick, index) => {
        console.log(`chicken[${index + 1}]${chick.toString()}`);
    });
}

main();
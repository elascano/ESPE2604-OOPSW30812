
import { SDCard } from './model/SDCard.js';

import { ConsoleView } from './view/ConsoleView.js';

import { FileManager } from './util/FileManager.js';

const fileManager =
    new FileManager('./data/sdcards.json');

let sdCards =
    fileManager.load();

const consoleView =
    new ConsoleView();

async function main() {

    let option = 0;

    while (option !== 5) {

        consoleView.showMenu();

        option = parseInt(
            await consoleView.ask(
                "Select option: "
            )
        );

        if (option === 1) {

            const id = parseInt(
                await consoleView.ask(
                    "Enter ID: "
                )
            );

            const brand =
                await consoleView.ask(
                    "Enter brand: "
                );

            const capacity = parseInt(
                await consoleView.ask(
                    "Enter capacity: "
                )
            );

            const price = parseFloat(
                await consoleView.ask(
                    "Enter price: "
                )
            );

            const newCard =
                new SDCard(
                    id,
                    brand,
                    capacity,
                    price
                );

            sdCards.push(newCard);

            fileManager.save(sdCards);

            console.log(
                "SD Card created"
            );
        }

        else if (option === 2) {

            console.log("\n=== SD CARDS ===");

            sdCards.forEach(card => {

                console.log(
                    `${card.id} | ` +
                    `${card.brand} | ` +
                    `${card.capacity}GB | ` +
                    `$${card.price}`
                );
            });
        }

        else if (option === 3) {

            const searchId = parseInt(
                await consoleView.ask(
                    "Enter ID: "
                )
            );

            const foundCard =
                sdCards.find(
                    card => card.id === searchId
                );

            if (foundCard) {

                console.log(
                    `${foundCard.id} | ` +
                    `${foundCard.brand} | ` +
                    `${foundCard.capacity}GB | ` +
                    `$${foundCard.price}`
                );
            }

            else {

                console.log(
                    "SD Card not found"
                );
            }
        }

        else if (option === 4) {

            const deleteId = parseInt(
                await consoleView.ask(
                    "Enter ID: "
                )
            );

            sdCards =
                sdCards.filter(
                    card => card.id !== deleteId
                );

            fileManager.save(sdCards);

            console.log(
                "SD Card deleted"
            );
        }

        else if (option === 5) {

            console.log("Goodbye");
        }

        else {

            console.log(
                "Invalid option"
            );
        }
    }

    consoleView.close();
}

main();
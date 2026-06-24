import * as readline from "readline-sync";

import { Battery } from "../model/Battery";
import { Screen } from "../model/Screen";
import { SIMCard } from "../model/SIMCard";
import { CellPhone } from "../model/CellPhone";

import { PhoneController } from "../controller/PhoneController";

const controller = new PhoneController();

let option = "";

while (option !== "3") {

    console.log("\n===== PHONE MENU =====");
    console.log("1. Register Phone");
    console.log("2. Show Phones");
    console.log("3. Exit");

    option = readline.question("Option: ");

    switch (option) {

        case "1":

            const brand =
                readline.question("Brand: ");

            const model =
                readline.question("Model: ");

            const imei =
                readline.question("IMEI: ");

            const batteryCapacity =
                Number(readline.question("Battery (mAh): "));

            const screenSize =
                Number(readline.question("Screen Size: "));

            const operator =
                readline.question("Operator: ");

            const battery =
                new Battery(batteryCapacity);

            const screen =
                new Screen(screenSize);

            const simCard =
                new SIMCard(operator);

            const phone =
                new CellPhone(
                    brand,
                    model,
                    imei,
                    battery,
                    screen,
                    simCard
                );

            phone.showInfo();

            controller.savePhone(phone);

            break;

        case "2":

            controller.showPhones();

            break;

        case "3":

            console.log("Program finished.");

            break;

        default:

            console.log("Invalid option.");
    }
}
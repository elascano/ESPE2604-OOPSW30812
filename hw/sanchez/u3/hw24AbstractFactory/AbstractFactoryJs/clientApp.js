const readline = require("readline");

const WinFactory = require("./winFactory");
const LinuxFactory = require("./linuxFactory");
const MacFactory = require("./macFactory");

const rl = readline.createInterface({
    input: process.stdin,
    output: process.stdout
});

console.log("===== SELECT OPERATING SYSTEM =====");
console.log("1. Windows");
console.log("2. Linux");
console.log("3. MacOS");

rl.question("Option: ", (option) => {

    let factory;

    switch (option) {
        case "1":
            factory = new WinFactory();
            break;

        case "2":
            factory = new LinuxFactory();
            break;

        case "3":
            factory = new MacFactory();
            break;

        default:
            console.log("Invalid option");
            rl.close();
            return;
    }

    const button = factory.createButton();
    const menu = factory.createMenu();

    button.setCaption("Play");
    menu.setCaption("File");

    console.log("\nCreated components:");

    button.paint();
    menu.paint();

    rl.close();
});
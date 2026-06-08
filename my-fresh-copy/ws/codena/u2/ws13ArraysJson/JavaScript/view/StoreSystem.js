const readline = require("readline");

const ProductView = require("./ProductView");
const ProductController = require("../controller/ProductController");

const view = new ProductView();

const controller = new ProductController(view);

const rl = readline.createInterface({
    input: process.stdin,
    output: process.stdout
});

function mainMenu() {

    view.showMenu();

    rl.question("\nChoose an option: ", (option) => {

        switch (option) {

            case "1":

                rl.question("Enter product name: ", (name) => {

                    rl.question("Enter weight in pounds: ", (weight) => {

                        controller.addProduct(
                            name,
                            parseFloat(weight)
                        );

                        controller.saveProductsToJSON();

                        mainMenu();
                    });
                });

                break;

            case "2":

                controller.readProductsAndConvert();

                mainMenu();

                break;

            case "3":

                console.log("\nProgram finished.");

                rl.close();

                break;

            default:

                console.log("\nInvalid option.");

                mainMenu();
        }
    });
}

mainMenu();
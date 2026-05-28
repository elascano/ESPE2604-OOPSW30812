class ChickenView {

    showMenu() {

        console.log("\n--- MENU ---");
        console.log("1. Show all information");
        console.log("2. Show age");
        console.log("3. Show weight");
        console.log("4. Show eggs per week");
        console.log("5. Show food type");
        console.log("6. Show color");
        console.log("7. Exit");
    }

    showInformation(chicken) {

        console.log("\n--- LUCY INFORMATION ---");
        console.log(`Name: ${chicken.name}`);
        console.log(`Age: ${chicken.age} years`);
        console.log(`Weight: ${chicken.weight.toFixed(2)} kg`);
        console.log(`Eggs per week: ${chicken.eggsPerWeek}`);
        console.log(`Food type: ${chicken.foodType}`);
        console.log(`Color: ${chicken.color}`);
    }

    showMessage(message) {
        console.log(message);
    }
}

module.exports = ChickenView;
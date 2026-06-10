/**
 * ShoppingCenter.js
 * Clase principal del Shopping Center
 * @author Cristian 
 */
const Customer = require('./src/Customer');

function main() {
    console.log("=== Shopping Center ===");
    const customer1 = new Customer(
        1,
        "Juan",
        "Pérez",
        "M",
        150.75,
        30,
        "Regular",
        ["lectura", "fútbol", "música"]
    );

    const customer2 = new Customer(
        2,
        "María",
        "López",
        "F",
        320.50,
        25,
        "VIP",
        ["viajes", "cocina"]
    );
    console.log("\nClientes registrados:");
    console.log(customer1.toString());
    console.log(customer2.toString());
    console.log(`\nNombre del cliente 1: ${customer1.getFirstName()} ${customer1.getLastName()}`);
    customer1.setMoneySpent(customer1.getMoneySpent() + 50);
    console.log(`Dinero gastado actualizado: $${customer1.getMoneySpent()}`);
}

main();

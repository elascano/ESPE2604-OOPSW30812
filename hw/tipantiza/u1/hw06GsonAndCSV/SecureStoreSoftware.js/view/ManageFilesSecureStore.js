import promptSync from "prompt-sync";

import Product from "../model/Product.js";
import CustomerAnalytics from "../model/CustomerAnalytics.js";
import SupplierManager from "../model/SupplierManager.js";
import FileManager from "../model/FileManager.js";

const prompt = promptSync();

let running = true;

while (running) {

    console.log("\n=== SECURE STORE MENU ===");
    console.log("1. Add Product");
    console.log("2. Add Customer Analytics");
    console.log("3. Add Supplier");
    console.log("4. Exit");

    let option = Number(prompt("Choose an option: "));

    switch(option) {

        case 1:

            console.log("\n--- Enter Product Data ---");

            let pId = Number(prompt("ID: "));
            let pName = prompt("Name: ");
            let pStock = Number(prompt("Stock: "));
            let pPrice = Number(prompt("Price: "));

            let product = new Product(
                pId,
                pName,
                pStock,
                pPrice
            );

            FileManager.saveProductCSV(product);
            FileManager.saveProductJSON(product);

            console.log("Product saved.");
            break;

        case 2:

            console.log("\n--- Enter Customer Data ---");

            let cId = Number(prompt("ID: "));
            let cName = prompt("Customer Name: ");
            let cCategory = prompt(
                "Purchase Category: "
            );

            let customer = new CustomerAnalytics(
                cId,
                cName,
                cCategory
            );

            FileManager.saveCustomerCSV(customer);
            FileManager.saveCustomerJSON(customer);

            console.log("Customer data saved.");
            break;

        case 3:

            console.log("\n--- Enter Supplier Data ---");

            let sId = Number(prompt("ID: "));
            let sName = prompt("Supplier Name: ");
            let sEmail = prompt("Email: ");

            let supplier = new SupplierManager(
                sId,
                sName,
                sEmail
            );

            FileManager.saveSupplierCSV(supplier);
            FileManager.saveSupplierJSON(supplier);

            console.log("Supplier saved.");
            break;

        case 4:

            running = false;
            console.log("Program finished.");
            break;

        default:

            console.log("Invalid option.");
    }
}

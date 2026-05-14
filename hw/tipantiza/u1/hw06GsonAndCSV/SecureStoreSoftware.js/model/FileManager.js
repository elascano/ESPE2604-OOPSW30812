import fs from "fs";

class FileManager {

    // PRODUCTS
    static saveProductCSV(product) {

        const data =
            `${product.id},${product.name},${product.stock},${product.price}\n`;

        fs.appendFileSync("products.csv", data);
    }

    static saveProductJSON(product) {

        let products = [];

        if (fs.existsSync("products.json")) {
            const fileData = fs.readFileSync("products.json");
            products = JSON.parse(fileData);
        }

        products.push(product);

        fs.writeFileSync(
            "products.json",
            JSON.stringify(products, null, 2)
        );
    }

    // CUSTOMERS
    static saveCustomerCSV(customer) {

        const data =
            `${customer.id},${customer.customerName},${customer.purchaseCategory}\n`;

        fs.appendFileSync("customers.csv", data);
    }

    static saveCustomerJSON(customer) {

        let customers = [];

        if (fs.existsSync("customers.json")) {
            const fileData = fs.readFileSync("customers.json");
            customers = JSON.parse(fileData);
        }

        customers.push(customer);

        fs.writeFileSync(
            "customers.json",
            JSON.stringify(customers, null, 2)
        );
    }

    // SUPPLIERS
    static saveSupplierCSV(supplier) {

        const data =
            `${supplier.id},${supplier.supplierName},${supplier.contactEmail}\n`;

        fs.appendFileSync("suppliers.csv", data);
    }

    static saveSupplierJSON(supplier) {

        let suppliers = [];

        if (fs.existsSync("suppliers.json")) {
            const fileData = fs.readFileSync("suppliers.json");
            suppliers = JSON.parse(fileData);
        }

        suppliers.push(supplier);

        fs.writeFileSync(
            "suppliers.json",
            JSON.stringify(suppliers, null, 2)
        );
    }
}

export default FileManager;

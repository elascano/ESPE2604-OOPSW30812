class ProductView {

    showMenu() {

        console.log("\n===== STORE SYSTEM =====");

        console.log("1. Add products and save to JSON");
        console.log("2. Read JSON and show weights in kilograms");
        console.log("3. Exit");
    }

    showMessage(message) {

        console.log(message);
    }

    showProducts(products) {

        console.log("\n=== PRODUCTS IN KILOGRAMS ===");

        products.forEach(product => {

            console.log(
                `Name: ${product.name} | Kilograms: ${product.weightKilograms.toFixed(2)} kg`
            );
        });
    }
}

module.exports = ProductView;
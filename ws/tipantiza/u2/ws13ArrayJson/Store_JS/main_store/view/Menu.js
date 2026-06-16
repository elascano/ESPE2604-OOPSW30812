const fileSystem = require('fs');
const readlineInterface = require('readline');
const Product = require('../model/Product');

/**
 *
 * @author Alexander Tipantiza, The Softwarriors, @ESPE
 */

const productsData = JSON.parse(
    fileSystem.readFileSync('./data/products.json', 'utf8')
);

let shoppingCart = [];

const productList = productsData.map(
    product =>
        new Product(
            product.id,
            product.nombre,
            product.categoria,
            product.precio
        )
);

const userInput = readlineInterface.createInterface({
    input: process.stdin,
    output: process.stdout
});

function saveProductsToFile() {

    fileSystem.writeFileSync(
        './data/products.json',
        JSON.stringify(productsData, null, 2)
    );
}

function displayProducts() {

    console.log('\n==== PRODUCT LIST ====\n');

    productsData.forEach(product => {

        console.log(
            `ID: ${product.id}
Name: ${product.nombre}
Category: ${product.categoria}
Price: $${product.precio}\n`
        );
    });
}

function addNewProduct() {

    userInput.question('Enter product name: ', (productName) => {

        userInput.question('Enter product category: ', (productCategory) => {

            userInput.question('Enter product price: ', (productPrice) => {

                const newProduct = {
                    id: productsData.length + 1,
                    nombre: productName,
                    categoria: productCategory,
                    precio: parseFloat(productPrice)
                };

                productsData.push(newProduct);

                saveProductsToFile();

                console.log('\nProduct successfully added\n');

                displayMenu();
            });
        });
    });
}

function purchaseProduct() {

    displayProducts();

    userInput.question('Enter product ID: ', (productId) => {

        const selectedProduct = productsData.find(
            product => product.id == productId
        );

        if (!selectedProduct) {
            console.log('\nProduct not found\n');
            return displayMenu();
        }

        userInput.question('Enter quantity: ', (quantityInput) => {

            const quantity = parseInt(quantityInput);

            const subtotal = selectedProduct.precio * quantity;
            const tax = subtotal * 0.12;
            const total = subtotal + tax;

            shoppingCart.push({
                name: selectedProduct.nombre,
                category: selectedProduct.categoria,
                quantity: quantity,
                subtotal: subtotal,
                tax: tax,
                total: total
            });

            console.log('\nProduct added to cart\n');

            displayMenu();
        });
    });
}

function displayInvoice() {

    console.log('\n==== INVOICE ====\n');

    let totalSubtotal = 0;
    let totalTax = 0;
    let totalAmount = 0;

    shoppingCart.forEach(item => {

        console.log(
            `Product: ${item.name}
Quantity: ${item.quantity}
Subtotal: ${item.subtotal.toFixed(2)}
Tax: ${item.tax.toFixed(2)}
Total: ${item.total.toFixed(2)}\n`
        );

        totalSubtotal += item.subtotal;
        totalTax += item.tax;
        totalAmount += item.total;
    });

    console.log('=========================');
    console.log(`Subtotal: $${totalSubtotal.toFixed(2)}`);
    console.log(`Tax 12%: $${totalTax.toFixed(2)}`);
    console.log(`Total: $${totalAmount.toFixed(2)}`);
    console.log('=========================\n');

    displayMenu();
}

function updateProduct() {

    displayProducts();

    userInput.question('Enter product ID to update: ', (productId) => {

        const productIndex = productsData.findIndex(
            product => product.id == productId
        );

        if (productIndex === -1) {
            console.log('\nProduct not found\n');
            return displayMenu();
        }

        userInput.question('Enter new name: ', (newName) => {

            userInput.question('Enter new category: ', (newCategory) => {

                userInput.question('Enter new price: ', (newPrice) => {

                    productsData[productIndex].nombre = newName;
                    productsData[productIndex].categoria = newCategory;
                    productsData[productIndex].precio = parseFloat(newPrice);

                    saveProductsToFile();

                    console.log('\nProduct updated successfully\n');

                    displayMenu();
                });
            });
        });
    });
}

function displayMenu() {

    console.log(`
======== MENU ========

1. Display products
2. Add product
3. Purchase product
4. Show invoice
5. Update product
6. Exit

======================
    `);

    userInput.question('Select an option: ', (option) => {

        switch (option) {

            case '1':
                displayProducts();
                displayMenu();
                break;

            case '2':
                addNewProduct();
                break;

            case '3':
                purchaseProduct();
                break;

            case '4':
                displayInvoice();
                break;

            case '5':
                updateProduct();
                break;

            case '6':
                console.log('\nGoodbye\n');
                userInput.close();
                break;

            default:
                displayMenu();
        }
    });
}

module.exports = displayMenu;

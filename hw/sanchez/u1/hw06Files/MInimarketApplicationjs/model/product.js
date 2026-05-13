const fs = require('fs');
const csv = require('csv-parser');

class Product {
    constructor(id, name, expirationDate, stock, price) {
        this.id = id;
        this.name = name;
        this.expirationDate = expirationDate;
        this.stock = stock;
        this.price = price;
        this.discount = 0;
    }

    getId() { return this.id; }
    getName() { return this.name; }
    getExpirationDate() { return this.expirationDate; }
    getStock() { return this.stock; }
    getPrice() { return this.price; }
    getDiscount() { return this.discount; }

    setId(id) { this.id = id; }
    setName(name) { this.name = name; }
    setExpirationDate(expirationDate) { this.expirationDate = expirationDate; }
    setStock(stock) { this.stock = stock; }
    setPrice(price) { this.price = price; }
    setDiscount(discount) { this.discount = discount; }

    getPriceWithDiscount() {
        return this.price * (100 - this.discount) / 100;
    }

    calculateDaysUntilExpiration() {
        const today = new Date();
        today.setHours(0, 0, 0, 0);
        const expDate = new Date(this.expirationDate);
        const diffTime = expDate - today;
        return Math.ceil(diffTime / (1000 * 60 * 60 * 24));
    }

    calculateAndAssignDiscount() {
        const days = this.calculateDaysUntilExpiration();
        if (days >= 0 && days <= 2) {
            this.discount = 50;
        } else if (days <= 4) {
            this.discount = 25;
        } else if (days <= 7) {
            this.discount = 10;
        } else {
            this.discount = 0;
        }
    }

    showAlert() {
        const days = this.calculateDaysUntilExpiration();
        console.log(`Producto: ${this.name}`);
        console.log(`ID: ${this.id}`);
        console.log(`Stock actual: ${this.stock}`);
        console.log(`Dias hasta caducar: ${days}`);
        if (days >= 0 && days <= 7) {
            console.log("ALERTA Producto proximo a caducar");
            console.log(`Descuento sugerido: ${this.discount}%`);
            console.log(`Precio original: $${this.price.toFixed(2)}`);
            console.log(`Precio con descuento: $${this.getPriceWithDiscount().toFixed(2)}\n`);
        } else if (days < 0) {
            console.log("Producto caducado Retirar del stock inmediatamente\n");
        } else {
            console.log("Producto en buen estado\n");
        }
    }

    static async readCSV(filePath) {
        const products = [];
        return new Promise((resolve, reject) => {
            if (!fs.existsSync(filePath)) {
                console.log(`Archivo no encontrado: ${filePath}`);
                resolve(products);
                return;
            }
            fs.createReadStream(filePath)
                .pipe(csv())
                .on('data', (row) => {
                    products.push(new Product(
                        row.id, row.name, row.expirationDate,
                        parseInt(row.stock), parseFloat(row.price)
                    ));
                })
                .on('end', () => {
                    console.log("Archivo CSV leido correctamente");
                    resolve(products);
                })
                .on('error', (err) => {
                    console.log(`Error al leer el archivo CSV: ${err.message}`);
                    reject(err);
                });
        });
    }

    static getProductMap(products) {
        const map = new Map();
        products.forEach(p => map.set(p.name, p));
        return map;
    }

    static getStockMap(products) {
        const map = new Map();
        products.forEach(p => map.set(p.name, p.stock));
        return map;
    }

    static exportToJSON(products, filePath) {
        const dir = require('path').dirname(filePath);
        if (!fs.existsSync(dir)) {
            fs.mkdirSync(dir, { recursive: true });
        }
        const data = products.map(p => ({
            id: p.id, name: p.name, expirationDate: p.expirationDate,
            stock: p.stock, price: p.price, discount: p.discount
        }));
        fs.writeFileSync(filePath, JSON.stringify(data, null, 4), 'utf8');
        console.log(`Archivo JSON de productos generado: ${filePath}`);
    }
}

module.exports = Product;
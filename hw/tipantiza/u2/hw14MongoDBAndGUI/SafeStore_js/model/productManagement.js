/**
 * Product Management Module
 * @author Alexander Tipantiza, The Softwarriors, @ESPE
 */

class Product {
    constructor(productId, name, stock, retailPrice, wholesalePrice) {
        this.id = productId;
        this.name = name;
        this.stock = stock;
        this.retailPrice = retailPrice;
        this.wholesalePrice = wholesalePrice;
    }
    
    getId() { return this.id; }
    getName() { return this.name; }
    getStock() { return this.stock; }
    getRetailPrice() { return this.retailPrice; }
    getWholesalePrice() { return this.wholesalePrice; }
    setStock(stock) { this.stock = stock; }
}

class ProductManagement {
    static #products = [];
    
    static #initSampleProducts() {
        if (this.#products.length === 0) {
            this.#products = [
                new Product(1, "Laptop", 50, 800.00, 750.00),
                new Product(2, "Mouse", 100, 25.00, 20.00),
                new Product(3, "Keyboard", 75, 45.00, 38.00),
                new Product(4, "Monitor", 30, 200.00, 180.00),
                new Product(5, "Printer", 5, 150.00, 130.00),
            ];
        }
    }
    
    static findById(productId) {
        this.#initSampleProducts();
        return this.#products.find(p => p.getId() === productId);
    }
    
    static updateProductStock(productId, newStock) {
        const product = this.findById(productId);
        if (product) {
            product.setStock(newStock);
        }
    }
    
    static getAllProducts() {
        this.#initSampleProducts();
        return [...this.#products];
    }
}

module.exports = { Product, ProductManagement };
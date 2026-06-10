/**
 * Sale System Module
 * @author Alexander Tipantiza, The Softwarriors, @ESPE
 */

const fs = require('fs');
const path = require('path');
const { ProductManagement } = require('./productManagement');

const SALES_FILE = path.join(__dirname, '..', 'data', 'sales.json');
const HOLD_FILE = path.join(__dirname, '..', 'data', 'sales_hold.json');

class SaleItem {
    constructor(productId, productName, quantity, unitPrice) {
        this.productId = productId;
        this.productName = productName;
        this.quantity = quantity;
        this.unitPrice = unitPrice;
        this.totalPrice = quantity * unitPrice;
    }
    
    setQuantity(quantity) {
        this.quantity = quantity;
        this.totalPrice = this.quantity * this.unitPrice;
    }
    
    setUnitPrice(unitPrice) {
        this.unitPrice = unitPrice;
        this.totalPrice = this.quantity * this.unitPrice;
    }
}

class Sale {
    constructor(saleId, customerName, saleType, paymentMethod, items = []) {
        this.saleId = saleId;
        this.customerName = customerName;
        this.saleType = saleType;
        this.paymentMethod = paymentMethod;
        this.items = items;
        this.date = new Date();
        this.subtotal = 0;
        this.tax = 0;
        this.total = 0;
        this.calculateTotals();
    }
    
    addItem(item) {
        this.items.push(item);
        this.calculateTotals();
    }
    
    calculateTotals() {
        this.subtotal = this.items.reduce((sum, item) => sum + item.totalPrice, 0);
        this.tax = this.subtotal * 0.15;
        this.total = this.subtotal + this.tax;
    }
    
    toJSON() {
        return {
            saleId: this.saleId,
            customerName: this.customerName,
            saleType: this.saleType,
            paymentMethod: this.paymentMethod,
            date: this.date.toISOString(),
            items: this.items.map(item => ({
                productId: item.productId,
                productName: item.productName,
                quantity: item.quantity,
                unitPrice: item.unitPrice,
                totalPrice: item.totalPrice
            })),
            subtotal: this.subtotal,
            tax: this.tax,
            total: this.total
        };
    }
    
    static fromJSON(data) {
        const items = data.items.map(item => new SaleItem(
            item.productId, item.productName, item.quantity, item.unitPrice
        ));
        const sale = new Sale(data.saleId, data.customerName, data.saleType, data.paymentMethod, items);
        sale.date = new Date(data.date);
        return sale;
    }
}

class SaleSystem {
    static #sales = [];
    static #pendingSale = null;
    
    static #loadSales() {
        if (fs.existsSync(SALES_FILE)) {
            try {
                const data = JSON.parse(fs.readFileSync(SALES_FILE, 'utf-8'));
                this.#sales = data.map(s => Sale.fromJSON(s));
            } catch (error) {
                console.log(`Error loading sales: ${error.message}`);
            }
        }
    }
    
    static #saveSales() {
        try {
            fs.writeFileSync(SALES_FILE, JSON.stringify(this.#sales.map(s => s.toJSON()), null, 2), 'utf-8');
        } catch (error) {
            console.log(`Error saving sales: ${error.message}`);
        }
    }
    
    static #saveHold() {
        if (this.#pendingSale) {
            try {
                fs.writeFileSync(HOLD_FILE, JSON.stringify(this.#pendingSale.toJSON(), null, 2), 'utf-8');
            } catch (error) {
                console.log(`Error saving hold: ${error.message}`);
            }
        }
    }
    
    static #loadHold() {
        if (fs.existsSync(HOLD_FILE)) {
            try {
                const data = JSON.parse(fs.readFileSync(HOLD_FILE, 'utf-8'));
                this.#pendingSale = Sale.fromJSON(data);
            } catch (error) {
                console.log(`Error loading hold: ${error.message}`);
            }
        }
    }
    
    static startNewSale(customerName, saleType, paymentMethod) {
        this.#loadSales();
        const saleId = this.#sales.length + 1;
        this.#pendingSale = new Sale(saleId, customerName, saleType, paymentMethod);
        console.log(`New sale started - ID: ${saleId}`);
        return this.#pendingSale;
    }
    
    static addProductToCurrentSale(productId, quantity) {
        if (!this.#pendingSale) {
            console.log("No active sale. Start a new sale first.");
            return false;
        }
        
        const product = ProductManagement.findById(productId);
        if (!product) {
            console.log("Product not found");
            return false;
        }
        
        if (quantity > product.getStock()) {
            console.log(`Insufficient stock. Available: ${product.getStock()}`);
            return false;
        }
        
        const unitPrice = (this.#pendingSale.saleType.toLowerCase() === "wholesale" && quantity >= 12) 
            ? product.getWholesalePrice() 
            : product.getRetailPrice();
        
        const item = new SaleItem(productId, product.getName(), quantity, unitPrice);
        this.#pendingSale.addItem(item);
        
        ProductManagement.updateProductStock(productId, product.getStock() - quantity);
        
        console.log(`Product added: ${quantity} x ${product.getName()} - $${unitPrice.toFixed(2)} each`);
        console.log(`Current subtotal: $${this.#pendingSale.subtotal.toFixed(2)}`);
        return true;
    }
    
    static finalizeSale() {
        if (!this.#pendingSale || this.#pendingSale.items.length === 0) {
            console.log("No active sale with products");
            return false;
        }
        
        console.log("\nSALE SUMMARY");
        console.log(`Customer: ${this.#pendingSale.customerName}`);
        console.log(`Type: ${this.#pendingSale.saleType}`);
        console.log(`Subtotal: $${this.#pendingSale.subtotal.toFixed(2)}`);
        console.log(`IVA (15%): $${this.#pendingSale.tax.toFixed(2)}`);
        console.log(`TOTAL: $${this.#pendingSale.total.toFixed(2)}`);
        
        this.#sales.push(this.#pendingSale);
        this.#saveSales();
        console.log(`Sale #${this.#pendingSale.saleId} finalized`);
        this.#pendingSale = null;
        return true;
    }
    
    static holdCurrentSale() {
        if (!this.#pendingSale) {
            console.log("No active sale to hold");
            return;
        }
        
        this.#saveHold();
        console.log("Sale put on hold. You can attend the next customer.");
        this.#pendingSale = null;
    }
    
    static resumeHoldSale() {
        this.#loadHold();
        
        if (!this.#pendingSale) {
            console.log("No sale on hold");
            return;
        }
        
        console.log(`Held sale resumed - ID: ${this.#pendingSale.saleId}`);
        console.log(`Customer: ${this.#pendingSale.customerName}`);
        console.log(`Items in cart: ${this.#pendingSale.items.length}`);
    }
    
    static getCurrentSale() {
        return this.#pendingSale;
    }
    
    static getAllSales() {
        this.#loadSales();
        return [...this.#sales];
    }
    
    static searchSale(saleId) {
        this.#loadSales();
        return this.#sales.find(s => s.saleId === saleId);
    }
}

module.exports = { SaleSystem, Sale, SaleItem };
const fs = require('fs');
const csv = require('csv-parser');

class PromotionalBundle {
    constructor(bundleId, name, product1, quantity1, product2, quantity2, product3, quantity3, bundlePrice) {
        this.bundleId = bundleId;
        this.name = name;
        this.product1 = product1;
        this.quantity1 = quantity1;
        this.product2 = product2;
        this.quantity2 = quantity2;
        this.product3 = product3;
        this.quantity3 = quantity3;
        this.bundlePrice = bundlePrice;
        this.profitMargin = 0;
    }

    getBundleId() { return this.bundleId; }
    getName() { return this.name; }
    getProduct1() { return this.product1; }
    getQuantity1() { return this.quantity1; }
    getProduct2() { return this.product2; }
    getQuantity2() { return this.quantity2; }
    getProduct3() { return this.product3; }
    getQuantity3() { return this.quantity3; }
    getBundlePrice() { return this.bundlePrice; }
    getProfitMargin() { return this.profitMargin; }

    setBundleId(bundleId) { this.bundleId = bundleId; }
    setName(name) { this.name = name; }
    setBundlePrice(bundlePrice) { this.bundlePrice = bundlePrice; }
    setProfitMargin(profitMargin) { this.profitMargin = profitMargin; }

    static async readCSV(filePath) {
        const bundles = [];
        return new Promise((resolve, reject) => {
            if (!fs.existsSync(filePath)) {
                console.log(`Archivo no encontrado: ${filePath}`);
                resolve(bundles);
                return;
            }
            fs.createReadStream(filePath)
                .pipe(csv())
                .on('data', (row) => {
                    bundles.push(new PromotionalBundle(
                        row.bundleId, row.name, row.product1, parseInt(row.quantity1),
                        row.product2, parseInt(row.quantity2), row.product3, parseInt(row.quantity3),
                        parseFloat(row.bundlePrice)
                    ));
                })
                .on('end', () => {
                    console.log("Archivo de paquetes leido correctamente");
                    resolve(bundles);
                })
                .on('error', (err) => {
                    console.log(`Error al leer paquetes: ${err.message}`);
                    reject(err);
                });
        });
    }

    calculateCostPrice(productMap) {
        let totalCost = 0;
        totalCost += this.getProductCost(this.product1, this.quantity1, productMap);
        totalCost += this.getProductCost(this.product2, this.quantity2, productMap);
        totalCost += this.getProductCost(this.product3, this.quantity3, productMap);
        return totalCost;
    }

    getProductCost(productName, quantity, productMap) {
        if (!productName || productName === "0" || quantity === 0) return 0;
        const product = productMap.get(productName);
        return product ? product.getPrice() * quantity : 0;
    }

    calculateProfitMargin(productMap) {
        const totalCost = this.calculateCostPrice(productMap);
        if (this.bundlePrice > 0) {
            this.profitMargin = ((this.bundlePrice - totalCost) / this.bundlePrice) * 100;
        }
    }

    hasPositiveProfit() {
        return this.profitMargin > 0;
    }

    hasEnoughStock(stockMap) {
        const checks = [
            [this.product1, this.quantity1],
            [this.product2, this.quantity2],
            [this.product3, this.quantity3]
        ];
        for (const [product, qty] of checks) {
            if (product && product !== "0" && qty > 0) {
                if (!stockMap.has(product) || stockMap.get(product) < qty) {
                    return false;
                }
            }
        }
        return true;
    }

    static exportToJSON(bundles, filePath) {
        const dir = require('path').dirname(filePath);
        if (!fs.existsSync(dir)) {
            fs.mkdirSync(dir, { recursive: true });
        }
        const data = bundles.map(b => ({
            bundleId: b.bundleId, name: b.name, product1: b.product1,
            quantity1: b.quantity1, product2: b.product2, quantity2: b.quantity2,
            product3: b.product3, quantity3: b.quantity3, bundlePrice: b.bundlePrice,
            profitMargin: b.profitMargin
        }));
        fs.writeFileSync(filePath, JSON.stringify(data, null, 4), 'utf8');
        console.log(`Archivo JSON de paquetes generado: ${filePath}`);
    }
}

module.exports = PromotionalBundle;
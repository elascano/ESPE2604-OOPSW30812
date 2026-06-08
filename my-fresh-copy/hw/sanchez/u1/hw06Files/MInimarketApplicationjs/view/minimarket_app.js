const readline = require('readline');
const path = require('path');
const fs = require('fs');
const Product = require('../model/product');
const PromotionalBundle = require('../model/promotional_bundle');
const CashRegister = require('../model/cash_register');

const rl = readline.createInterface({
    input: process.stdin,
    output: process.stdout
});

const DATA_DIR = path.join(__dirname, '..', 'data');

function ensureDataDir() {
    if (!fs.existsSync(DATA_DIR)) {
        fs.mkdirSync(DATA_DIR, { recursive: true });
        console.log("Carpeta data creada");
    }
}

function question(prompt) {
    return new Promise(resolve => rl.question(prompt, resolve));
}

async function systemExpirationAlerts() {
    console.log("\n   SISTEMA DE ALERTAS DE CADUCIDAD\n");
    ensureDataDir();
    
    const productsPath = path.join(DATA_DIR, 'products.csv');
    const products = await Product.readCSV(productsPath);
    
    if (products.length === 0) {
        console.log("No hay productos para mostrar. Verifica el archivo products.csv");
        return;
    }
    
    for (const product of products) {
        product.calculateAndAssignDiscount();
    }
    
    console.log("\nREPORTE DE CADUCIDAD\n");
    for (const product of products) {
        product.showAlert();
    }
    
    console.log("\nGENERANDO ARCHIVO JSON ");
    Product.exportToJSON(products, path.join(DATA_DIR, 'productos.json'));
    console.log("\nGRACIAS");
}

async function systemPromotionalBundles() {
    console.log("\n    SISTEMA DE PAQUETES PROMOCIONALES\n");
    ensureDataDir();
    
    const productsPath = path.join(DATA_DIR, 'products.csv');
    const bundlesPath = path.join(DATA_DIR, 'promotional_bundles.csv');
    
    const products = await Product.readCSV(productsPath);
    const bundles = await PromotionalBundle.readCSV(bundlesPath);
    
    if (products.length === 0) {
        console.log("No hay productos. Verifica el archivo products.csv");
        return;
    }
    
    if (bundles.length === 0) {
        console.log("No hay paquetes. Verifica el archivo promotional_bundles.csv");
        return;
    }
    
    const productMap = Product.getProductMap(products);
    const stockMap = Product.getStockMap(products);
    
    console.log("\nValidando Paquetes\n");
    for (const bundle of bundles) {
        bundle.calculateProfitMargin(productMap);
        console.log(`\nPaquete: ${bundle.name}`);
        console.log(`Precio: $${bundle.bundlePrice.toFixed(2)}`);
        console.log(`Margen de ganancia: ${bundle.profitMargin.toFixed(2)}%`);
        console.log(`Rentable: ${bundle.hasPositiveProfit() ? 'Si' : 'No'}`);
        console.log(`Stock suficiente: ${bundle.hasEnoughStock(stockMap) ? 'Si' : 'No'}`);
    }
    
    console.log("\nGENERANDO ARCHIVO JSON");
    PromotionalBundle.exportToJSON(bundles, path.join(DATA_DIR, 'paquetes.json'));
    console.log("\nGRACIAS");
}

async function systemCashRegister() {
    console.log("\n    SISTEMA DE CAJA REGISTRADORA\n");
    ensureDataDir();
    
    const startingBalance = parseFloat(await question("Ingrese el balance inicial de la caja: $"));
    const totalSales = parseFloat(await question("Ingrese el total de ventas del dia: $"));
    const securityWithdrawals = parseFloat(await question("Ingrese los retiros de seguridad (si no hay, ingrese 0): $"));
    
    const cashRegister = new CashRegister(startingBalance, totalSales, securityWithdrawals);
    
    const physicalCount = parseFloat(await question("\nIngrese el conteo fisico del dinero en caja: $"));
    cashRegister.setPhysicalCount(physicalCount);
    cashRegister.showReport();
    
    console.log("\nGENERANDO ARCHIVO JSON");
    cashRegister.exportToJSON(path.join(DATA_DIR, 'caja.json'));
    console.log("\nGRACIAS");
}

async function main() {
    while (true) {
        console.log("\n      MINIMARKET APPLICATION\n");
        console.log("1. Sistema de Alertas de Caducidad");
        console.log("2. Sistema de Paquetes Promocionales");
        console.log("3. Sistema de Caja Registradora");
        console.log("4. Salir\n");
        
        const option = await question("Seleccione una opcion: ");
        const numOption = parseInt(option);
        
        if (numOption === 1) {
            await systemExpirationAlerts();
        } else if (numOption === 2) {
            await systemPromotionalBundles();
        } else if (numOption === 3) {
            await systemCashRegister();
        } else if (numOption === 4) {
            console.log("\nGRACIAS POR USAR EL SISTEMA");
            break;
        } else {
            console.log("\nOpcion no valida. Intente de nuevo.");
        }
    }
    rl.close();
}

main();
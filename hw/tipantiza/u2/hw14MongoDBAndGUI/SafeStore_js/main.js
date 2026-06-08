const { app, BrowserWindow, ipcMain } = require('electron');
const { MongoDBConnection } = require('./model/mongodbConnection');
const path = require('path');

let mainWindow;

function createWindow() {
    console.log("Creating main window...");
    
    mainWindow = new BrowserWindow({
        width: 1300,
        height: 800,
        webPreferences: {
            nodeIntegration: true,
            contextIsolation: false
        },
        title: "SafeStore - Sales System"
    });
    
    mainWindow.loadFile(path.join(__dirname, 'view', 'index.html'));
    
    // Abrir herramientas de desarrollo
    mainWindow.webContents.openDevTools();
    
    mainWindow.on('closed', () => {
        mainWindow = null;
    });
    
    console.log("Window created successfully");
}

// ==================== IPC HANDLERS ====================

// Products
ipcMain.handle('get-products', async () => {
    console.log('IPC: get-products called');
    return MongoDBConnection.getAllProducts();
});

ipcMain.handle('save-product', async (event, product) => {
    console.log('IPC: save-product called');
    return await MongoDBConnection.saveProduct(product);
});

ipcMain.handle('update-product', async (event, productId, product) => {
    console.log('IPC: update-product called');
    return await MongoDBConnection.updateProduct(productId, product);
});

ipcMain.handle('delete-product', async (event, productId) => {
    console.log('IPC: delete-product called');
    return await MongoDBConnection.deleteProduct(productId);
});

// Suppliers
ipcMain.handle('get-suppliers', async () => {
    console.log('IPC: get-suppliers called');
    return MongoDBConnection.getAllSuppliers();
});

ipcMain.handle('save-supplier', async (event, supplier) => {
    console.log('IPC: save-supplier called');
    return await MongoDBConnection.saveSupplier(supplier);
});

ipcMain.handle('update-supplier', async (event, supplierId, supplier) => {
    console.log('IPC: update-supplier called');
    return await MongoDBConnection.updateSupplier(supplierId, supplier);
});

ipcMain.handle('delete-supplier', async (event, supplierId) => {
    console.log('IPC: delete-supplier called');
    return await MongoDBConnection.deleteSupplier(supplierId);
});

// Sales
ipcMain.handle('get-sales', async () => {
    console.log('IPC: get-sales called');
    return MongoDBConnection.getAllSales();
});

ipcMain.handle('save-sale', async (event, sale) => {
    console.log('IPC: save-sale called');
    return await MongoDBConnection.saveSale(sale);
});

ipcMain.handle('delete-sale', async (event, saleId) => {
    console.log('IPC: delete-sale called');
    return await MongoDBConnection.deleteSale(saleId);
});

// ==================== APP READY ====================

// Esperar a que Electron esté listo
app.whenReady().then(async () => {
    console.log("Electron is ready, connecting to MongoDB...");
    await MongoDBConnection.connect();
    createWindow();
});

app.on('window-all-closed', () => {
    if (process.platform !== 'darwin') {
        app.quit();
    }
});

app.on('activate', () => {
    if (mainWindow === null) {
        createWindow();
    }
});
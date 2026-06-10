/**
 * MongoDB Connection Handler with JSON backup
 * @author Alexander Tipantiza, The Softwarriors, @ESPE
 */

const { MongoClient } = require('mongodb');
const fs = require('fs');
const path = require('path');

class MongoDBConnection {
    // URL CORRECTA PARA NODE.JS
    static CONNECTION_STRING = "mongodb+srv://tipantizaalexander:Alexander20@cluster0.z86uqo3.mongodb.net/?appName=Cluster0";
    static DATABASE_NAME = "SafeStoreApp2DB";
    
    static client = null;
    static database = null;
    static isConnected = false;
    
    static JSON_PRODUCTS_FILE = path.join(__dirname, '..', 'data', 'products.json');
    static JSON_SUPPLIERS_FILE = path.join(__dirname, '..', 'data', 'suppliers.json');
    static JSON_SALES_FILE = path.join(__dirname, '..', 'data', 'sales.json');
    
    static ensureDataDir() {
        const dataDir = path.join(__dirname, '..', 'data');
        if (!fs.existsSync(dataDir)) {
            fs.mkdirSync(dataDir, { recursive: true });
            console.log("📁 Created data directory");
        }
    }
    
    static async connect() {
        this.ensureDataDir();
        console.log("🔌 Connecting to MongoDB Atlas...");
        
        try {
            this.client = new MongoClient(this.CONNECTION_STRING, {
                serverSelectionTimeoutMS: 5000,
                connectTimeoutMS: 10000
            });
            
            await this.client.connect();
            await this.client.db("admin").command({ ping: 1 });
            this.database = this.client.db(this.DATABASE_NAME);
            this.isConnected = true;
            
            console.log("✅ Connected to MongoDB Atlas!");
            await this.syncFromMongoDB();
        } catch (error) {
            console.log(`⚠️ Connection failed: ${error.message}`);
            console.log("📁 Working offline (using JSON files only)");
            this.isConnected = false;
        }
        
        return this.isConnected;
    }
    
    static saveToJSON(filepath, data) {
        try {
            this.ensureDataDir();
            fs.writeFileSync(filepath, JSON.stringify(data, null, 2), 'utf-8');
            return true;
        } catch (error) {
            console.log(`Error saving JSON: ${error.message}`);
            return false;
        }
    }
    
    static loadFromJSON(filepath) {
        try {
            if (fs.existsSync(filepath)) {
                const data = fs.readFileSync(filepath, 'utf-8');
                return JSON.parse(data);
            }
        } catch (error) {
            console.log(`Error loading JSON: ${error.message}`);
        }
        return [];
    }
    
    static async syncFromMongoDB() {
        if (!this.isConnected) return;
        
        try {
            const products = await this.getProductsCollection().find({}).toArray();
            products.forEach(p => { p._id = p._id.toString(); });
            this.saveToJSON(this.JSON_PRODUCTS_FILE, products);
            console.log(`📁 Synced ${products.length} products`);
            
            const suppliers = await this.getSuppliersCollection().find({}).toArray();
            suppliers.forEach(s => { s._id = s._id.toString(); });
            this.saveToJSON(this.JSON_SUPPLIERS_FILE, suppliers);
            console.log(`📁 Synced ${suppliers.length} suppliers`);
            
            const sales = await this.getSalesCollection().find({}).toArray();
            sales.forEach(sale => { sale._id = sale._id.toString(); });
            this.saveToJSON(this.JSON_SALES_FILE, sales);
            console.log(`📁 Synced ${sales.length} sales`);
        } catch (error) {
            console.log(`Sync error: ${error.message}`);
        }
    }
    
    static getProductsCollection() {
        return this.database.collection("products");
    }
    
    static async saveProduct(product) {
        try {
            console.log("saveProduct called with:", product);
            delete product._id;
            
            if (this.isConnected) {
                try {
                    const result = await this.getProductsCollection().insertOne(product);
                    product._id = result.insertedId.toString();
                    console.log(`✅ Product saved to MongoDB: ${product.name}`);
                } catch (error) {
                    console.log(`MongoDB save error: ${error.message}`);
                }
            }
            
            let products = this.loadFromJSON(this.JSON_PRODUCTS_FILE);
            if (!product.productId) {
                const nextId = products.length + 1;
                product.productId = String(nextId);
            }
            products.push(product);
            this.saveToJSON(this.JSON_PRODUCTS_FILE, products);
            console.log(`📁 Product saved to JSON: ${product.name}`);
            return true;
        } catch (error) {
            console.log(`Error saving product: ${error.message}`);
            return false;
        }
    }
    
    static getAllProducts() {
        let products = this.loadFromJSON(this.JSON_PRODUCTS_FILE);
        console.log(`getAllProducts returning ${products.length} products`);
        return products;
    }
    
    static async updateProduct(productId, product) {
        try {
            console.log("updateProduct called for:", productId);
            let products = this.loadFromJSON(this.JSON_PRODUCTS_FILE);
            let jsonSuccess = false;
            
            for (let i = 0; i < products.length; i++) {
                if (products[i].productId === productId || products[i]._id === productId) {
                    if (products[i]._id) product._id = products[i]._id;
                    products[i] = product;
                    this.saveToJSON(this.JSON_PRODUCTS_FILE, products);
                    jsonSuccess = true;
                    console.log(`📁 Product updated in JSON: ${product.name}`);
                    break;
                }
            }
            
            let mongodbSuccess = false;
            if (this.isConnected) {
                try {
                    const { ObjectId } = require('mongodb');
                    let query;
                    try {
                        query = { _id: new ObjectId(productId) };
                    } catch {
                        query = { productId: productId };
                    }
                    const result = await this.getProductsCollection().updateOne(query, { $set: product });
                    mongodbSuccess = result.modifiedCount > 0;
                    if (mongodbSuccess) {
                        console.log(`✅ Product updated in MongoDB: ${product.name}`);
                    }
                } catch (error) {
                    console.log(`MongoDB update error: ${error.message}`);
                }
            }
            
            return jsonSuccess || mongodbSuccess;
        } catch (error) {
            console.log(`Error updating product: ${error.message}`);
            return false;
        }
    }
    
    static async deleteProduct(productId) {
        try {
            console.log("deleteProduct called for:", productId);
            let products = this.loadFromJSON(this.JSON_PRODUCTS_FILE);
            const originalLen = products.length;
            products = products.filter(p => p.productId !== productId && p._id !== productId);
            const jsonSuccess = products.length < originalLen;
            if (jsonSuccess) {
                this.saveToJSON(this.JSON_PRODUCTS_FILE, products);
                console.log(`📁 Product deleted from JSON`);
            }
            
            let mongodbSuccess = false;
            if (this.isConnected) {
                try {
                    const { ObjectId } = require('mongodb');
                    let query;
                    try {
                        query = { _id: new ObjectId(productId) };
                    } catch {
                        query = { productId: productId };
                    }
                    const result = await this.getProductsCollection().deleteOne(query);
                    mongodbSuccess = result.deletedCount > 0;
                    if (mongodbSuccess) {
                        console.log(`✅ Product deleted from MongoDB`);
                    }
                } catch (error) {
                    console.log(`MongoDB delete error: ${error.message}`);
                }
            }
            
            return jsonSuccess || mongodbSuccess;
        } catch (error) {
            console.log(`Error deleting product: ${error.message}`);
            return false;
        }
    }
    
    static getSuppliersCollection() {
        return this.database.collection("suppliers");
    }
    
    static async saveSupplier(supplier) {
        try {
            console.log("saveSupplier called with:", supplier);
            delete supplier._id;
            
            if (this.isConnected) {
                try {
                    const result = await this.getSuppliersCollection().insertOne(supplier);
                    supplier._id = result.insertedId.toString();
                    console.log(`✅ Supplier saved to MongoDB: ${supplier.name}`);
                } catch (error) {
                    console.log(`MongoDB save error: ${error.message}`);
                }
            }
            
            let suppliers = this.loadFromJSON(this.JSON_SUPPLIERS_FILE);
            if (!supplier.supplierId) {
                const nextId = suppliers.length + 1;
                supplier.supplierId = String(nextId);
            }
            suppliers.push(supplier);
            this.saveToJSON(this.JSON_SUPPLIERS_FILE, suppliers);
            console.log(`📁 Supplier saved to JSON: ${supplier.name}`);
            return true;
        } catch (error) {
            console.log(`Error saving supplier: ${error.message}`);
            return false;
        }
    }
    
    static getAllSuppliers() {
        let suppliers = this.loadFromJSON(this.JSON_SUPPLIERS_FILE);
        console.log(`getAllSuppliers returning ${suppliers.length} suppliers`);
        return suppliers;
    }
    
    static async updateSupplier(supplierId, supplier) {
        try {
            console.log("updateSupplier called for:", supplierId);
            let suppliers = this.loadFromJSON(this.JSON_SUPPLIERS_FILE);
            let jsonSuccess = false;
            
            for (let i = 0; i < suppliers.length; i++) {
                if (suppliers[i].supplierId === supplierId || suppliers[i]._id === supplierId) {
                    if (suppliers[i]._id) supplier._id = suppliers[i]._id;
                    suppliers[i] = supplier;
                    this.saveToJSON(this.JSON_SUPPLIERS_FILE, suppliers);
                    jsonSuccess = true;
                    console.log(`📁 Supplier updated in JSON: ${supplier.name}`);
                    break;
                }
            }
            
            let mongodbSuccess = false;
            if (this.isConnected) {
                try {
                    const { ObjectId } = require('mongodb');
                    let query;
                    try {
                        query = { _id: new ObjectId(supplierId) };
                    } catch {
                        query = { supplierId: supplierId };
                    }
                    const result = await this.getSuppliersCollection().updateOne(query, { $set: supplier });
                    mongodbSuccess = result.modifiedCount > 0;
                    if (mongodbSuccess) {
                        console.log(`✅ Supplier updated in MongoDB: ${supplier.name}`);
                    }
                } catch (error) {
                    console.log(`MongoDB update error: ${error.message}`);
                }
            }
            
            return jsonSuccess || mongodbSuccess;
        } catch (error) {
            console.log(`Error updating supplier: ${error.message}`);
            return false;
        }
    }
    
    static async deleteSupplier(supplierId) {
        try {
            console.log("deleteSupplier called for:", supplierId);
            let suppliers = this.loadFromJSON(this.JSON_SUPPLIERS_FILE);
            const originalLen = suppliers.length;
            suppliers = suppliers.filter(s => s.supplierId !== supplierId && s._id !== supplierId);
            const jsonSuccess = suppliers.length < originalLen;
            if (jsonSuccess) {
                this.saveToJSON(this.JSON_SUPPLIERS_FILE, suppliers);
                console.log(`📁 Supplier deleted from JSON`);
            }
            
            let mongodbSuccess = false;
            if (this.isConnected) {
                try {
                    const { ObjectId } = require('mongodb');
                    let query;
                    try {
                        query = { _id: new ObjectId(supplierId) };
                    } catch {
                        query = { supplierId: supplierId };
                    }
                    const result = await this.getSuppliersCollection().deleteOne(query);
                    mongodbSuccess = result.deletedCount > 0;
                    if (mongodbSuccess) {
                        console.log(`✅ Supplier deleted from MongoDB`);
                    }
                } catch (error) {
                    console.log(`MongoDB delete error: ${error.message}`);
                }
            }
            
            return jsonSuccess || mongodbSuccess;
        } catch (error) {
            console.log(`Error deleting supplier: ${error.message}`);
            return false;
        }
    }
    
    static getSalesCollection() {
        return this.database.collection("sales");
    }
    
    static async saveSale(sale) {
        try {
            console.log("saveSale called with:", sale);
            delete sale._id;
            sale.saved_at = new Date().toISOString();
            
            if (this.isConnected) {
                try {
                    const result = await this.getSalesCollection().insertOne(sale);
                    sale._id = result.insertedId.toString();
                    console.log(`✅ Sale saved to MongoDB: #${sale.saleId}`);
                } catch (error) {
                    console.log(`MongoDB save error: ${error.message}`);
                }
            }
            
            let sales = this.loadFromJSON(this.JSON_SALES_FILE);
            sales.push(sale);
            this.saveToJSON(this.JSON_SALES_FILE, sales);
            console.log(`📁 Sale saved to JSON: #${sale.saleId}`);
            return true;
        } catch (error) {
            console.log(`Error saving sale: ${error.message}`);
            return false;
        }
    }
    
    static getAllSales() {
        let sales = this.loadFromJSON(this.JSON_SALES_FILE);
        console.log(`getAllSales returning ${sales.length} sales`);
        return sales;
    }
    
    static async deleteSale(saleId) {
        try {
            console.log("deleteSale called for:", saleId);
            let sales = this.loadFromJSON(this.JSON_SALES_FILE);
            const originalLen = sales.length;
            sales = sales.filter(s => String(s.saleId) !== saleId && s._id !== saleId);
            const jsonSuccess = sales.length < originalLen;
            if (jsonSuccess) {
                this.saveToJSON(this.JSON_SALES_FILE, sales);
                console.log(`📁 Sale deleted from JSON`);
            }
            
            let mongodbSuccess = false;
            if (this.isConnected) {
                try {
                    const { ObjectId } = require('mongodb');
                    let query;
                    try {
                        query = { _id: new ObjectId(saleId) };
                    } catch {
                        query = { saleId: parseInt(saleId) };
                    }
                    const result = await this.getSalesCollection().deleteOne(query);
                    mongodbSuccess = result.deletedCount > 0;
                    if (mongodbSuccess) {
                        console.log(`✅ Sale deleted from MongoDB`);
                    }
                } catch (error) {
                    console.log(`MongoDB delete error: ${error.message}`);
                }
            }
            
            return jsonSuccess || mongodbSuccess;
        } catch (error) {
            console.log(`Error deleting sale: ${error.message}`);
            return false;
        }
    }
}

module.exports = { MongoDBConnection };
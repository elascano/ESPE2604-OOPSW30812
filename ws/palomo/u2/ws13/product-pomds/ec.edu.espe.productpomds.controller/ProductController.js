// ============================================================
// Package:     ec.edu.espe.productpomds.controller
// Class:       ProductController
// Description: Business logic and JSON file persistence
// ============================================================

const fs      = require("fs");
const path    = require("path");
const Product = require("../ec.edu.espe.productpomds.model/Product");

const DB_PATH = path.join(__dirname, "../data/products.json");

class ProductController {

  // ── Persistence ───────────────────────────────────────────

  _loadData() {
    if (!fs.existsSync(DB_PATH)) {
      fs.writeFileSync(DB_PATH, JSON.stringify([], null, 2), "utf8");
    }
    const raw = fs.readFileSync(DB_PATH, "utf8");
    return JSON.parse(raw);
  }

  _saveData(products) {
    fs.writeFileSync(DB_PATH, JSON.stringify(products, null, 2), "utf8");
  }

  _generateId(products) {
    if (products.length === 0) return 1;
    return Math.max(...products.map(p => p.id)) + 1;
  }

  // ── CRUD ──────────────────────────────────────────────────

  createProduct(name, description, price, stock, category) {
    const products = this._loadData();

    if (!name || !price || !stock) {
      return { ok: false, message: "Name, price and stock are required." };
    }
    if (isNaN(price) || price <= 0) {
      return { ok: false, message: "Price must be a positive number." };
    }
    if (isNaN(stock) || stock < 0) {
      return { ok: false, message: "Stock must be a non-negative number." };
    }

    const id      = this._generateId(products);
    const product = new Product(id, name, description, price, stock, category);
    products.push(product);
    this._saveData(products);
    return { ok: true, message: "Product created successfully.", product };
  }

  listProducts() {
    return this._loadData();
  }

  findById(id) {
    const products = this._loadData();
    const product  = products.find(p => p.id === parseInt(id));
    if (!product) return { ok: false, message: `No product found with ID ${id}.` };
    return { ok: true, product };
  }

  updateProduct(id, data) {
    const products = this._loadData();
    const index    = products.findIndex(p => p.id === parseInt(id));

    if (index === -1) return { ok: false, message: `Product with ID ${id} not found.` };

    const fields = ["name", "description", "price", "stock", "category"];
    fields.forEach(field => {
      if (data[field] !== undefined && data[field] !== "") {
        products[index][field] =
          field === "price" ? parseFloat(data[field]) :
          field === "stock" ? parseInt(data[field])   :
          data[field];
      }
    });

    this._saveData(products);
    return { ok: true, message: "Product updated successfully.", product: products[index] };
  }

  deleteProduct(id) {
    const products = this._loadData();
    const index    = products.findIndex(p => p.id === parseInt(id));
    if (index === -1) return { ok: false, message: `Product with ID ${id} not found.` };

    const deleted = products.splice(index, 1)[0];
    this._saveData(products);
    return { ok: true, message: `Product "${deleted.name}" deleted successfully.` };
  }

  findByCategory(category) {
    const products = this._loadData();
    return products.filter(p =>
      p.category.toLowerCase().includes(category.toLowerCase())
    );
  }
}

module.exports = ProductController;

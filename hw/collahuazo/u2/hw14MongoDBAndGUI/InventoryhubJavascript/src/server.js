import express from "express";
import path from "path";
import { fileURLToPath } from "url";
import cors from "cors";
import {
  getAllCustomers,
  getAllProducts,
  getAllSuppliers,
  insertCustomer,
  insertProduct,
  insertSupplier,
} from "./controllers/inventoryController.js";
import { Customer } from "./models/customer.js";
import { Product } from "./models/product.js";
import { Supplier } from "./models/supplier.js";

const __filename = fileURLToPath(import.meta.url);
const __dirname = path.dirname(__filename);

const app = express();
const PORT = process.env.PORT || 3000;

app.use(cors());
app.use(express.json());
app.use(express.static(path.join(__dirname, "../public")));

// GET endpoints
app.get("/api/customers", async (req, res) => {
  try {
    console.log("GET /api/customers");
    const customers = await getAllCustomers();
    return res.json(customers);
  } catch (error) {
    console.error("Error fetching customers:", error);
    return res.status(500).json({ error: error.message });
  }
});

app.get("/api/products", async (req, res) => {
  try {
    console.log("GET /api/products");
    const products = await getAllProducts();
    return res.json(products);
  } catch (error) {
    console.error("Error fetching products:", error);
    return res.status(500).json({ error: error.message });
  }
});

app.get("/api/suppliers", async (req, res) => {
  try {
    console.log("GET /api/suppliers");
    const suppliers = await getAllSuppliers();
    return res.json(suppliers);
  } catch (error) {
    console.error("Error fetching suppliers:", error);
    return res.status(500).json({ error: error.message });
  }
});

// POST endpoints
app.post("/api/customers", async (req, res) => {
  try {
    console.log("POST /api/customers - Body:", req.body);
    const { ruc, name, address, gmailCustomer } = req.body;
    
    if (!ruc || !name || !address || !gmailCustomer) {
      return res.status(400).json({ error: "Missing fields" });
    }
    
    const customer = new Customer(ruc, name, address, gmailCustomer);
    await insertCustomer(customer);
    return res.status(201).json({ message: "Customer created" });
  } catch (error) {
    console.error("Error inserting customer:", error);
    return res.status(500).json({ error: error.message });
  }
});

app.post("/api/products", async (req, res) => {
  try {
    console.log("POST /api/products - Body:", req.body);
    const { id, name, unitPrice, stock } = req.body;
    
    if (!id || !name || unitPrice === undefined || stock === undefined) {
      return res.status(400).json({ error: "Missing fields" });
    }
    
    const product = new Product(id, name, unitPrice, stock);
    await insertProduct(product);
    return res.status(201).json({ message: "Product created" });
  } catch (error) {
    console.error("Error inserting product:", error);
    return res.status(500).json({ error: error.message });
  }
});

app.post("/api/suppliers", async (req, res) => {
  try {
    console.log("POST /api/suppliers - Body:", req.body);
    const { ruc, companyName, address, phone, email } = req.body;
    
    if (!ruc || !companyName || !address || !phone || !email) {
      return res.status(400).json({ error: "Missing fields" });
    }
    
    const supplier = new Supplier(ruc, companyName, address, phone, email);
    await insertSupplier(supplier);
    return res.status(201).json({ message: "Supplier created" });
  } catch (error) {
    console.error("Error inserting supplier:", error);
    return res.status(500).json({ error: error.message });
  }
});

// Serve HTML
app.get("/", (req, res) => {
  res.sendFile(path.join(__dirname, "../public/index.html"));
});

// 404 handler
app.use((req, res) => {
  res.status(404).json({ error: "Not found" });
});

// Error handler
app.use((err, req, res, next) => {
  console.error("ERROR:", err);
  res.status(500).json({ error: err.message });
});

app.listen(PORT, () => {
  console.log(`Server running on http://localhost:${PORT}`);
});

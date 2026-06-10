import { getDatabase } from "../utils/db.js";

export async function insertCustomer(customer) {
  const db = await getDatabase();
  await db.collection("customers").insertOne(customer.toDocument());
}

export async function insertProduct(product) {
  const db = await getDatabase();
  await db.collection("products").insertOne(product.toDocument());
}

export async function insertSupplier(supplier) {
  const db = await getDatabase();
  await db.collection("suppliers").insertOne(supplier.toDocument());
}

export async function getAllCustomers() {
  const db = await getDatabase();
  return db.collection("customers").find().toArray();
}

export async function getAllProducts() {
  const db = await getDatabase();
  return db.collection("products").find().toArray();
}

export async function getAllSuppliers() {
  const db = await getDatabase();
  return db.collection("suppliers").find().toArray();
}

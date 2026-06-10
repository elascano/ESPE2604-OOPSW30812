import { MongoClient } from "mongodb";

const URI = "mongodb+srv://brandon:1752221067@cluster0.evr08tq.mongodb.net/?appName=Cluster0";
const DATABASE_NAME = "inventoryHub";
const client = new MongoClient(URI);

let db;

export async function getDatabase() {
  if (!db) {
    try {
      console.log("Connecting to MongoDB...");
      await client.connect();
      db = client.db(DATABASE_NAME);
      console.log("Connected to MongoDB successfully");
    } catch (error) {
      console.error("Failed to connect to MongoDB:", error.message);
      throw new Error("Database connection failed: " + error.message);
    }
  }
  return db;
}

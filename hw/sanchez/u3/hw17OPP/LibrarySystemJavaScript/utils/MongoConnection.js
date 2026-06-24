const { MongoClient } = require("mongodb");

const url = "mongodb+srv://Joel:Joel@cluster0.aex8od4.mongodb.net/?appName=Cluster0";

const client = new MongoClient(url);

async function connectToDatabase() {
    try {
        await client.connect();
        console.log("✅ Conectado exitosamente a MongoDB Atlas");
        return client;
    } catch (error) {
        console.error("❌ Error al conectar a MongoDB:", error.message);
        throw error;
    }
}

module.exports = { client, connectToDatabase };
const connectDB = require("../config/mongo");

async function saveSupplier(supplier) {
    const db = await connectDB();
    const collection = db.collection("suppliers");

    await collection.insertOne(supplier);
}

module.exports = { saveSupplier };
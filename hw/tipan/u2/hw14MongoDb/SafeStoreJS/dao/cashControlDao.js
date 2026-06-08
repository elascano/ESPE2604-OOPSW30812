const connectDB = require("../config/mongo");

async function saveCashControl(cash) {
    const db = await connectDB();
    const collection = db.collection("cashControl");

    await collection.insertOne(cash);
}

module.exports = { saveCashControl };
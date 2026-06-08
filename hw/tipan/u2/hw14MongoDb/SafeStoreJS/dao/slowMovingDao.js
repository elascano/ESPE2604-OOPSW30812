const connectDB = require("../config/mongo");

async function saveSlowMoving(item) {
    const db = await connectDB();
    const collection = db.collection("slowMoving");

    await collection.insertOne(item);
}

module.exports = { saveSlowMoving };
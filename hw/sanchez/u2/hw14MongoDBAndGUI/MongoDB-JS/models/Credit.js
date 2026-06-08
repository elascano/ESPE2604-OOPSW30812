const { getDatabase } = require('../config/database');

const COLLECTION = 'credits';

async function getAll() {
    const db = getDatabase();
    return await db.collection(COLLECTION).find({}, { projection: { _id: 0 } }).toArray();
}

async function getById(customerId) {
    const db = getDatabase();
    return await db.collection(COLLECTION).findOne({ customerId: customerId }, { projection: { _id: 0 } });
}

async function create(credit) {
    const db = getDatabase();
    const existing = await getById(credit.customerId);
    if (existing) {
        throw new Error('Credit account already exists');
    }
    const newCredit = {
        ...credit,
        currentDebt: 0,
        transactions: [],
        isBlocked: false
    };
    await db.collection(COLLECTION).insertOne(newCredit);
    return newCredit;
}

async function update(customerId, creditData) {
    const db = getDatabase();
    const result = await db.collection(COLLECTION).updateOne(
        { customerId: customerId },
        { $set: creditData }
    );
    return result.modifiedCount > 0;
}

async function remove(customerId) {
    const db = getDatabase();
    const result = await db.collection(COLLECTION).deleteOne({ customerId: customerId });
    return result.deletedCount > 0;
}

async function getCount() {
    const db = getDatabase();
    return await db.collection(COLLECTION).countDocuments();
}

module.exports = { getAll, getById, create, update, remove, getCount };
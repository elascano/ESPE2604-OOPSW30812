const { getDatabase } = require('../config/database');

const COLLECTION = 'products';

async function getAll() {
    const db = getDatabase();
    return await db.collection(COLLECTION).find({}, { projection: { _id: 0 } }).toArray();
}

async function getById(id) {
    const db = getDatabase();
    return await db.collection(COLLECTION).findOne({ id: id }, { projection: { _id: 0 } });
}

async function create(product) {
    const db = getDatabase();
    const existing = await getById(product.id);
    if (existing) {
        throw new Error('Product with this ID already exists');
    }
    await db.collection(COLLECTION).insertOne(product);
    return product;
}

async function update(id, productData) {
    const db = getDatabase();
    const result = await db.collection(COLLECTION).updateOne(
        { id: id },
        { $set: productData }
    );
    return result.modifiedCount > 0;
}

async function remove(id) {
    const db = getDatabase();
    const result = await db.collection(COLLECTION).deleteOne({ id: id });
    return result.deletedCount > 0;
}

async function getCount() {
    const db = getDatabase();
    return await db.collection(COLLECTION).countDocuments();
}

module.exports = { getAll, getById, create, update, remove, getCount };
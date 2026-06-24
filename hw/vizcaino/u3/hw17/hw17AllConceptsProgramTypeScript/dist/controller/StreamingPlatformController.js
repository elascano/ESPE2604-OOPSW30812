"use strict";
Object.defineProperty(exports, "__esModule", { value: true });
exports.StreamingPlatformController = void 0;
const database_1 = require("../utils/database");
class StreamingPlatformController {
    constructor() {
        this.db = new database_1.Database();
    }
    async init() {
        await this.db.connect();
        this.collection = this.db.getCollection();
    }
    async create(user) {
        await this.collection.insertOne(user);
    }
    async read() {
        return await this.collection.find({}).toArray();
    }
    async update(name, plan) {
        await this.collection.updateOne({ name }, { $set: { plan } });
    }
    async delete(name) {
        await this.collection.deleteOne({ name });
    }
}
exports.StreamingPlatformController = StreamingPlatformController;

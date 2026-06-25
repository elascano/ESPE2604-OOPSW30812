import { Database } from "../utils/database";

export class StreamingPlatformController {

    private db = new Database();
    private collection: any;

    async init() {
        await this.db.connect();
        this.collection = this.db.getCollection();
    }

    async create(user: any) {
        await this.collection.insertOne(user);
    }

    async read() {
        return await this.collection.find({}).toArray();
    }

    async update(name: string, plan: string) {
        await this.collection.updateOne(
            { name },
            { $set: { plan } }
        );
    }

    async delete(name: string) {
        await this.collection.deleteOne({ name });
    }
}
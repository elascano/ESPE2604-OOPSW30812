import { MongoClient, Db } from 'mongodb';

export class MongoDBConnection {
    private static client: MongoClient | null = null;
    private static db: Db | null = null;
    private static readonly CONNECTION_STRING = 'mongodb://mongodb:mongodb@157.137.223.54:27017/mongodb?authSource=mongodb';
    private static readonly DATABASE_NAME = 'mongodb';

    private constructor() {}

    public static async getDatabase(): Promise<Db> {
        if (!this.db) {
            this.client = new MongoClient(this.CONNECTION_STRING, {
                serverSelectionTimeoutMS: 3000
            });
            await this.client.connect();
            this.db = this.client.db(this.DATABASE_NAME);
        }
        return this.db;
    }

    public static async close(): Promise<void> {
        if (this.client) {
            await this.client.close();
            this.client = null;
            this.db = null;
        }
    }
}

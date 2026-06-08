import { Collection, Db } from 'mongodb';
import { IDatabaseController } from './databaseController.js';
import { Product } from '../model/product.js';

export class ProductController implements IDatabaseController<Product> {
    private collection: Collection;

    constructor(db: Db) {
        this.collection = db.collection('products');
    }

    public async create(entity: Product): Promise<void> {
        if (entity) {
            await this.collection.insertOne(entity);
        }
    }

    public async readAll(): Promise<Product[]> {
        const docs = await this.collection.find().toArray();
        return docs.map(doc => Product.fromDocument(doc) as Product);
    }

    public async readById(idField: string, idValue: string): Promise<Product | null> {
        const doc = await this.collection.findOne({ [idField]: idValue });
        return Product.fromDocument(doc);
    }

    public async update(idField: string, idValue: string, fieldName: string, newValue: any): Promise<void> {
        await this.collection.updateOne(
            { [idField]: idValue },
            { $set: { [fieldName]: newValue } }
        );
    }

    public async delete(idField: string, idValue: string): Promise<void> {
        await this.collection.deleteOne({ [idField]: idValue });
    }

    public async cleanCollection(): Promise<void> {
        await this.collection.drop().catch(() => {});
    }
}

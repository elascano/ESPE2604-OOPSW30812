import { Collection, Db } from 'mongodb';
import { IDatabaseController } from './databaseController.js';
import { Ingredient } from '../model/ingredient.js';

export class IngredientController implements IDatabaseController<Ingredient> {
    private collection: Collection;

    constructor(db: Db) {
        this.collection = db.collection('ingredients');
    }

    public async create(entity: Ingredient): Promise<void> {
        if (entity) {
            await this.collection.insertOne(entity);
        }
    }

    public async readAll(): Promise<Ingredient[]> {
        const docs = await this.collection.find().toArray();
        return docs.map(doc => Ingredient.fromDocument(doc) as Ingredient);
    }

    public async readById(idField: string, idValue: string): Promise<Ingredient | null> {
        const doc = await this.collection.findOne({ [idField]: idValue });
        return Ingredient.fromDocument(doc);
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

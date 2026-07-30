import { MongoClient } from "mongodb";

class MongoConnection {
  static client = null;
  static database = null;
  static connectionString = process.env.MONGODB_URI || "";
  static databaseName = "FarmZooDB";

  static async getDatabase() {
    if (!this.database) {
      try {
        this.client = new MongoClient(this.connectionString);
        await this.client.connect();
        this.database = this.client.db(this.databaseName);
      } catch (e) {
        console.error(`Error connecting to MongoDB Atlas: ${e.message}`);
      }
    }
    return this.database;
  }

  static async saveDocument(collectionName, document) {
    try {
      const db = await this.getDatabase();
      if (db) {
        await db.collection(collectionName).insertOne(document);
      }
    } catch (e) {
      console.error(`Error saving document to ${collectionName}: ${e.message}`);
    }
  }
}

class FarmBusinessLogic {
  static calculateExpectedMeatYield(animal) {
    return animal.cut().reduce((total, cut) => total + cut.getWeight(), 0);
  }

  static isEligibleForEggProduction(chicken) {
    return !chicken.isMolting() && chicken.getNumberOfEggsPerWeek() > 2;
  }

  static calculateMilkEfficiency(cow) {
    if (cow.getWeight() <= 0) return 0;
    return (cow.milk() / cow.getWeight()) * 100;
  }
}

export { MongoConnection, FarmBusinessLogic };

const MongoConnection = require('./mongoConnection');

class MotherModel {
    constructor() {
        this.db = MongoConnection.getDatabase();
        this.collection = this.db.collection("Mother");
    }

    async saveMother(motherData, babyData) {
        const motherId = motherData.id;
        const document = {
            firstName: motherData.firstName,
            lastName: motherData.lastName,
            id: motherId,
            birthDate: motherData.birthDate,
            weight: parseFloat(motherData.weight),
            height: parseFloat(motherData.height),
            babies: [babyData] 
        };
        return await this.collection.replaceOne({ id: motherId }, document, { upsert: true });
    }

    async getMother(motherId) {
        return await this.collection.findOne({ id: motherId });
    }
}

module.exports = MotherModel;
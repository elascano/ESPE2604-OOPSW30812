const MongoConnection = require('./mongoConnection');

class BabyModel {
    constructor() {
        this.db = MongoConnection.getDatabase();
        this.collection = this.db.collection("babies");
    }

    async saveBaby(babyData) {
        const babyId = `${babyData.firstName}_${babyData.lastName}`;
        const document = {
            _id: babyId,
            firstName: babyData.firstName,
            lastName: babyData.lastName,
            weight: parseInt(babyData.weight),
            height: parseInt(babyData.height),
            birthDate: babyData.birthDate,
            motherId: babyData.motherId
        };
        return await this.collection.replaceOne({ _id: babyId }, document, { upsert: true });
    }

    async getBabyByMother(motherId) {
        return await this.collection.findOne({ motherId: motherId });
    }
}

module.exports = BabyModel;
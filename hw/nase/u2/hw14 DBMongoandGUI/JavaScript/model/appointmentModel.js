const MongoConnection = require('./mongoConnection');

class AppointmentModel {
    constructor() {
        this.db = MongoConnection.getDatabase();
        this.collection = this.db.collection("appointments");
    }

    async saveAppointment(appointmentData) {
        const document = {
            appointmentDate: appointmentData.appointmentDate,
            recommendations: appointmentData.recommendations,
            motherId: appointmentData.motherId
        };
        return await this.collection.insertOne(document);
    }

    async getAppointmentByMother(motherId) {
        return await this.collection.findOne({ motherId: motherId }, { sort: { _id: -1 } });
    }
}

module.exports = AppointmentModel;
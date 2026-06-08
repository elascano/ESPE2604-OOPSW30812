const MotherModel = require('../model/motherModel');
const BabyModel = require('../model/babyModel');
const AppointmentModel = require('../model/appointmentModel');

class MotherController {
    constructor() {
        this.motherModel = new MotherModel();
        this.babyModel = new BabyModel();
        this.appointmentModel = new AppointmentModel();
    }


    async saveMother(motherData, babyData) {
        if (!motherData.id) {
            throw new Error("Please fill in the Mother's ID.");
        }
        return await this.motherModel.saveMother(motherData, babyData);
    }

    async loadMother(motherId) {
        if (!motherId) {
            throw new Error("Please write a Mother ID first to search.");
        }
        const mother = await this.motherModel.getMother(motherId);
        if (!mother) {
            throw new Error(`No mother found with ID: ${motherId}`);
        }
        return mother;
    }

    async saveBaby(babyData) {
        if (!babyData.motherId) {
            throw new Error("Please provide a Mother ID first to link the Baby.");
        }
        return await this.babyModel.saveBaby(babyData);
    }

    async loadBaby(motherId) {
        if (!motherId) {
            throw new Error("Please provide a Mother ID to find the baby.");
        }
        const baby = await this.babyModel.getBabyByMother(motherId);
        if (!baby) {
            throw new Error("No baby found linked to this Mother ID.");
        }
        return baby;
    }

 
    async saveAppointment(appData) {
        if (!appData.motherId) {
            throw new Error("Please provide a Mother ID to link the Appointment.");
        }
        return await this.appointmentModel.saveAppointment(appData);
    }

    async loadAppointment(motherId) {
        if (!motherId) {
            throw new Error("Please provide a Mother ID to find appointments.");
        }
        const app = await this.appointmentModel.getAppointmentByMother(motherId);
        if (!app) {
            throw new Error("No appointments found for this Mother ID.");
        }
        return app;
    }
}

module.exports = MotherController;
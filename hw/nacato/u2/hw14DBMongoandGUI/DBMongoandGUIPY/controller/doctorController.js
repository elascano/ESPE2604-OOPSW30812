const DoctorModel = require('../model/doctorModel');

class DoctorController {
    async saveDoctor(data) {
        try {
            const { id, name, speciality } = data;
            const newDoctor = new DoctorModel({
                doctorData: { id: parseInt(id), name, speciality }
            });
            await newDoctor.save();
            return { status: "success", message: "Doctor saved directly to Cloud!" };
        } catch (error) {
            return { status: "error", message: error.message };
        }
    }
}

module.exports = new DoctorController();
const mongoose = require('mongoose');

const DoctorSchema = new mongoose.Schema({
    module: { type: String, default: "Doctor Registration" },
    syncDate: { type: String, default: () => new Date().toString() },
    doctorData: {
        id: { type: Number, required: true },
        name: { type: String, required: true },
        speciality: { type: String, required: true }
    }
}, { collection: 'allProjectRecords', versionKey: false });

module.exports = mongoose.model('DoctorModel', DoctorSchema);
const mongoose = require("mongoose");

const SortSchema = new mongoose.Schema({
    unsorted: {
        type: [Number],
        required: true
    },
    size: {
        type: Number,
        required: true
    },
    algorithm: {
        type: String,
        required: true
    },
    sorted: {
        type: [Number],
        required: true
    }
}, {
    collection: "arrayRonald"
});

module.exports = mongoose.model("Sort", SortSchema);
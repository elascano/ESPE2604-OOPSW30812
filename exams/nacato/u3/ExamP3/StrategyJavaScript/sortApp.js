const express = require('express');
const mongoose = require('mongoose');
const path = require('path');
const SortingContext = require('./sortingContext');

const app = express();
app.use(express.json());

app.use(express.static(path.join(__dirname, 'public')));

const mongoURI = 'mongodb://Angie:Angie@ac-sl21bq2-shard-00-00.spphrbg.mongodb.net:27017,ac-sl21bq2-shard-00-01.spphrbg.mongodb.net:27017,ac-sl21bq2-shard-00-02.spphrbg.mongodb.net:27017/strategyNacato?ssl=true&replicaSet=atlas-g5mrxh-shard-0&authSource=admin&appName=angienx';

mongoose.connect(mongoURI)
    .then(() => console.log("¡Conectado a MongoDB Atlas exitosamente!"))
    .catch(err => console.error("Error conectando a MongoDB:", err));

const arraySchema = new mongoose.Schema({
    unsorted: String,
    size: Number,
    "sort algorithm": String,
    sorted: String
}, { versionKey: false });

const ArrayModel = mongoose.model('Array', arraySchema, 'arrayAngie');

app.post('/api/sort', async (req, res) => {
    try {
        const { input } = req.body;
        const unsortedArray = input.split(',').map(num => Number(num.trim())).filter(num => !isNaN(num));
        const size = unsortedArray.length;

        if (size <= 1) {
            return res.status(400).json({ error: "The number of elements must be greater than 1." });
        }

        const sc = new SortingContext();
        let algorithmName = "";
        
        if (size >= 2 && size <= 6) algorithmName = "BubbleSort";
        else if (size >= 7 && size <= 10) algorithmName = "InsertionSort";
        else algorithmName = "QuickSort";

        const sortedArray = sc.sort([...unsortedArray]);

        const document = {
            unsorted: unsortedArray.join(", "),
            size: size,
            "sort algorithm": algorithmName,
            sorted: sortedArray.join(", ")
        };

        const savedData = await ArrayModel.create(document);
        res.json(savedData);

    } catch (error) {
        res.status(500).json({ error: error.message });
    }
});

const PORT = 3011;
app.listen(PORT, () => console.log(`Servidor corriendo en http://localhost:${PORT}`));
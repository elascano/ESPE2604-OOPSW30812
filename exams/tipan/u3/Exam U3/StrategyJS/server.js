const express = require("express");
const path = require("path");
const connectDB = require("./config/database");
const { sortArray } = require("./controller/sortController");

require("dotenv").config();

const app = express();


connectDB();


app.use(express.json());


app.use(express.static(path.join(__dirname, "view")));


app.post("/sort", sortArray);


const PORT = process.env.PORT || 3000;


app.listen(PORT, () => {

    console.log(`Servidor ejecutándose en puerto ${PORT}`);

});
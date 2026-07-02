const express = require("express");
const cors = require("cors");
const path = require("path");

const animalRoutes = require("./routes/animalRoutes");
const foodRoutes = require("./routes/foodRoutes");
const cutRoutes = require("./routes/cutRoutes");

const app = express();

const PORT = 3000;

// Middleware

app.use(cors());

app.use(express.json());

app.use(express.urlencoded({ extended: true }));

// Static Files

app.use(express.static(path.join(__dirname, "public")));

// API Routes

app.use("/api/animals", animalRoutes);

app.use("/api/foods", foodRoutes);

app.use("/api/cuts", cutRoutes);

// Home

app.get("/", (req, res) => {
    res.sendFile(path.join(__dirname, "public", "index.html"));
});

// Server

app.listen(PORT, () => {
    console.log("------------------------------------");
    console.log(" Farm System Server Running");
    console.log("------------------------------------");
    console.log(`http://localhost:${PORT}`);
});
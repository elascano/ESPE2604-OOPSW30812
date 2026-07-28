const port = 3006;
const express = require("express");
const mongoose = require("mongoose");

const app = express();

mongoose.connect(
    "mongodb+srv://oop:oop@cluster0.9knxc.mongodb.net/oop?retryWrites=true&w=majority&appName=Cluster0"
);

const db = mongoose.connection;

db.on("error", (error) => console.error(error));

db.once("open", () => {
    console.log("Connected to MongoDB");
});

app.use(express.json());

const customerRoutes = require("./routes/customerRoutes");
app.use("/", customerRoutes);

app.listen(port, () => {
    console.log(`Server running on port ${port}`);
});
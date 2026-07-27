const express = require("express");
const mongoose = require("mongoose");
const app = express();
const port = 3013;

mongoose.connect(`mongodb+srv://oop:oop@cluster0.9knxc.mongodb.net/oop?retryWrites=true&w=majority&appName=Cluster0`);

const db = mongoose.connection;
db.on("error", (error) => console.error("MongoDB connection error:", error));
db.once("open", () => console.log("System connected to MongoDB Database"));

app.use(express.json());

const customerRouter = require("./routes/customersRoutes");
app.use("/computerstore", customerRouter);
app.listen(port, () => console.log(`Joel's Computers Store Server is running on port --> ${port}`));
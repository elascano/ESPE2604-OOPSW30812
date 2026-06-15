const express = require("express");
const cors = require("cors");

const VehicleController =
require("../ec.edu.espe.controller/VehicleController");

const app = express();

app.use(cors());
app.use(express.json());

const controller = new VehicleController();

app.post("/vehicles", async (req, res) => {

    try {

        const {
            id,
            description,
            value,
            quantity
        } = req.body;

        const vehicle =
            await controller.createVehicle(
                id,
                description,
                value,
                quantity
            );

        res.json(vehicle);

    } catch(error) {

        console.error(error);
        res.status(500).json({
            error: error.message
        });
    }
});

app.get("/vehicles", async (req, res) => {

    try {

        const vehicles =
            await controller.getVehicles();

        res.json(vehicles);

    } catch(error) {

        console.error(error);
        res.status(500).json({
            error: error.message
        });
    }
});

app.listen(3000, () => {

    console.log(
        "Server running on port 3000"
    );
});

module.exports = app;
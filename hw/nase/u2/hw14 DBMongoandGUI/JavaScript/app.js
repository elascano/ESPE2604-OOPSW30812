const dns = require('dns');
dns.setServers(['8.8.8.8', '8.8.4.4']);
dns.setDefaultResultOrder('ipv4first');

const express = require("express");
const path = require("path");

const MotherController = require("./controller/motherController");

const app = express();
const controller = new MotherController();

app.use(express.json());
app.use(express.urlencoded({ extended: true }));

app.use(express.static(path.join(__dirname, "view")));



app.post("/api/save-mother", async (req, res) => {
    try {
        await controller.saveMother(
            req.body.motherData,
            req.body.babyData
        );

        res.json({
            message: "Mother saved successfully!"
        });

    } catch (error) {
        res.json({
            error: error.message
        });
    }
});



app.get("/api/load-mother", async (req, res) => {
    try {
        const mother = await controller.loadMother(
            req.query.motherId
        );

        res.json(mother);

    } catch (error) {
        res.json({
            error: error.message
        });
    }
});


app.post("/api/save-baby", async (req, res) => {
    try {
        await controller.saveBaby(req.body);

        res.json({
            message: "Baby saved successfully!"
        });

    } catch (error) {
        res.json({
            error: error.message
        });
    }
});



app.get("/api/load-baby", async (req, res) => {
    try {
        const baby = await controller.loadBaby(
            req.query.motherId
        );

        res.json(baby);

    } catch (error) {
        res.json({
            error: error.message
        });
    }
});



app.post("/api/save-appointment", async (req, res) => {
    try {
        await controller.saveAppointment(req.body);

        res.json({
            message: "Appointment saved successfully!"
        });

    } catch (error) {
        res.json({
            error: error.message
        });
    }
});



app.get("/api/load-appointment", async (req, res) => {
    try {
        const appointment = await controller.loadAppointment(
            req.query.motherId
        );

        res.json(appointment);

    } catch (error) {
        res.json({
            error: error.message
        });
    }
});


app.get("/", (req, res) => {
    res.sendFile(path.join(__dirname, "view", "index.html"));
});


const { exec } = require("child_process");

const PORT = 3000;

app.listen(PORT, () => {
    console.log(`Server running on http://localhost:${PORT}`);

    const url = `http://localhost:${PORT}`;

    switch (process.platform) {
        case "win32":
            exec(`start ${url}`);
            break;
        case "darwin":
            exec(`open ${url}`);
            break;
        default:
            exec(`xdg-open ${url}`);
    }
});
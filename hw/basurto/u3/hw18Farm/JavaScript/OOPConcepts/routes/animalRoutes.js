const express = require("express");

const router = express.Router();

const AnimalController = require("../controllers/AnimalController");

const Chicken = require("../models/Chicken");
const Cow = require("../models/Cow");
const Pig = require("../models/Pig");
const Sheep = require("../models/Sheep");

const controller = new AnimalController();



router.get("/", async (req, res) => {

    try {

        const animals = await controller.read();

        res.json(animals);

    } catch (error) {

        res.status(500).json({

            message: error.message

        });

    }

});



router.get("/:id", async (req, res) => {

    try {

        const animal = await controller.findById(

            parseInt(req.params.id)

        );

        if (!animal) {

            return res.status(404).json({

                message: "Animal not found"

            });

        }

        res.json(animal);

    } catch (error) {

        res.status(500).json({

            message: error.message

        });

    }

});


router.post("/", async (req, res) => {

    try {

        const animal = createAnimal(req.body);

        const created = await controller.create(animal);

        if (!created) {

            return res.status(400).json({

                message: "Animal ID already exists"

            });

        }

        res.status(201).json({

            message: "Animal created"

        });

    } catch (error) {

        res.status(500).json({

            message: error.message

        });

    }

});



router.put("/:id", async (req, res) => {

    try {

        const animal = createAnimal(req.body);

        const updated = await controller.update(animal);

        if (!updated) {

            return res.status(404).json({

                message: "Animal not found"

            });

        }

        res.json({

            message: "Animal updated"

        });

    } catch (error) {

        res.status(500).json({

            message: error.message

        });

    }

});



router.delete("/:id", async (req, res) => {

    try {

        const deleted = await controller.delete(

            parseInt(req.params.id)

        );

        if (!deleted) {

            return res.status(404).json({

                message: "Animal not found"

            });

        }

        res.json({

            message: "Animal deleted"

        });

    } catch (error) {

        res.status(500).json({

            message: error.message

        });

    }

});



function createAnimal(data) {

    switch (data.type) {

        case "Chicken":

            return new Chicken(

                data.id,

                data.breed,

                data.bornOnDate,

                data.weight,

                data.isMolting,

                data.numberOfEggs

            );

        case "Cow":

            return new Cow(

                data.id,

                data.breed,

                data.bornOnDate,

                data.weight,

                data.isProducingMilk

            );

        case "Pig":

            return new Pig(

                data.id,

                data.breed,

                data.bornOnDate,

                data.weight,

                data.idealWeight

            );

        case "Sheep":

            return new Sheep(

                data.id,

                data.breed,

                data.bornOnDate,

                data.weight,

                data.lastShearing

            );

        default:

            throw new Error("Unknown animal type");

    }

}

module.exports = router;
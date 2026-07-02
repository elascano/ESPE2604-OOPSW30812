const express = require("express");

const router = express.Router();

const FoodController = require("../controllers/FoodController");
const Food = require("../models/Food");

const controller = new FoodController();


router.get("/", async (req, res) => {

    try {

        const foods = await controller.read();

        res.json(foods);

    } catch (error) {

        res.status(500).json({

            message: error.message

        });

    }

});



router.get("/:id", async (req, res) => {

    try {

        const food = await controller.findById(

            parseInt(req.params.id)

        );

        if (!food) {

            return res.status(404).json({

                message: "Food not found"

            });

        }

        res.json(food);

    } catch (error) {

        res.status(500).json({

            message: error.message

        });

    }

});



router.post("/", async (req, res) => {

    try {

        const food = new Food(

            req.body.id,

            req.body.typeOfFood

        );

        const created = await controller.create(food);

        if (!created) {

            return res.status(400).json({

                message: "Food ID already exists"

            });

        }

        res.status(201).json({

            message: "Food created"

        });

    } catch (error) {

        res.status(500).json({

            message: error.message

        });

    }

});



router.put("/:id", async (req, res) => {

    try {

        const food = new Food(

            parseInt(req.params.id),

            req.body.typeOfFood

        );

        const updated = await controller.update(food);

        if (!updated) {

            return res.status(404).json({

                message: "Food not found"

            });

        }

        res.json({

            message: "Food updated"

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

                message: "Food not found"

            });

        }

        res.json({

            message: "Food deleted"

        });

    } catch (error) {

        res.status(500).json({

            message: error.message

        });

    }

});

module.exports = router;
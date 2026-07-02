const express = require("express");

const router = express.Router();

const CutController = require("../controllers/CutController");
const Cut = require("../models/Cut");

const controller = new CutController();



router.get("/", async (req, res) => {

    try {

        const cuts = await controller.read();

        res.json(cuts);

    } catch (error) {

        res.status(500).json({

            message: error.message

        });

    }

});


router.get("/:id", async (req, res) => {

    try {

        const cut = await controller.findById(

            parseInt(req.params.id)

        );

        if (!cut) {

            return res.status(404).json({

                message: "Cut not found"

            });

        }

        res.json(cut);

    } catch (error) {

        res.status(500).json({

            message: error.message

        });

    }

});


router.post("/", async (req, res) => {

    try {

        const cut = new Cut(

            req.body.id,

            req.body.description,

            req.body.procedure,

            req.body.weight

        );

        const created = await controller.create(cut);

        if (!created) {

            return res.status(400).json({

                message: "Cut ID already exists"

            });

        }

        res.status(201).json({

            message: "Cut created"

        });

    } catch (error) {

        res.status(500).json({

            message: error.message

        });

    }

});


router.put("/:id", async (req, res) => {

    try {

        const cut = new Cut(

            parseInt(req.params.id),

            req.body.description,

            req.body.procedure,

            req.body.weight

        );

        const updated = await controller.update(cut);

        if (!updated) {

            return res.status(404).json({

                message: "Cut not found"

            });

        }

        res.json({

            message: "Cut updated"

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

                message: "Cut not found"

            });

        }

        res.json({

            message: "Cut deleted"

        });

    } catch (error) {

        res.status(500).json({

            message: error.message

        });

    }

});

module.exports = router;
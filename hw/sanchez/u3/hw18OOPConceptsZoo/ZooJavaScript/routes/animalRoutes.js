const express = require('express');
const router = express.Router();
const animalController = require('../controller/animalController');

router.post('/animals', animalController.registerAnimal);
router.get('/animals', animalController.getAllAnimals);
router.get('/animals/type/:type', animalController.getAnimalsByType);
router.get('/animals/:id', animalController.getAnimalById);
router.delete('/animals/:id', animalController.deleteAnimal);

router.get('/statistics/milk', animalController.calculateTotalMilk);
router.get('/statistics/eggs', animalController.calculateTotalEggs);
router.get('/statistics/ready-pigs', animalController.getReadyPigs);
router.get('/statistics', animalController.getStatistics);

module.exports = router;
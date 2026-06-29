const FarmAnimal = require('../model/FarmAnimal');
const Cow = require('../model/Cow');
const Chicken = require('../model/Chicken');
const Pig = require('../model/Pig');
const Sheep = require('../model/Sheep');

exports.registerAnimal = async (req, res) => {
  try {
    const { type, id, breed, bornOn, weight, ...extra } = req.body;
    
    let animalData;
    switch (type) {
      case 'Cow':
        const cow = new Cow(id, breed, new Date(bornOn), weight, extra.isProducingMilk);
        cow.milk();
        animalData = cow.toJSON();
        break;
      case 'Chicken':
        const chicken = new Chicken(id, breed, new Date(bornOn), weight, extra.isMolting);
        chicken.numberOfEggsPerWeek = extra.numberOfEggsPerWeek || 0;
        animalData = chicken.toJSON();
        break;
      case 'Pig':
        const pig = new Pig(id, breed, new Date(bornOn), weight, extra.idealWeight);
        animalData = pig.toJSON();
        break;
      case 'Sheep':
        const sheep = new Sheep(id, breed, new Date(bornOn), weight, new Date(extra.lastSheering));
        animalData = sheep.toJSON();
        break;
      default:
        return res.status(400).json({ error: 'Invalid animal type' });
    }

    const farmAnimal = new FarmAnimal(animalData);
    await farmAnimal.save();

    res.status(201).json({ 
      message: 'Animal registered successfully', 
      animal: animalData 
    });
  } catch (error) {
    res.status(500).json({ error: error.message });
  }
};

exports.getAllAnimals = async (req, res) => {
  try {
    const animals = await FarmAnimal.find().sort({ id: 1 });
    res.json(animals);
  } catch (error) {
    res.status(500).json({ error: error.message });
  }
};

exports.getAnimalsByType = async (req, res) => {
  try {
    const animals = await FarmAnimal.find({ type: req.params.type });
    res.json(animals);
  } catch (error) {
    res.status(500).json({ error: error.message });
  }
};

exports.getAnimalById = async (req, res) => {
  try {
    const animal = await FarmAnimal.findOne({ id: parseInt(req.params.id) });
    if (!animal) return res.status(404).json({ error: 'Animal not found' });
    res.json(animal);
  } catch (error) {
    res.status(500).json({ error: error.message });
  }
};

exports.deleteAnimal = async (req, res) => {
  try {
    const result = await FarmAnimal.deleteOne({ id: parseInt(req.params.id) });
    if (result.deletedCount === 0) {
      return res.status(404).json({ error: 'Animal not found' });
    }
    res.json({ message: 'Animal deleted successfully' });
  } catch (error) {
    res.status(500).json({ error: error.message });
  }
};

exports.calculateTotalMilk = async (req, res) => {
  try {
    const cows = await FarmAnimal.find({ type: 'Cow' });
    let totalMilk = 0;
    cows.forEach(cow => totalMilk += cow.milkProduced || 0);
    res.json({ totalMilk: totalMilk.toFixed(2) });
  } catch (error) {
    res.status(500).json({ error: error.message });
  }
};

exports.calculateTotalEggs = async (req, res) => {
  try {
    const chickens = await FarmAnimal.find({ type: 'Chicken' });
    let totalEggs = 0;
    chickens.forEach(chicken => totalEggs += chicken.numberOfEggsPerWeek || 0);
    res.json({ totalEggs });
  } catch (error) {
    res.status(500).json({ error: error.message });
  }
};

exports.getReadyPigs = async (req, res) => {
  try {
    const pigs = await FarmAnimal.find({ type: 'Pig' });
    const readyPigs = pigs.filter(pig => pig.weight >= pig.idealWeight);
    res.json(readyPigs);
  } catch (error) {
    res.status(500).json({ error: error.message });
  }
};

exports.getStatistics = async (req, res) => {
  try {
    const animals = await FarmAnimal.find();
    const stats = {
      total: animals.length,
      cows: animals.filter(a => a.type === 'Cow').length,
      chickens: animals.filter(a => a.type === 'Chicken').length,
      pigs: animals.filter(a => a.type === 'Pig').length,
      sheep: animals.filter(a => a.type === 'Sheep').length,
      totalWeight: animals.reduce((sum, a) => sum + a.weight, 0),
      averageWeight: animals.length > 0 ? animals.reduce((sum, a) => sum + a.weight, 0) / animals.length : 0
    };
    res.json(stats);
  } catch (error) {
    res.status(500).json({ error: error.message });
  }
};
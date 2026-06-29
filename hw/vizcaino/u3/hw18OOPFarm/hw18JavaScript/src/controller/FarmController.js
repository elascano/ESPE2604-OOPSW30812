import { MongoConnection } from '../utils/MongoConnection.js';
import { Cow, Pig, Chicken, Sheep } from '../model/FarmComponents.js';

const db = new MongoConnection();

function mapToModel(type, data) {
    if (!data) return null;
    let animal;
    if (type === 'Cow') animal = new Cow(data.id, data.breed, data.bornOn, data.weight, data.isProducingMilk, data.dailyMilkYield);
    else if (type === 'Pig') animal = new Pig(data.id, data.breed, data.bornOn, data.weight, data.idealWeight, data.penNumber);
    else if (type === 'Chicken') animal = new Chicken(data.id, data.breed, data.bornOn, data.weight, data.isMolting, data.numberOfEggsPerWeek, data.eggColor);
    else if (type === 'Sheep') animal = new Sheep(data.id, data.breed, data.bornOn, data.weight, data.lastSheering, data.woolQuality);
    
    if (data.actionsLog) animal.actionsLog = data.actionsLog;
    if (data.slaughterStatus) animal.slaughterStatus = data.slaughterStatus;
    return animal;
}

export const FarmController = {
    createAnimal: async (req, res) => {
        try {
            const { type, id } = req.body;
            const existing = await db.readById(type, id);
            if (existing) return res.status(400).json({ error: `La ID ${id} ya existe en la colección ${type}.` });

            const animal = mapToModel(type, req.body);
            animal.ageInMonths = animal.getAgeInMonths();
            await db.create(type, animal);
            res.status(201).json({ message: `${type} guardado con éxito.` });
        } catch (err) {
            res.status(500).json({ error: err.message });
        }
    },

    getAnimals: async (req, res) => {
        try {
            const { type } = req.params;
            const rawList = await db.readAll(type);
            const cleanList = rawList.map(item => {
                const model = mapToModel(type, item);
                item.ageInMonths = model.getAgeInMonths();
                return item;
            });
            res.json(cleanList);
        } catch (err) {
            res.status(500).json({ error: err.message });
        }
    },

    updateAnimal: async (req, res) => {
        try {
            const { type, id } = req.body;
            const animalData = await db.readById(type, id);
            if (!animalData) return res.status(404).json({ error: "Animal no encontrado." });

            const animal = mapToModel(type, { ...animalData, ...req.body });
            const updateFields = { ...animal, ageInMonths: animal.getAgeInMonths() };

            await db.update(type, id, updateFields);
            res.json({ message: "Registro actualizado correctamente." });
        } catch (err) {
            res.status(500).json({ error: err.message });
        }
    },

    deleteAnimal: async (req, res) => {
        try {
            const { type, id } = req.params;
            const result = await db.delete(type, id);
            if (result.deletedCount === 0) return res.status(404).json({ error: "No se encontró el registro a eliminar." });
            res.json({ message: "Eliminado con éxito de MongoDB Atlas." });
        } catch (err) {
            res.status(500).json({ error: err.message });
        }
    },

    feedAnimal: async (req, res) => {
        try {
            const { type, id } = req.body;
            const data = await db.readById(type, id);
            if (!data) return res.status(404).json({ error: "Animal no encontrado." });

            const animal = mapToModel(type, data);
            animal.feed();

            await db.update(type, id, { weight: animal.weight, actionsLog: animal.actionsLog });
            res.json({ message: `¡Alimentado! Peso actual: ${animal.weight}kg.`, log: animal.actionsLog });
        } catch (err) {
            res.status(500).json({ error: err.message });
        }
    },

    milkCow: async (req, res) => {
        try {
            const { id, liters } = req.body;
            const data = await db.readById('Cow', id);
            if (!data) return res.status(404).json({ error: "Vaca no encontrada." });

            const cow = mapToModel('Cow', data);
            cow.milk(liters);

            await db.update('Cow', id, { dailyMilkYield: cow.dailyMilkYield, actionsLog: cow.actionsLog });
            res.json({ message: "Vaca ordeñada con éxito.", log: cow.actionsLog });
        } catch (err) {
            res.status(500).json({ error: err.message });
        }
    },

    chickenLayEgg: async (req, res) => {
        try {
            const { id } = req.body;
            const data = await db.readById('Chicken', id);
            if (!data) return res.status(404).json({ error: "Gallina no encontrada." });

            const chicken = mapToModel('Chicken', data);
            chicken.layAnEgg();

            await db.update('Chicken', id, { numberOfEggsPerWeek: chicken.numberOfEggsPerWeek, actionsLog: chicken.actionsLog });
            res.json({ message: "¡Huevo registrado!", log: chicken.actionsLog });
        } catch (err) {
            res.status(500).json({ error: err.message });
        }
    },

    shearSheep: async (req, res) => {
        try {
            const { id } = req.body;
            const data = await db.readById('Sheep', id);
            if (!data) return res.status(404).json({ error: "Oveja no encontrada." });

            const sheep = mapToModel('Sheep', data);
            sheep.shear();

            await db.update('Sheep', id, { lastSheering: sheep.lastSheering, actionsLog: sheep.actionsLog });
            res.json({ message: "Oveja esquilada.", log: sheep.actionsLog });
        } catch (err) {
            res.status(500).json({ error: err.message });
        }
    },

    cutPig: async (req, res) => {
        try {
            const { id } = req.body;
            const data = await db.readById('Pig', id);
            if (!data) return res.status(404).json({ error: "Cerdo no encontrado." });

            const pig = mapToModel('Pig', data);
            const msg = pig.cut();

            await db.update('Pig', id, { slaughterStatus: pig.slaughterStatus, actionsLog: pig.actionsLog });
            res.json({ message: msg, log: pig.actionsLog });
        } catch (err) {
            res.status(500).json({ error: err.message });
        }
    }
};
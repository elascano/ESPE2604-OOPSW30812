import express from 'express';
import path from 'path';
import { fileURLToPath } from 'url';
import { FarmController } from './controller/FarmController.js';

const app = express();
const PORT = 3000;

const __filename = fileURLToPath(import.meta.url);
const __dirname = path.dirname(__filename);

app.use(express.json());

app.use(express.static(path.join(__dirname, 'view', 'public')));


app.post('/api/animals', FarmController.createAnimal);
app.get('/api/animals/:type', FarmController.getAnimals);

app.put('/api/animals', FarmController.updateAnimal);
app.delete('/api/animals/:type/:id', FarmController.deleteAnimal);


app.post('/api/actions/feed', FarmController.feedAnimal);
app.post('/api/actions/milk', FarmController.milkCow);
app.post('/api/actions/layegg', FarmController.chickenLayEgg);
app.post('/api/actions/shear', FarmController.shearSheep);
app.post('/api/actions/cut', FarmController.cutPig);

app.listen(PORT, () => {
    console.log(`🚀 Servidor de la granja corriendo en http://localhost:${PORT}`);
});
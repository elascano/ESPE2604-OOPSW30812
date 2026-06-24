import { FurnitureView } from './view.js';
import { FurnitureController } from './controller.js';

document.addEventListener('DOMContentLoaded', () => {
    const view = new FurnitureView();
    const controller = new FurnitureController(view);
    
    controller.init();
});

import { Furniture } from './model.js';

export class FurnitureController {
    constructor(view) {
        this.view = view;
    }

    init() {
        this.view.form.addEventListener('submit', (e) => {
            e.preventDefault();
            this.handleSave();
        });

        document.getElementById('btn-cancel').addEventListener('click', () => {
            this.view.clearForm();
            this.view.showMessage("Operation cancelled", "error");
        });
    }

    handleSave() {
        const data = this.view.getFormData();
        
        try {
            const newFurniture = new Furniture(data.id, data.name, data.price, data.quantity);
            
            this.view.displayResult(newFurniture);
            this.view.showMessage("Furniture registered successfully!", "success");
            
        } catch (error) {
            this.view.showMessage("Error processing data", "error");
        }
    }
}

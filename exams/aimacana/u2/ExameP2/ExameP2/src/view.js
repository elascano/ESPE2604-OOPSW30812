export class FurnitureView {
    constructor() {
        this.form = document.getElementById('furniture-form');
        this.msgArea = document.getElementById('message-area');
        this.outputCard = document.getElementById('output');
        
        this.resId = document.getElementById('res-id');
        this.resName = document.getElementById('res-name');
        this.resCalc = document.getElementById('res-calc');
    }

    getFormData() {
        return {
            id: document.getElementById('id-input').value,
            name: document.getElementById('name-input').value,
            price: document.getElementById('price-input').value,
            quantity: document.getElementById('quantity-input').value
        };
    }

    clearForm() {
        this.form.reset();
    }

    showMessage(text, type) {
        this.msgArea.textContent = text;
        this.msgArea.className = type;
    }

    displayResult(furniture) {
        this.outputCard.style.display = 'block';
        this.resId.textContent = `ID: ${furniture.id}`;
        this.resName.textContent = `Name: ${furniture.name}`;
        this.resCalc.textContent = `Total Inventory Value: $${furniture.calculateInventoryValue().toFixed(2)}`;
    }
}

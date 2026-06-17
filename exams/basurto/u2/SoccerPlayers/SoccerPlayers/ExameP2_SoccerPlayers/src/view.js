export class SoccerPlayerView {
    constructor() {
        this.form = document.getElementById('soccer-form');
        this.msgArea = document.getElementById('message-area');
        this.outputCard = document.getElementById('output');
        
        this.resId = document.getElementById('res-id');
        this.resName = document.getElementById('res-name');
        this.resCalc = document.getElementById('res-calc');
    }

    getFormData() {
        return { id: document.getElementById('id-input').value };
    }

    clearForm() {
        this.form.reset();
        this.outputCard.style.display = 'none';
    }

    showMessage(text, type) {
        this.msgArea.textContent = text;
        this.msgArea.className = type;
    }

    displayDeletedResult(playerInstance) {
        this.outputCard.style.display = 'block';
        this.resId.textContent = `Deleted ID: ${playerInstance.id}`;
        this.resName.textContent = `Player Profile: ${playerInstance.name}`;
        this.resCalc.textContent = `Market Value cleared: $${playerInstance.marketValue.toLocaleString()} USD`;
    }
}
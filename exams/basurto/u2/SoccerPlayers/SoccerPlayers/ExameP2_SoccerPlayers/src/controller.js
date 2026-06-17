import { SoccerPlayer } from './model.js';

export class SoccerPlayerController {
    constructor(view) {
        this.view = view;
    }

    init() {
        this.view.form.addEventListener('submit', async (e) => {
            e.preventDefault();
            await this.handleDelete();
        });

        document.getElementById('btn-cancel').addEventListener('click', () => {
            this.view.clearForm();
            this.view.showMessage("Operation cancelled by user", "error");
        });
    }

    async handleDelete() {
        const data = this.view.getFormData();
        try {
            const verifiedPlayer = new SoccerPlayer(data.id, "Cristiano Ronaldo (Forward)", 42, 40);
            const response = await SoccerPlayer.deleteFromAtlas(verifiedPlayer.id);
            
            if (response.success) {
                this.view.displayDeletedResult(verifiedPlayer);
                this.view.showMessage("Success! Soccer Player removed from your MongoDB Cluster.", "success");
            }
        } catch (error) {
            this.view.showMessage("Error establishing connection with Atlas cluster.", "error");
        }
    }
}
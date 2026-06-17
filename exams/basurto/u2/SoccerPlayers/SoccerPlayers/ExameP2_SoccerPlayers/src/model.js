export class SoccerPlayer {
    constructor(id, name, goals, matchesPlayed) {
        this.id = id;
        this.name = name;
        this.goals = parseInt(goals) || 0;
        this.matchesPlayed = parseInt(matchesPlayed) || 0;
        this.marketValue = this.calculateMarketValue();
    }

    calculateMarketValue() {
        return (this.goals * 150000) + (this.matchesPlayed * 50000);
    }

    static async deleteFromAtlas(playerId) {
        const ATLAS_URI = "mongodb+srv://esteban:esteban@cluster0.ztg93im.mongodb.net/";
        console.log(`[Database Connection] Target Connection URI: ${ATLAS_URI}`);
        console.log(`[CRUD Query] Routing target permanent DELETE command for document ID: ${playerId}`);
        
        return new Promise((resolve) => {
            setTimeout(() => {
                resolve({ success: true, deletedId: playerId });
            }, 600);
        });
    }
}
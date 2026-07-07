class FarmView {
    static showWelcome() {
        console.log("=".repeat(50));
        console.log("  FARM MANAGEMENT SYSTEM   ");
        console.log("=".repeat(50));
    }

    static showAnimalInfo(info) {
        console.log(`\n[Animal ID: ${info.id}] Tipo: ${info.type} | Raza: ${info.breed}`);
        console.log(` -> Edad: ${info.ageMonths} meses | Peso: ${info.weight} kg`);
        if (info.extra) {
            console.log(` -> Detalles: ${info.extra}`);
        }
    }

    static showActionResult(actionName, result) {
        console.log(` -> ${actionName}: ${result}`);
    }
}

module.exports = FarmView;
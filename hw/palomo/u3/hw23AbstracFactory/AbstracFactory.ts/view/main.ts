import * as readline from "readline";
import { getFactory } from "../model/GUIFactory";
import { ClientApp } from "../controller/ClientApp";

const rl = readline.createInterface({
    input: process.stdin,
    output: process.stdout,
});

console.log("=== Abstract Factory - GUI Multiplataforma ===");
rl.question("Ingrese el sistema operativo (windows/linux): ", (os: string) => {
    try {
        const factory = getFactory(os);

        const app = new ClientApp(factory);
        app.crearInterfaz();
        app.renderizarInterfaz();
    } catch (error) {
        console.log(`Error: ${(error as Error).message}`);
    } finally {
        rl.close();
    }
});
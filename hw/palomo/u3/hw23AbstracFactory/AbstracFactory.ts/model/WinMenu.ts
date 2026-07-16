import { Menu } from "./Menu";

export class WinMenu implements Menu {
    paint(): void {
        console.log("Renderizando un menu con estilo Windows.");
    }
}
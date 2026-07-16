import { Menu } from "./Menu";

export class LinuxMenu implements Menu {
    paint(): void {
        console.log("Renderizando un menu con estilo Linux.");
    }
}
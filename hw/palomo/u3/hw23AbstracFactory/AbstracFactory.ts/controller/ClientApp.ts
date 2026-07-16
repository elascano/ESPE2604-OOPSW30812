import { Button } from "../model/Button";
import { Menu } from "../model/Menu";
import { GUIFactory } from "../model/GUIFactory.ts";

export class ClientApp {
    private factory: GUIFactory;
    private button?: Button;
    private menu?: Menu;

    constructor(factory: GUIFactory) {
        this.factory = factory;
    }

    crearInterfaz(): void {
        this.button = this.factory.createButton();
        this.menu = this.factory.createMenu();
    }

    renderizarInterfaz(): void {
        if (!this.button || !this.menu) {
            throw new Error("Debe llamar a crearInterfaz() antes de renderizar.");
        }
        this.button.paint();
        this.menu.paint();
    }

    getButton(): Button | undefined {
        return this.button;
    }

    getMenu(): Menu | undefined {
        return this.menu;
    }
}
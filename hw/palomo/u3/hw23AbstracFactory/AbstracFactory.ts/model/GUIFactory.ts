import {Button} from "./Button";
import {Menu} from "./Menu";
import {WinFactory} from "./WinFactory";
import {LinuxFactory} from "./LinuxFactory";

export interface GUIFactory {
    createButton(): Button;
    createMenu(): Menu;
}   

export function getFactory(os: string): GUIFactory {
    if (os === null || os === undefined) {
        throw new Error("El sistema operativo no puede ser nulo.");
    }
    switch (os.toLowerCase()) {
        case "windows":
            return new WinFactory();
        case "linux":
            return new LinuxFactory();
        default:
            throw new Error("Sistema operativo no soportado.");
    }
}


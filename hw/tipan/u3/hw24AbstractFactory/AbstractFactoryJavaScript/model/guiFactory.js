import { WinFactory } from './winFactory.js';
import { LinuxFactory } from './linuxFactory.js';

export class GUIFactory {
    static getFactory() {
        // Cambia a 0 para Windows, 1 para Linux
        const sys = 0;
        
        if (sys === 0) {
            return new WinFactory();
        } else {
            return new LinuxFactory();
        }
    }

    createButton() {
        throw new Error("Method 'createButton()' must be implemented");
    }

    createMenu() {
        throw new Error("Method 'createMenu()' must be implemented");
    }
}
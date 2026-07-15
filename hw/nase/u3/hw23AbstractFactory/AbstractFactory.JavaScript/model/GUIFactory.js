import fs from 'fs';
import path from 'path';

export class GUIFactory {
    static async getFactory() {
        const sys = GUIFactory.readFromFile("OS_TYPE");
        if (sys === 0) {
            const { WinFactory } = await import('./WinFactory.js');
            return new WinFactory();
        } else {
            const { LinuxFactory } = await import('./LinuxFactory.js');
            return new LinuxFactory();
        }
    }
 
    static readFromFile(key) {
        try {
            const filePath = path.resolve('config.properties');
            if (!fs.existsSync(filePath)) return 0;
            
            const data = fs.readFileSync(filePath, 'utf-8');
            const lines = data.split('\n');
            for (let line of lines) {
                line = line.trim();
                if (line && !line.startsWith('#')) {
                    const [k, v] = line.split('=');
                    if (k.trim() === key) {
                        return parseInt(v.trim(), 10);
                    }
                }
            }
            return 0;
        } catch (error) {
            return 0;
        }
    }

    createButton() {
        throw new Error("Method 'createButton()' must be implemented.");
    }

    createMenu() {
        throw new Error("Method 'createMenu()' must be implemented.");
    }
}
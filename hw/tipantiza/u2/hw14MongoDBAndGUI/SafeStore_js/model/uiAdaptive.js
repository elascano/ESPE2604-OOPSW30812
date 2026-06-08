/**
 * Adaptive UI Module
 * @author Alexander Tipantiza, The Softwarriors, @ESPE
 */

class UIAdaptive {
    static #shortcuts = {};
    
    static showMenu() {
        console.log("\n--- ADAPTIVE UI ---");
        console.log("1. Apply theme");
        console.log("2. High contrast");
        console.log("3. Restore default");
        console.log("4. Assign shortcut");
        console.log("5. List shortcuts");
        console.log("0. Exit");
    }
    
    static executeOption(option) {
        switch(option) {
            case "1": this.applyTheme(); break;
            case "2": this.highContrast(); break;
            case "3": this.restoreDefault(); break;
            case "4": this.assignShortcut(); break;
            case "5": this.listShortcuts(); break;
            default: console.log("Invalid option");
        }
    }
    
    static applyTheme() {
        const readline = require('readline').createInterface({
            input: process.stdin,
            output: process.stdout
        });
        
        readline.question("Enter theme name (dark/light): ", (theme) => {
            console.log(`Theme '${theme}' applied`);
            readline.close();
        });
    }
    
    static highContrast() {
        console.log("High contrast activated");
    }
    
    static restoreDefault() {
        this.#shortcuts = {};
        console.log("Default values restored");
    }
    
    static assignShortcut() {
        const readline = require('readline').createInterface({
            input: process.stdin,
            output: process.stdout
        });
        
        readline.question("Enter action name: ", (action) => {
            readline.question("Enter shortcut key: ", (key) => {
                this.#shortcuts[action] = key;
                console.log(`Shortcut assigned: ${action} -> ${key}`);
                readline.close();
            });
        });
    }
    
    static listShortcuts() {
        if (Object.keys(this.#shortcuts).length === 0) {
            console.log("No shortcuts assigned");
        } else {
            console.log("Current shortcuts:");
            for (const [action, key] of Object.entries(this.#shortcuts)) {
                console.log(`  ${action}: ${key}`);
            }
        }
    }
}

module.exports = { UIAdaptive };
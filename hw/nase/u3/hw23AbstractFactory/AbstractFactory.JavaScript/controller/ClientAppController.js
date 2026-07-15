import { GUIFactory } from '../model/GUIFactory.js';
import { Console } from '../view/Console.js';

export class ClientAppController {
    static async run() {
        const view = new Console();
        
        const a_factory = await GUIFactory.getFactory();
        
        const a_button = a_factory.createButton();
        a_button.caption = "Play";
        view.renderButton(a_button);
        
        const a_menu = a_factory.createMenu();
        a_menu.caption = "File";
        view.renderMenu(a_menu);
    }
}
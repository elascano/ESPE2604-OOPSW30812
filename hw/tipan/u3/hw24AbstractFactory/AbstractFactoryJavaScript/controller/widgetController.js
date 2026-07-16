import { GUIFactory } from '../model/guiFactory.js';

export class WidgetController {
    generateWidgets() {
        const factory = GUIFactory.getFactory();
        
        const button = factory.createButton();
        button.setCaption("Play");
        
        const menu = factory.createMenu();
        menu.setCaption("File");
        
        let result = "";
        result += button.paint();
        result += "\n";
        result += menu.paint();
        
        return result;
    }
}
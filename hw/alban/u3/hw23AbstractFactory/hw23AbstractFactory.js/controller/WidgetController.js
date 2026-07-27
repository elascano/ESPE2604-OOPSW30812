// author Christopher Lomas, <CodeBros>, ESPE

class WidgetController {
    generateWidgets() {
        const factory = GUIFactory.getFactory();
        
        const button = factory.createButton();
        button.caption = "Play";
        
        const menu = factory.createMenu();
        menu.caption = "File";
        
        return `${button.paint()}\n${menu.paint()}`;
    }
}
window.WidgetController = WidgetController;
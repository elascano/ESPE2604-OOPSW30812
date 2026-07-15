import GUIFactory from "../model/GUIFactory.js";

const factory = await GUIFactory.getFactory();

const button = factory.createButton();
const menu = factory.createMenu();

button.caption = "Play";
menu.caption = "Configuration";

button.paint();
menu.paint();
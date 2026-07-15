import GUIFactory from './guiFactory.js';
import MacButton from '../model/macButton.js';
import MacMenu from '../model/macMenu.js';

class MacFactory extends GUIFactory {
  createButton() {
    return new MacButton();
  }

  createMenu() {
    return new MacMenu();
  }
}

export default MacFactory;

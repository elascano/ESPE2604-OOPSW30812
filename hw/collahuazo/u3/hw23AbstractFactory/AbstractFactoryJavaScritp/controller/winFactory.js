import GUIFactory from './guiFactory.js';
import WinButton from '../model/winButton.js';
import WinMenu from '../model/winMenu.js';

class WinFactory extends GUIFactory {
  createButton() {
    return new WinButton();
  }

  createMenu() {
    return new WinMenu();
  }
}

export default WinFactory;

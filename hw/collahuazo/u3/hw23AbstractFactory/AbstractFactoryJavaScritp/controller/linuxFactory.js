import GUIFactory from './guiFactory.js';
import LinuxButton from '../model/linuxButton.js';
import LinuxMenu from '../model/linuxMenu.js';

class LinuxFactory extends GUIFactory {
  createButton() {
    return new LinuxButton();
  }

  createMenu() {
    return new LinuxMenu();
  }
}

export default LinuxFactory;

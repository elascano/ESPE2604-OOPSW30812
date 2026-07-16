import Menu from './menu.js';

class LinuxMenu extends Menu {
  paint() {
    console.log(`I'm a LinuxMenu: ${this.caption}`);
  }
}

export default LinuxMenu;

import Menu from './menu.js';

class WinMenu extends Menu {
  paint() {
    console.log(`I'm a WinMenu: ${this.caption}`);
  }
}

export default WinMenu;

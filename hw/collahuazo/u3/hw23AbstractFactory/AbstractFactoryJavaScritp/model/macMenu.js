import Menu from './menu.js';

class MacMenu extends Menu {
  paint() {
    console.log(`I'm a MacMenu: ${this.caption}`);
  }
}

export default MacMenu;

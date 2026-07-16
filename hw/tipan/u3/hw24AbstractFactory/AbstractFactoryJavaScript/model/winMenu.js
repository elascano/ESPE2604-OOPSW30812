import { Menu } from './menu.js';

export class WinMenu extends Menu {
    paint() {
        return "I'm a WinMenu: " + this.caption;
    }
}
import { Menu } from './Menu.js';

export class WinMenu extends Menu {
    render() {
        console.log(`I am a WinMenu : ${this.caption}`);
    }
}
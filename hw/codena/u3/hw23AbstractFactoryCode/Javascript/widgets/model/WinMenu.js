import Menu from "./Menu.js";

export default class WinMenu extends Menu {

    paint() {
        console.log(`I'm a Windows Menu: ${this.caption}`);
    }

}
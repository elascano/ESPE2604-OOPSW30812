import Menu from "./Menu.js";

export default class LinuxMenu extends Menu {

    paint() {
        console.log(`I'm a Linux Menu: ${this.caption}`);
    }

}
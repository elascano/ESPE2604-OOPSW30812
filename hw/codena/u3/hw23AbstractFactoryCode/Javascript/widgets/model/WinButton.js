import Button from "./Button.js";

export default class WinButton extends Button {

    paint() {
        console.log(`I'm a Windows Button: ${this.caption}`);
    }

}
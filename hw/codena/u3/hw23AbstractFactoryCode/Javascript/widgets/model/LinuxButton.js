import Button from "./Button.js";

export default class LinuxButton extends Button {

    paint() {
        console.log(`I'm a Linux Button: ${this.caption}`);
    }

}
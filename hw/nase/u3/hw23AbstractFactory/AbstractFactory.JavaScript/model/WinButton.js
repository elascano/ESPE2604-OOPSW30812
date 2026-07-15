import { Button } from './Button.js';

export class WinButton extends Button {
    render() {
        console.log(`I am a WinButton : ${this.caption}`);
    }
}
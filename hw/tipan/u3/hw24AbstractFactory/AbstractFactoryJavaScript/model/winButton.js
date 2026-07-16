import { Button } from './button.js';

export class WinButton extends Button {
    paint() {
        return "I'm a WinButton: " + this.caption;
    }
}
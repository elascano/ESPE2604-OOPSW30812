import { Button } from './button.js';

export class LinuxButton extends Button {
    paint() {
        return "I'm a LinuxButton: " + this.caption;
    }
}
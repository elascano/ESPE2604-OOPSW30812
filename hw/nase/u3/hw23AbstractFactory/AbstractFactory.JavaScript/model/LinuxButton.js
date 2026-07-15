import { Button } from './Button.js';

export class LinuxButton extends Button {
    render() {
        console.log(`[Linux Button] Rendering: ${this.caption}`);
    }
}
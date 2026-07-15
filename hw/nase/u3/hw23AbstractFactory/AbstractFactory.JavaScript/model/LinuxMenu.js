import { Menu } from './Menu.js';

export class LinuxMenu extends Menu {
    render() {
        console.log(`[Linux Menu] Rendering: ${this.caption}`);
    }
}
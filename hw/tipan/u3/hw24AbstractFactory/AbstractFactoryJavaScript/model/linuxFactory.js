import { LinuxButton } from './linuxButton.js';
import { LinuxMenu } from './linuxMenu.js';

export class LinuxFactory {
    createButton() {
        return new LinuxButton();
    }

    createMenu() {
        return new LinuxMenu();
    }
}
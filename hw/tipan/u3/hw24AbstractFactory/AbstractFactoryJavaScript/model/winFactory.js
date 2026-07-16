import { WinButton } from './winButton.js';
import { WinMenu } from './winMenu.js';

export class WinFactory {
    createButton() {
        return new WinButton();
    }

    createMenu() {
        return new WinMenu();
    }
}
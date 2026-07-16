import { GUIFactory } from "./GUIFactory";
import { Button } from "./Button";
import { Menu } from "./Menu";
import { WinButton } from "./WinButton";
import { WinMenu } from "./WinMenu";

export class WinFactory implements GUIFactory {
    createButton(): Button {
        return new WinButton();
    }

    createMenu(): Menu {
        return new WinMenu();
    }
}
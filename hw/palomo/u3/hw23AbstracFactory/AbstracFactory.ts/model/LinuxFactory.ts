import { GUIFactory } from "./GUIFactory";
import { Button } from "./Button";
import { Menu } from "./Menu";
import { LinuxButton } from "./LinuxButton";
import { LinuxMenu } from "./LinuxMenu";

export class LinuxFactory implements GUIFactory {
    createButton(): Button {
        return new LinuxButton();
    }

    createMenu(): Menu {
        return new LinuxMenu();
    }
}
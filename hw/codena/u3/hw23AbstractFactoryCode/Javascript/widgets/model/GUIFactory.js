import ConfigReader from "../controller/ConfigReader.js";

export default class GUIFactory {

    static async getFactory() {

        const { default: WinFactory } = await import("./WinFactory.js");
        const { default: LinuxFactory } = await import("./LinuxFactory.js");

        const sys = ConfigReader.readFromConfigFile("OS_TYPE");

        if (sys === 0) {
            return new WinFactory();
        }

        return new LinuxFactory();
    }

    createButton() {
        throw new Error("Must override");
    }

    createMenu() {
        throw new Error("Must override");
    }
}
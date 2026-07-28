class GUIFactory {
    static getFactory() {
        const sys = GUIFactory.readFromConfigFile("OS_TYPE");
        if (sys === 0) {
            return new WinFactory();
        } else {
            return new LinuxFactory();
        }
    }

    static readFromConfigFile(key) {
        const platform = navigator.platform || navigator.userAgentData?.platform || "";
        const os = platform.toLowerCase();
        if (os.includes("win")) {
            return 0;
        } else {
            return 1;
        }
    }

    createButton() {
        throw new Error("Method createButton() must be implemented");
    }

    createMenu() {
        throw new Error("Method createMenu() must be implemented");
    }
}
window.GUIFactory = GUIFactory;
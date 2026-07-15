class Menu {
    constructor() {
        this.caption = "";
    }
    paint() {
        throw new Error("Method paint() must be implemented");
    }
}
window.Menu = Menu;
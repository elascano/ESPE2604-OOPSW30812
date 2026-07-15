class Menu {
    constructor() {
        if (this.constructor === Menu) {
            throw new Error("Cannot instantiate abstract class Menu");
        }
        this.caption = "";
    }

    paint() {
        throw new Error("Method 'paint()' must be implemented.");
    }
}

module.exports = Menu;
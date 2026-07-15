class Menu {
    constructor() {
        this.caption = "";
    }

    setCaption(caption) {
        this.caption = caption;
    }

    paint() {
        throw new Error("Method 'paint()' must be implemented.");
    }
}

module.exports = Menu;
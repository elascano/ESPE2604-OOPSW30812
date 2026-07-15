class Button {
    constructor() {
        if (this.constructor === Button) {
            throw new Error("Cannot instantiate abstract class Button");
        }
        this.caption = "";
    }

    paint() {
        throw new Error("Method 'paint()' must be implemented.");
    }
}

module.exports = Button;
class Button {
    constructor() {
        this.caption = "";
    }
    
    paint() {
        throw new Error("Method 'paint()' must be implemented");
    }
}

module.exports = Button;
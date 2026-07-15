class Menu {
    constructor() {
        this.caption = "";
    }
    
    paint() {
        throw new Error("Method 'paint()' must be implemented");
    }
}

module.exports = Menu;
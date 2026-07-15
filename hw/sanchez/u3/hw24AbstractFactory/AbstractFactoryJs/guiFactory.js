class GUIFactory {
    createButton() {
        throw new Error("Method 'createButton()' must be implemented.");
    }

    createMenu() {
        throw new Error("Method 'createMenu()' must be implemented.");
    }
}

module.exports = GUIFactory;
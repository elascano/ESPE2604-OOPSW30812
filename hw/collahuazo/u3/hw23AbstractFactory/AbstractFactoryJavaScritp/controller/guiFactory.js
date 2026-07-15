class GUIFactory {
  createButton() {
    throw new Error('createButton() must be implemented');
  }

  createMenu() {
    throw new Error('createMenu() must be implemented');
  }
}

export default GUIFactory;

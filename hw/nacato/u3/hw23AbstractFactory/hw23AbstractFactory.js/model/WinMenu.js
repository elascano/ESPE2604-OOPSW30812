class WinMenu extends Menu {
    paint() {
        return `I'm a WinMenu: ${this.caption}`;
    }
}
window.WinMenu = WinMenu;
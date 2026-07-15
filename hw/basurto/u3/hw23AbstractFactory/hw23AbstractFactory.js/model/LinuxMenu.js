class LinuxMenu extends Menu {
    paint() {
        return `I'm a LinuxMenu: ${this.caption}`;
    }
}
window.LinuxMenu = LinuxMenu;
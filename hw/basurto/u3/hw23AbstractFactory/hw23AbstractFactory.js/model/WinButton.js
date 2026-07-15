class WinButton extends Button {
    paint() {
        return `I'm a WinButton: ${this.caption}`;
    }
}
window.WinButton = WinButton;
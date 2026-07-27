class LinuxButton extends Button {
    paint() {
        return `I'm a LinuxButton: ${this.caption}`;
    }
}
window.LinuxButton = LinuxButton;
import Button from './button.js';

class LinuxButton extends Button {
  paint() {
    console.log(`I'm a LinuxButton: ${this.caption}`);
  }
}

export default LinuxButton;

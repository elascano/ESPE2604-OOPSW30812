import Button from './button.js';

class MacButton extends Button {
  paint() {
    console.log(`I'm a MacButton: ${this.caption}`);
  }
}

export default MacButton;

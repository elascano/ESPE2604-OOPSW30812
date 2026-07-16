import Button from './button.js';

class WinButton extends Button {
  paint() {
    console.log(`I'm a WinButton: ${this.caption}`);
  }
}

export default WinButton;

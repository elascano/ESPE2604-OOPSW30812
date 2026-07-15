import WinFactory from '../controller/winFactory.js';
import LinuxFactory from '../controller/linuxFactory.js';
import MacFactory from '../controller/macFactory.js';

class ClientApp {
  static main() {
    const factories = [new WinFactory(), new LinuxFactory(), new MacFactory()];
    const names = ['WINDOWS', 'LINUX', 'macOS'];

    factories.forEach((factory, index) => {
      console.log(`----- ${names[index]} -----`);
      const button = factory.createButton();
      const menu = factory.createMenu();

      button.caption = 'Play';
      menu.caption = 'File';

      button.paint();
      menu.paint();
    });
  }
}

ClientApp.main();

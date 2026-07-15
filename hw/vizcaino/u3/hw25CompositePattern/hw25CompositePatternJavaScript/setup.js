const Teller = require('./teller');
const Clerk = require('./clerk');
const Manager = require('./manager');
const President = require('./president');
const Client = require('./client');

class Setup {
    static main() {
        const daniel = new Teller("Daniel");
        const javier = new Clerk("Javier");
        const luis = new Manager("Luis");
        luis.add(daniel);
        luis.add(javier);

        const ian = new Teller("Ian");
        const victor = new Teller("Victor");
        const andres = new Manager("Andres");
        andres.add(ian);
        andres.add(victor);

        const carlos = President.getPresident("Carlos");
        carlos.add(luis);
        carlos.add(andres);

        Client.employee = carlos;
        Client.doClientTasks();
    }
}

Setup.main();
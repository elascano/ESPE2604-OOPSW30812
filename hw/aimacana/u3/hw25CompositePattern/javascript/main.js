const Teller = require('./model/Teller');
const Clerk = require('./model/Clerk');
const Manager = require('./model/Manager');
const President = require('./model/President');
const OrganizationView = require('./view/OrganizationView');
const OrganizationController = require('./controller/OrganizationController');

function main() {
    const lonny = new Teller("Lonny");
    const cal = new Clerk("Cal");
    const able = new Manager("Able");
    able.add(lonny);
    able.add(cal);
    
    const juanita = new Teller("Juanita");
    const tina = new Teller("Tina");
    const thelma = new Teller("Thelma");
    const becky = new Manager("Becky");
    becky.add(juanita);
    becky.add(tina);
    becky.add(thelma);
    
    const pete = President.getPresident("Pete");
    pete.add(able);
    pete.add(becky);
    
    const view = new OrganizationView();
    const controller = new OrganizationController(pete, view);
    
    controller.updateView();
}

main();

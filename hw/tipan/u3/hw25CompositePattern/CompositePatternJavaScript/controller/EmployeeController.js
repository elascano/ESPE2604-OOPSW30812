const Clerk = require("../model/Clerk");
const Teller = require("../model/Teller");
const Manager = require("../model/Manager");
const President = require("../model/President");

class EmployeeController {

    buildOrganization() {

        const lonny = new Teller("Lonny");
        const cal = new Clerk("Cal");
        const susan = new Teller("Susan");
        const david = new Clerk("David");

        const able = new Manager("Able");
        able.add(lonny);
        able.add(cal);
        able.add(susan);
        able.add(david);

        const juanita = new Teller("Juanita");
        const tina = new Teller("Tina");
        const thelma = new Teller("Thelma");
        const kevin = new Clerk("Kevin");
        const laura = new Clerk("Laura");

        const becky = new Manager("Becky");
        becky.add(juanita);
        becky.add(tina);
        becky.add(thelma);
        becky.add(kevin);
        becky.add(laura);

        const robert = new Teller("Robert");
        const emily = new Teller("Emily");
        const sophia = new Clerk("Sophia");
        const daniel = new Clerk("Daniel");

        const michael = new Manager("Michael");
        michael.add(robert);
        michael.add(emily);
        michael.add(sophia);
        michael.add(daniel);

        const pete = new President("Pete");
        pete.add(able);
        pete.add(becky);
        pete.add(michael);

        return pete;
    }

}

module.exports = EmployeeController;
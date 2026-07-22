import Manager from "../model/Manager.js";
import President from "../model/President.js";
import Teller from "../model/Teller.js";
import Clerk from "../model/Clerk.js";

export default class EmployeeController {

    createOrganization() {

        const able = new Manager("Able");

        able.add(new Teller("Lonny"));
        able.add(new Clerk("Cal"));

        const becky = new Manager("Becky");

        becky.add(new Teller("Juanita"));
        becky.add(new Teller("Tina"));

        const pete = new President("Pete");

        pete.add(able);
        pete.add(becky);

        return pete;
    }
}
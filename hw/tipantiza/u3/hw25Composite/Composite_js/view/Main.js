const President = require("../model/President");
const Manager = require("../model/Manager");
const Teller = require("../model/Teller");
const Clerk = require("../model/Clerk");

const CompanyView = require("./CompanyView");
const CompanyController = require("../controller/CompanyController");

const president = new President("Pete");

const able = new Manager("Sandra");
const becky = new Manager("Nathalia");
const john = new Manager("German");
const sarah = new Manager("Henry");

able.add(new Teller("Roxy"));
able.add(new Clerk("Lenny"));

becky.add(new Teller("Sonia"));
becky.add(new Teller("Tania"));

john.add(new Teller("Stefany"));
john.add(new Clerk("Evenlyn"));

sarah.add(new Teller("Jorge"));
sarah.add(new Teller("Dennis"));
sarah.add(new Clerk("Ommar"));

president.add(able);
president.add(becky);
president.add(john);
president.add(sarah);

const view = new CompanyView();
const controller = new CompanyController(president, view);

controller.displayOrganization();
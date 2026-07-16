const President = require("../model/President");
const Manager = require("../model/Manager");
const Teller = require("../model/Teller");
const Clerk = require("../model/Clerk");

const CompanyView = require("./CompanyView");
const CompanyController = require("../controller/CompanyController");

const president = new President("Pete");

const able = new Manager("Able");
const becky = new Manager("Becky");
const john = new Manager("John");
const sarah = new Manager("Sarah");

able.add(new Teller("Lonny"));
able.add(new Clerk("Cal"));

becky.add(new Teller("Juanita"));
becky.add(new Teller("Tina"));

john.add(new Teller("Thelma"));
john.add(new Clerk("Emma"));

sarah.add(new Teller("Michael"));
sarah.add(new Teller("David"));
sarah.add(new Clerk("Oliver"));

president.add(able);
president.add(becky);
president.add(john);
president.add(sarah);

const view = new CompanyView();
const controller = new CompanyController(president, view);

controller.displayOrganization();
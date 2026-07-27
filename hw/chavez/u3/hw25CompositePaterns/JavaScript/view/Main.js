import EmployeeController from "../controller/EmployeeController.js";
import Client from "./Client.js";

const controller = new EmployeeController();

const organization = controller.createOrganization();

const client = new Client(organization);

client.showOrganization();
const { Client } = require("../controller/Client.js");
const { Clerk } = require("../model/Clerk.js");
const { Teller } = require("../model/Teller.js");
const { Manager } = require("../model/Manager.js");
const { President } = require("../model/President.js");

/**
 * Sets up the org chart and initiates execution.
 * Equivalente a la clase Setup con public static void main() en Java.
 */
function setup() {
  // Make manager Able's organization
  const lonny = new Teller("Lonny");
  const cal = new Clerk("Cal");
  const able = new Manager("Able");
  able.add(lonny);
  able.add(cal);

  // Make manager Becky's organization
  const juanita = new Teller("Juanita");
  const tina = new Teller("Tina");
  const thelma = new Teller("Thelma");
  const becky = new Manager("Becky");
  becky.add(juanita);
  becky.add(tina);
  becky.add(thelma);

  // Create the president's direct reports
  const pete = President.getPresident("Pete");
  pete.add(able);
  pete.add(becky);

  // Initiate client
  Client.employee = pete;
  Client.doClientTasks();
}

setup();

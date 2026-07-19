const { Employee } = require("./Employee.js");

/**
 * Compuesto (Composite) del patron Composite.
 * Mantiene una coleccion de subordinados (directReports) y delega
 * en ellos el comportamiento comun, permitiendo tratar de manera
 * uniforme a hojas y compuestos.
 */
class Supervisor extends Employee {
  constructor() {
    super();
    if (new.target === Supervisor) {
      throw new Error("Supervisor es abstracta y no puede instanciarse directamente");
    }
    this.directReports = [];
  }

  stateName() {
    super.stateName(); // print name of this employee first
    if (this.directReports.length > 0) { // be sure there are elements
      for (const employee of this.directReports) {
        employee.stateName();
      }
    }
  }

  add(anEmployee) {
    this.directReports.push(anEmployee);
  }
}

module.exports = { Supervisor };

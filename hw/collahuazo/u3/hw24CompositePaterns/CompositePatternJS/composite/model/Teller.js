const { Employee } = require("./Employee.js");

/**
 * Hoja (Leaf) del patron Composite.
 * No tiene hijos, solo implementa el comportamiento base.
 */
class Teller extends Employee {
  constructor(aName) {
    super();
    this.title = "Teller";
    this.name = aName;
  }

  stateName() {
    super.stateName();
  }
}

module.exports = { Teller };

const { Employee } = require("./Employee.js");

/**
 * Hoja (Leaf) del patron Composite.
 * No tiene hijos, solo implementa el comportamiento base.
 */
class Clerk extends Employee {
  constructor(aName) {
    super();
    this.title = "Clerk";
    this.name = aName;
  }

  stateName() {
    super.stateName();
  }
}

module.exports = { Clerk };

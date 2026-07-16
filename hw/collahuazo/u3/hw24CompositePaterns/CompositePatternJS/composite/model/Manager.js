const { Supervisor } = require("./Supervisor.js");

/**
 * Compuesto concreto del patron Composite.
 */
class Manager extends Supervisor {
  constructor(aName) {
    super();
    this.title = "Manager";
    this.name = aName;
  }

  stateName() {
    // do processing special to manager naming
    super.stateName();
  }
}

module.exports = { Manager };

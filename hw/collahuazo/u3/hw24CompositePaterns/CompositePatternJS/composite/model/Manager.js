const { Supervisor } = require("./Supervisor.js");
class Manager extends Supervisor {
  constructor(aName) {
    super();
    this.title = "Manager";
    this.name = aName;
  }

  stateName() {
    super.stateName();
  }
}

module.exports = { Manager };

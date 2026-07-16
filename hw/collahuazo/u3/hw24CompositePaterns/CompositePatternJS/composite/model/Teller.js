const { Employee } = require("./Employee.js");

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

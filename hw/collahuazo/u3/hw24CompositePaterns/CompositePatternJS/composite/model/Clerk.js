const { Employee } = require("./Employee.js");
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

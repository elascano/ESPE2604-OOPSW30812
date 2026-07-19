const { Supervisor } = require("./Supervisor.js");
let allowConstruction = false;
class President extends Supervisor {
  static #president = null;

  constructor() {
    if (!allowConstruction) {
      throw new Error("Usa President.getPresident(name) en lugar de new President()");
    }
    super();
    this.title = "President";
  }

  stateName() {
    
    super.stateName();
  }

  static getPresident(aName) {
    if (President.#president === null) {
      allowConstruction = true;
      President.#president = new President();
      allowConstruction = false;
    }
    President.#president.name = aName;
    return President.#president;
  }
}

module.exports = { President };

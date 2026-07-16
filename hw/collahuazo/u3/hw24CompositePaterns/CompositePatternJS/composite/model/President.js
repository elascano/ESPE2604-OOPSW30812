const { Supervisor } = require("./Supervisor.js");

// Bandera para emular el constructor privado de Java:
// solo getPresident() puede crear la instancia.
let allowConstruction = false;

/**
 * Compuesto concreto del patron Composite.
 * Implementado ademas como Singleton: solo existe un President
 * en toda la aplicacion, igual que en la version Java original.
 */
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
    // Do processing special to presidential naming
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

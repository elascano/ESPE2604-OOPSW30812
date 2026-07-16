class Employee {
  constructor() {
    if (new.target === Employee) {
      throw new Error("Employee es abstracta y no puede instanciarse directamente");
    }
    this.name = "not assigned yet";
    this.title = "not assigned yet";
  }

  stateName() {
    console.log(`${this.title} ${this.name}`);
  }
}

module.exports = { Employee };

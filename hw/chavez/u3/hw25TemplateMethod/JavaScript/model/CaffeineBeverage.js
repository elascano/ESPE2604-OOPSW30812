// Abstract base class - Template Method Pattern
class CaffeineBeverage {
  // Template Method: fixed algorithm order (cannot be changed by subclasses)
  async prepareRecipe() {
    this.boilWater();
    await this.brew();
    this.pourInCup();
    if (await this.wantsCondiments()) {
      await this.addCondiments();
    }
  }

  boilWater() {
    console.log("Boiling water");
  }

  // Abstract methods - must be implemented by child classes
  async brew() {
    throw new Error("Subclasses must implement the brew() method");
  }

  pourInCup() {
    console.log("Pouring into cup");
  }

  async addCondiments() {
    throw new Error("Subclasses must implement the addCondiments() method");
  }

  // Hook method: default behavior, can be overridden
  async wantsCondiments() {
    return true;
  }
}

module.exports = CaffeineBeverage;
const CaffeineBeverage = require('./CaffeineBeverage');
const readline = require('readline');

class Coffee extends CaffeineBeverage {
  async brew() {
    console.log("Dripping coffee through filter");
  }

  async addCondiments() {
    console.log("Adding sugar and milk");
  }

  async wantsCondiments() {
    const answer = await this.getUserInput("Would you like milk and sugar with your coffee (y/n)? ");
    return answer.trim().toLowerCase().startsWith("y");
  }

  getUserInput(question) {
    const rl = readline.createInterface({
      input: process.stdin,
      output: process.stdout
    });
    return new Promise(resolve => {
      rl.question(question, (ans) => {
        rl.close();
        resolve(ans);
      });
    });
  }
}

module.exports = Coffee;
const CaffeineBeverage = require('./CaffeineBeverage');
const readline = require('readline');

class Tea extends CaffeineBeverage {
  async brew() {
    console.log("Steeping the tea");
  }

  async addCondiments() {
    console.log("Adding lemon");
  }

  async wantsCondiments() {
    const answer = await this.getUserInput("Would you like lemon with your tea (y/n)? ");
    return answer.trim().toLowerCase().startsWith("y");
  }

  // Helper to get console input
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

module.exports = Tea;
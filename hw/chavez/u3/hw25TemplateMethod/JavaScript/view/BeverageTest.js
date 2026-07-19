const Tea = require('../model/Tea');
const Coffee = require('../model/Coffee');
const readline = require('readline');

const rl = readline.createInterface({
  input: process.stdin,
  output: process.stdout
});

async function main() {
  let option = 0;
  const tea = new Tea();
  const coffee = new Coffee();

  while (option !== 3) {
    console.log("\n--- Beverage Menu ---");
    console.log("1. Make Tea");
    console.log("2. Make Coffee");
    console.log("3. Exit");

    const input = await new Promise(resolve => {
      rl.question("Choose an option: ", resolve);
    });

    option = parseInt(input.trim());
    console.log();

    switch (option) {
      case 1:
        console.log("Making tea ...");
        await tea.prepareRecipe();
        break;
      case 2:
        console.log("Making coffee ...");
        await coffee.prepareRecipe();
        break;
      case 3:
        console.log("Exiting the program...");
        break;
      default:
        console.log("Invalid option. Try again.");
    }
  }
  rl.close();
}

// Run the application
main().catch(err => console.error("Runtime Error:", err));
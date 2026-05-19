// ============================================================
// Package:     ec.edu.espe.productpomds.view
// Class:       ProductView
// Description: Console interface for product management
// ============================================================

const readline          = require("readline");
const ProductController = require("../ec.edu.espe.productpomds.controller/ProductController");

const ctrl = new ProductController();

// ── ANSI Colors ───────────────────────────────────────────────
const C = {
  reset  : "\x1b[0m",
  bold   : "\x1b[1m",
  cyan   : "\x1b[36m",
  green  : "\x1b[32m",
  yellow : "\x1b[33m",
  red    : "\x1b[31m",
  magenta: "\x1b[35m",
  gray   : "\x1b[90m",
};

const rl = readline.createInterface({
  input : process.stdin,
  output: process.stdout,
});

// ── Helpers ───────────────────────────────────────────────────

function ask(question) {
  return new Promise(resolve => rl.question(question, resolve));
}

function clear() {
  process.stdout.write("\x1bc");
}

function line(char = "─", length = 58) {
  console.log(C.gray + char.repeat(length) + C.reset);
}

function title(text) {
  line("═");
  console.log(`${C.bold}${C.cyan}  ${text}${C.reset}`);
  line("═");
}

function success(msg) { console.log(`\n${C.green}  ✔  ${msg}${C.reset}\n`); }
function fail(msg)    { console.log(`\n${C.red}  ✘  ${msg}${C.reset}\n`); }
function info(msg)    { console.log(`${C.yellow}  ℹ  ${msg}${C.reset}`); }

function printProduct(p) {
  line();
  console.log(`  ${C.bold}ID         :${C.reset} ${p.id}`);
  console.log(`  ${C.bold}Name       :${C.reset} ${p.name}`);
  console.log(`  ${C.bold}Description:${C.reset} ${p.description || "(none)"}`);
  console.log(`  ${C.bold}Price      :${C.reset} ${C.green}$${parseFloat(p.price).toFixed(2)}${C.reset}`);
  console.log(`  ${C.bold}Stock      :${C.reset} ${p.stock}`);
  console.log(`  ${C.bold}Category   :${C.reset} ${C.magenta}${p.category}${C.reset}`);
  console.log(`  ${C.bold}Created At :${C.reset} ${C.gray}${p.createdAt}${C.reset}`);
  line();
}

function printTable(products) {
  if (products.length === 0) {
    info("No products found.");
    return;
  }
  line();
  console.log(
    `${C.bold}${C.cyan}  ${"ID".padEnd(5)} ${"NAME".padEnd(22)} ${"PRICE".padEnd(10)} ${"STOCK".padEnd(7)} CATEGORY${C.reset}`
  );
  line();
  products.forEach(p => {
    console.log(
      `  ${String(p.id).padEnd(5)} ` +
      `${p.name.substring(0, 20).padEnd(22)} ` +
      `${C.green}$${parseFloat(p.price).toFixed(2).padEnd(9)}${C.reset}` +
      `${String(p.stock).padEnd(7)} ` +
      `${C.magenta}${p.category}${C.reset}`
    );
  });
  line();
  console.log(`  ${C.gray}Total: ${products.length} product(s)${C.reset}\n`);
}

// ── Menu Actions ──────────────────────────────────────────────

async function actionCreate() {
  title("CREATE PRODUCT");
  console.log(`${C.yellow}  Fill in each field and press ENTER after each one.${C.reset}\n`);

  console.log(`${C.cyan}  Field 1 of 5 → NAME${C.reset}`);
  const name        = await ask(`  Enter name        : `);

  console.log(`\n${C.cyan}  Field 2 of 5 → DESCRIPTION${C.reset}`);
  const description = await ask(`  Enter description : `);

  console.log(`\n${C.cyan}  Field 3 of 5 → CATEGORY${C.reset}`);
  const category    = await ask(`  Enter category    : `);

  console.log(`\n${C.cyan}  Field 4 of 5 → PRICE${C.reset}`);
  const price       = await ask(`  Enter price ($)   : `);

  console.log(`\n${C.cyan}  Field 5 of 5 → STOCK${C.reset}`);
  const stock       = await ask(`  Enter stock       : `);

  console.log("");
  const res = ctrl.createProduct(name, description, price, stock, category);
  res.ok ? success(res.message) : fail(res.message);
  if (res.ok) printProduct(res.product);
}

async function actionList() {
  title("PRODUCT LIST");
  const products = ctrl.listProducts();
  printTable(products);
}

async function actionFindById() {
  title("FIND PRODUCT BY ID");
  const id  = await ask("  Product ID: ");
  const res = ctrl.findById(id);
  if (res.ok) printProduct(res.product);
  else fail(res.message);
}

async function actionUpdate() {
  title("UPDATE PRODUCT");
  const id  = await ask("  Product ID to update: ");
  const res = ctrl.findById(id);
  if (!res.ok) { fail(res.message); return; }

  printProduct(res.product);
  console.log(`${C.yellow}  Leave blank any field you do not want to change.${C.reset}\n`);

  const data = {
    name        : await ask("  New name        : "),
    description : await ask("  New description : "),
    category    : await ask("  New category    : "),
    price       : await ask("  New price ($)   : "),
    stock       : await ask("  New stock       : "),
  };

  const upd = ctrl.updateProduct(id, data);
  upd.ok ? success(upd.message) : fail(upd.message);
  if (upd.ok) printProduct(upd.product);
}

async function actionDelete() {
  title("DELETE PRODUCT");
  const id  = await ask("  Product ID to delete: ");
  const res = ctrl.findById(id);
  if (!res.ok) { fail(res.message); return; }

  printProduct(res.product);
  const confirm = await ask(`  ${C.red}Confirm deletion? (y/n): ${C.reset}`);
  if (confirm.trim().toLowerCase() === "y") {
    const del = ctrl.deleteProduct(id);
    del.ok ? success(del.message) : fail(del.message);
  } else {
    info("Operation cancelled.");
  }
}

async function actionFindByCategory() {
  title("FIND BY CATEGORY");
  const cat      = await ask("  Category: ");
  const products = ctrl.findByCategory(cat);
  printTable(products);
}

// ── Main Menu ─────────────────────────────────────────────────

async function mainMenu() {
  clear();
  title("PRODUCT POMDS  ─  ec.edu.espe.productpomds");
  console.log(`  ${C.bold}1.${C.reset} Create product`);
  console.log(`  ${C.bold}2.${C.reset} List all products`);
  console.log(`  ${C.bold}3.${C.reset} Find product by ID`);
  console.log(`  ${C.bold}4.${C.reset} Update product`);
  console.log(`  ${C.bold}5.${C.reset} Delete product`);
  console.log(`  ${C.bold}6.${C.reset} Find by category`);
  console.log(`  ${C.bold}0.${C.reset} ${C.red}Exit${C.reset}`);
  line();

  const option = await ask(`  ${C.bold}Select an option: ${C.reset}`);

  switch (option.trim()) {
    case "1": await actionCreate();          break;
    case "2": await actionList();            break;
    case "3": await actionFindById();        break;
    case "4": await actionUpdate();          break;
    case "5": await actionDelete();          break;
    case "6": await actionFindByCategory();  break;
    case "0":
      console.log(`\n${C.cyan}  Goodbye! — Product POMDS${C.reset}\n`);
      rl.close();
      process.exit(0);
    default:
      fail("Invalid option. Please try again.");
  }

  await ask(`  ${C.gray}Press ENTER to continue...${C.reset}`);
  await mainMenu();
}

module.exports = { mainMenu };

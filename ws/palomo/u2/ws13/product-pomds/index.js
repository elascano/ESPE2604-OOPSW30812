// ============================================================
// Product POMDS — Main entry point
// Packages:
//   ec.edu.espe.productpomds.model
//   ec.edu.espe.productpomds.controller
//   ec.edu.espe.productpomds.view
// ============================================================

const { mainMenu } = require("./ec.edu.espe.productpomds.view/ProductView");

mainMenu().catch(err => {
  console.error("Unexpected error:", err);
  process.exit(1);
});

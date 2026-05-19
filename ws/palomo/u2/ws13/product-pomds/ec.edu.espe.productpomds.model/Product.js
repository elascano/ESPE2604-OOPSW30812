// ============================================================
// Package:     ec.edu.espe.productpomds.model
// Class:       Product
// Description: Data model for a Product
// ============================================================

class Product {
  constructor(id, name, description, price, stock, category) {
    this.id          = id;
    this.name        = name;
    this.description = description;
    this.price       = parseFloat(price);
    this.stock       = parseInt(stock);
    this.category    = category;
    this.createdAt   = new Date().toISOString();
  }

  toString() {
    return `[${this.id}] ${this.name} | $${this.price.toFixed(2)} | Stock: ${this.stock} | Category: ${this.category}`;
  }
}

module.exports = Product;

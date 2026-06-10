export class Product {
  constructor(id, name, unitPrice, stock) {
    this.id = Number(id);
    this.name = String(name);
    this.unitPrice = Number(unitPrice);
    this.stock = Number(stock);
  }

  toDocument() {
    return {
      id: this.id,
      name: this.name,
      unitPrice: this.unitPrice,
      stock: this.stock,
    };
  }
}

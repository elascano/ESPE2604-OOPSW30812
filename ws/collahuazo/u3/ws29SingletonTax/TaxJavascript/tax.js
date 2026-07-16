class Tax {
  static instance = null;
  constructor() {
    if (Tax.instance) return Tax.instance;
    this.percentage = 0;
    Tax.instance = this;
  }
  static getInstance() {
    return Tax.instance ?? new Tax();
  }
  updateTaxPercentage(p) {
    this.percentage = p;
  }
  salesTotal(price) {
    return price + price * this.percentage;
  }
}
module.exports = Tax;

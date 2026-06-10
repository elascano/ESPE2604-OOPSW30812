export class Customer {
  constructor(ruc, name, address, gmailCustomer) {
    this.ruc = Number(ruc);
    this.name = String(name);
    this.address = String(address);
    this.gmailCustomer = String(gmailCustomer);
  }

  toDocument() {
    return {
      ruc: this.ruc,
      name: this.name,
      address: this.address,
      gmailCustomer: this.gmailCustomer,
    };
  }
}

export class Supplier {
  constructor(ruc, companyName, address, phone, email) {
    this.ruc = Number(ruc);
    this.companyName = String(companyName);
    this.address = String(address);
    this.phone = String(phone);
    this.email = String(email);
  }

  toDocument() {
    return {
      ruc: this.ruc,
      companyName: this.companyName,
      address: this.address,
      phone: this.phone,
      email: this.email,
    };
  }
}

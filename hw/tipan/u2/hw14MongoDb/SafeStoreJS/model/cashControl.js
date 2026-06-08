class CashControl {
    constructor(cashier, opening, closing) {
        this.cashier = cashier;
        this.opening = opening;
        this.closing = closing;
        this.difference = closing - opening;
    }
}

module.exports = CashControl;
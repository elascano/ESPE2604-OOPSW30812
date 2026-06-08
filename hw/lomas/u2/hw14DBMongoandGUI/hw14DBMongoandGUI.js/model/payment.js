class Payment {
    constructor(paymentId, paymentMethod, amount) {
        this.paymentId = paymentId;
        this.paymentMethod = paymentMethod;
        this.amount = amount;
    }

    toDict() {
        return {
            _id: this.paymentId,
            paymentMethod: this.paymentMethod,
            amount: this.amount
        };
    }
}

module.exports = Payment;
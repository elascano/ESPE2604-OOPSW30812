export class Bank {
    constructor(id, name, totalDeposits, totalLoans) {
        this.id = id;
        this.name = name;
        this.totalDeposits = parseFloat(totalDeposits);
        this.totalLoans = parseFloat(totalLoans);
    }

    computeNetWorth() {
        return this.totalDeposits - this.totalLoans;
    }
}
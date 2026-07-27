class Loan {
    static MAX_LOAN_DAYS = 7;
    static FINE_PER_DAY = 0.50;
    
    constructor(id = null, userId = null, bookId = null, loanDate = null) {
        this._id = id;
        this._userId = userId;
        this._bookId = bookId;
        this._loanDate = loanDate || new Date();
        this._returnDate = null;
        this._status = "ACTIVE";
        this._fine = 0.0;
    }
    
    get id() {
        return this._id;
    }
    
    set id(value) {
        this._id = value;
    }
    
    get userId() {
        return this._userId;
    }
    
    set userId(value) {
        this._userId = value;
    }
    
    get bookId() {
        return this._bookId;
    }
    
    set bookId(value) {
        this._bookId = value;
    }
    
    get loanDate() {
        return this._loanDate;
    }
    
    set loanDate(value) {
        this._loanDate = value;
    }
    
    get returnDate() {
        return this._returnDate;
    }
    
    set returnDate(value) {
        this._returnDate = value;
        this._calculateFine();
    }
    
    get status() {
        return this._status;
    }
    
    set status(value) {
        this._status = value;
    }
    
    get fine() {
        return this._fine;
    }
    
    set fine(value) {
        this._fine = value;
    }
    
    _calculateFine() {
        if (this._returnDate && this._loanDate) {
            const diff = this._returnDate - this._loanDate;
            const days = Math.floor(diff / (1000 * 60 * 60 * 24));
            
            if (days > Loan.MAX_LOAN_DAYS) {
                this._fine = (days - Loan.MAX_LOAN_DAYS) * Loan.FINE_PER_DAY;
            } else {
                this._fine = 0.0;
            }
        }
    }
    
    isOverdue() {
        if (!this._returnDate) {
            const now = new Date();
            const diff = now - this._loanDate;
            const days = Math.floor(diff / (1000 * 60 * 60 * 24));
            return days > Loan.MAX_LOAN_DAYS;
        }
        return false;
    }
    
    toString() {
        return `Loan: ${this._id} - Status: ${this._status}`;
    }
}

module.exports = Loan;
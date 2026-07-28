const Person = require('./person');

class User extends Person {
    constructor(id = null, firstName = null, lastName = null, email = null, userType = null) {
        super(id, firstName, lastName, email);
        this._userType = userType;
        this._activeLoans = 0;
        this._loanHistory = [];
    }
    
    get userType() {
        return this._userType;
    }
    
    set userType(value) {
        this._userType = value;
    }
    
    get activeLoans() {
        return this._activeLoans;
    }
    
    set activeLoans(value) {
        this._activeLoans = value;
    }
    
    get loanHistory() {
        return this._loanHistory;
    }
    
    set loanHistory(value) {
        this._loanHistory = value;
    }
    
    getPersonType() {
        return "User";
    }
    
    addLoan(bookId) {
        this._loanHistory.push(bookId);
        this._activeLoans++;
    }
    
    returnLoan(bookId) {
        const index = this._loanHistory.indexOf(bookId);
        if (index !== -1) {
            this._loanHistory.splice(index, 1);
            this._activeLoans--;
        }
    }
    
    canBorrow() {
        return this._activeLoans < 5;
    }
    
    toString() {
        return `User: ${super.toString()}, Type: ${this._userType}`;
    }
}

module.exports = User;
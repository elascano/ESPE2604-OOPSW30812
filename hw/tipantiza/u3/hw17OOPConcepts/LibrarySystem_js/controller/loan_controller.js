const Loan = require('../model/loan');
const IManageable = require('../model/interfaces/manageable');
const MongoDBConnection = require('../utils/mongodb_connection');

class LoanController extends IManageable {
    constructor() {
        super();
        this._loans = [];
        this._db = MongoDBConnection.getInstance();
        this._loadLoans();
    }
    
    async add(loan) {
        this._loans.push(loan);
        await this._db.insertDocument(MongoDBConnection.LOANS_COLLECTION, loan);
    }
    
    async remove(id) {
        this._loans = this._loans.filter(loan => loan.id !== id);
        await this._db.deleteDocument(MongoDBConnection.LOANS_COLLECTION, id);
    }
    
    find(id) {
        return this._loans.find(loan => loan.id === id) || null;
    }
    
    findAll() {
        return [...this._loans];
    }
    
    async update(loan) {
        const index = this._loans.findIndex(l => l.id === loan.id);
        if (index !== -1) {
            this._loans[index] = loan;
            await this._db.updateDocument(MongoDBConnection.LOANS_COLLECTION, loan.id, loan);
        }
    }
    
    findActiveLoans() {
        return this._loans.filter(loan => loan.status === "ACTIVE");
    }
    
    findLoansByUser(userId) {
        return this._loans.filter(loan => loan.userId === userId);
    }
    
    findOverdueLoans() {
        return this._loans.filter(loan => loan.isOverdue());
    }
    
    async _loadLoans() {
        const loansFromDB = await this._db.findAllDocuments(
            MongoDBConnection.LOANS_COLLECTION,
            Loan
        );
        if (loansFromDB.length > 0) {
            this._loans = loansFromDB;
            console.log(`Loaded ${this._loans.length} loans from database`);
        }
    }
}

module.exports = LoanController;
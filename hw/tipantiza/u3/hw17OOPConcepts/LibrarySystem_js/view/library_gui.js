const readline = require('readline');
const { randomUUID } = require('crypto');

const LibraryController = require('../controller/library_controller');
const Book = require('../model/book');
const User = require('../model/user');

class LibraryGUI {
    constructor() {
        this.controller = new LibraryController();
        this.rl = readline.createInterface({
            input: process.stdin,
            output: process.stdout
        });
    }
    
    async run() {
        console.log("\n=== Library Management System - ESPE ===\n");
        await this._showMainMenu();
    }
    
    async _showMainMenu() {
        console.log("\n1. Books");
        console.log("2. Users");
        console.log("3. Loans");
        console.log("4. Statistics");
        console.log("5. Exit");
        
        const option = await this._ask("Select an option: ");
        
        switch(option) {
            case "1":
                await this._showBooksMenu();
                break;
            case "2":
                await this._showUsersMenu();
                break;
            case "3":
                await this._showLoansMenu();
                break;
            case "4":
                await this._showStatistics();
                break;
            case "5":
                this._exitApp();
                break;
            default:
                console.log("Invalid option");
                await this._showMainMenu();
        }
    }
    
    async _showBooksMenu() {
        console.log("\n--- Books Menu ---");
        console.log("1. List Books");
        console.log("2. Add Book");
        console.log("3. Delete Book");
        console.log("4. Back to Main Menu");
        
        const option = await this._ask("Select an option: ");
        
        switch(option) {
            case "1":
                await this._listBooks();
                break;
            case "2":
                await this._addBook();
                break;
            case "3":
                await this._deleteBook();
                break;
            case "4":
                await this._showMainMenu();
                return;
            default:
                console.log("Invalid option");
        }
        await this._showBooksMenu();
    }
    
    async _showUsersMenu() {
        console.log("\n--- Users Menu ---");
        console.log("1. List Users");
        console.log("2. Add User");
        console.log("3. Delete User");
        console.log("4. Back to Main Menu");
        
        const option = await this._ask("Select an option: ");
        
        switch(option) {
            case "1":
                await this._listUsers();
                break;
            case "2":
                await this._addUser();
                break;
            case "3":
                await this._deleteUser();
                break;
            case "4":
                await this._showMainMenu();
                return;
            default:
                console.log("Invalid option");
        }
        await this._showUsersMenu();
    }
    
    async _showLoansMenu() {
        console.log("\n--- Loans Menu ---");
        console.log("1. List Loans");
        console.log("2. Create Loan");
        console.log("3. Return Book");
        console.log("4. Back to Main Menu");
        
        const option = await this._ask("Select an option: ");
        
        switch(option) {
            case "1":
                await this._listLoans();
                break;
            case "2":
                await this._createLoan();
                break;
            case "3":
                await this._returnLoan();
                break;
            case "4":
                await this._showMainMenu();
                return;
            default:
                console.log("Invalid option");
        }
        await this._showLoansMenu();
    }
    
    async _listBooks() {
        console.log("\n=== Books ===");
        const books = this.controller.findAll();
        if (books.length === 0) {
            console.log("No books found");
            return;
        }
        
        console.log("\nID".padEnd(38) + "Title".padEnd(30) + "Author".padEnd(25) + "Available");
        console.log("-".repeat(100));
        for (const book of books) {
            const idDisplay = book.id.substring(0, 8) + "...";
            console.log(
                idDisplay.padEnd(40) +
                book.title.substring(0, 28).padEnd(30) +
                book.author.substring(0, 23).padEnd(25) +
                (book.available ? "Yes" : "No")
            );
        }
        console.log(`\nTotal: ${books.length} books`);
        await this._ask("\nPress Enter to continue...");
    }
    
    async _addBook() {
        console.log("\n--- Add Book ---");
        const title = await this._ask("Title: ");
        const author = await this._ask("Author: ");
        const isbn = await this._ask("ISBN: ");
        const year = await this._ask("Publication Year: ");
        const category = await this._ask("Category: ");
        
        try {
            const book = new Book(
                randomUUID(),
                title,
                author,
                isbn,
                parseInt(year),
                category
            );
            this.controller.add(book);
            console.log("Book added successfully");
        } catch (error) {
            console.log(`Error: ${error.message}`);
        }
        await this._ask("\nPress Enter to continue...");
    }
    
    async _deleteBook() {
        await this._listBooks();
        const id = await this._ask("\nEnter Book ID to delete: ");
        
        try {
            this.controller.remove(id);
            console.log("Book deleted successfully");
        } catch (error) {
            console.log(`Error: ${error.message}`);
        }
        await this._ask("\nPress Enter to continue...");
    }
    
    async _listUsers() {
        console.log("\n=== Users ===");
        const users = this.controller.findAllUsers();
        if (users.length === 0) {
            console.log("No users found");
            return;
        }
        
        console.log("\nID".padEnd(38) + "Name".padEnd(25) + "Email".padEnd(30) + "Type".padEnd(15) + "Active Loans");
        console.log("-".repeat(110));
        for (const user of users) {
            const idDisplay = user.id.substring(0, 8) + "...";
            console.log(
                idDisplay.padEnd(40) +
                user.getFullName().padEnd(25) +
                user.email.padEnd(30) +
                user.userType.padEnd(15) +
                user.activeLoans
            );
        }
        console.log(`\nTotal: ${users.length} users`);
        await this._ask("\nPress Enter to continue...");
    }
    
    async _addUser() {
        console.log("\n--- Add User ---");
        const firstName = await this._ask("First Name: ");
        const lastName = await this._ask("Last Name: ");
        const email = await this._ask("Email: ");
        const userType = await this._ask("Type (STUDENT/PROFESSOR/RESEARCHER): ");
        
        try {
            const user = new User(
                randomUUID(),
                firstName,
                lastName,
                email,
                userType.toUpperCase()
            );
            this.controller.addUser(user);
            console.log("User added successfully");
        } catch (error) {
            console.log(`Error: ${error.message}`);
        }
        await this._ask("\nPress Enter to continue...");
    }
    
    async _deleteUser() {
        await this._listUsers();
        const id = await this._ask("\nEnter User ID to delete: ");
        
        try {
            this.controller.removeUser(id);
            console.log("User deleted successfully");
        } catch (error) {
            console.log(`Error: ${error.message}`);
        }
        await this._ask("\nPress Enter to continue...");
    }
    
    async _listLoans() {
        console.log("\n=== Loans ===");
        const loans = this.controller.findAllLoans();
        if (loans.length === 0) {
            console.log("No loans found");
            return;
        }
        
        console.log("\nID".padEnd(38) + "User ID".padEnd(38) + "Book ID".padEnd(38) + "Status".padEnd(15) + "Fine");
        console.log("-".repeat(130));
        for (const loan of loans) {
            const idDisplay = loan.id.substring(0, 8) + "...";
            const userIdDisplay = loan.userId.substring(0, 8) + "...";
            const bookIdDisplay = loan.bookId.substring(0, 8) + "...";
            console.log(
                idDisplay.padEnd(40) +
                userIdDisplay.padEnd(40) +
                bookIdDisplay.padEnd(40) +
                loan.status.padEnd(15) +
                `$${loan.fine.toFixed(2)}`
            );
        }
        console.log(`\nTotal: ${loans.length} loans`);
        await this._ask("\nPress Enter to continue...");
    }
    
    async _createLoan() {
        console.log("\n--- Create Loan ---");
        const userId = await this._ask("User ID: ");
        const bookId = await this._ask("Book ID: ");
        
        try {
            this.controller.createLoan(userId, bookId);
            console.log("Loan created successfully");
        } catch (error) {
            console.log(`Error: ${error.message}`);
        }
        await this._ask("\nPress Enter to continue...");
    }
    
    async _returnLoan() {
        const loanId = await this._ask("Enter Loan ID to return: ");
        
        try {
            this.controller.returnLoan(loanId);
            console.log("Book returned successfully");
        } catch (error) {
            console.log(`Error: ${error.message}`);
        }
        await this._ask("\nPress Enter to continue...");
    }
    
    async _showStatistics() {
        console.log("\n=== Statistics ===");
        console.log(`Total Books: ${this.controller.getTotalBooks()}`);
        console.log(`Available Books: ${this.controller.getAvailableBooksCount()}`);
        console.log(`Total Users: ${this.controller.getTotalUsers()}`);
        console.log(`Active Loans: ${this.controller.getActiveLoansCount()}`);
        
        await this._ask("\nPress Enter to continue...");
        await this._showMainMenu();
    }
    
    _ask(question) {
        return new Promise((resolve) => {
            this.rl.question(question, (answer) => {
                resolve(answer);
            });
        });
    }
    
    _exitApp() {
        console.log("Goodbye!");
        this.rl.close();
        process.exit(0);
    }
}

module.exports = LibraryGUI;
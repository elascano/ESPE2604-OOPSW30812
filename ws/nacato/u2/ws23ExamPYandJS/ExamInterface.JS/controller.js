import { Bank } from './model.js';

export class BankController {
    constructor() {
        this.banks = [];

        this.entId = document.getElementById('ent_id');
        this.entName = document.getElementById('ent_name');
        this.entDeposits = document.getElementById('ent_deposits');
        this.entLoans = document.getElementById('ent_loans');
        
        this.btnCreate = document.getElementById('btn_create');
        this.btnUpdate = document.getElementById('btn_update');
        this.btnDelete = document.getElementById('btn_delete');
        this.btnClear = document.getElementById('btn_clear');
        this.tableBody = document.getElementById('table_body');

        this.btnCreate.onclick = () => this.createBank();
        this.btnUpdate.onclick = () => this.updateBank();
        this.btnDelete.onclick = () => this.deleteBank();
        this.btnClear.onclick = () => this.clearInputs();
        
        this.updateTable();
    }

    getBankData() {
        const id = this.entId.value.trim();
        const name = this.entName.value.trim();
        const depositsRaw = this.entDeposits.value;
        const loansRaw = this.entLoans.value;

        if (!id || !name || depositsRaw === "" || loansRaw === "") {
            throw new Error("All fields are required.");
        }

        const total_deposits = parseFloat(depositsRaw);
        const total_loans = parseFloat(loansRaw);

        if (isNaN(total_deposits) || isNaN(total_loans)) {
            throw new Error("Deposits and Loans must be valid numbers.");
        }

        return { id, name, total_deposits, total_loans };
    }

    createBank() {
        try {
            const data = this.getBankData();

            if (this.banks.some(b => b.id === data.id)) {
                alert("Error: A bank with this ID already exists.");
                return;
            }

            const newBank = new Bank(data.id, data.name, data.total_deposits, data.total_loans);
            this.banks.push(newBank);

            alert(`Bank '${newBank.name}' added successfully.`);
            this.clearInputs();
            this.updateTable(); 
        } catch (error) {
            alert(error.message);
        }
    }

    updateBank() {
        try {
            const data = this.getBankData();
            const index = this.banks.findIndex(b => b.id === data.id);

            if (index !== -1) {
                this.banks[index].name = data.name;
                this.banks[index].total_deposits = data.total_deposits;
                this.banks[index].total_loans = data.total_loans;

                alert("Bank updated successfully.");
                this.clearInputs();
                this.updateTable(); 
            } else {
                alert("Error: Bank ID not found. You cannot change the ID.");
            }
        } catch (error) {
            alert(error.message);
        }
    }

    deleteBank() {
        const idToDelete = this.entId.value.trim();

        if (!idToDelete) {
            alert("Please enter or select a Bank ID to delete.");
            return;
        }

        const index = this.banks.findIndex(b => b.id === idToDelete);

        if (index !== -1) {
            this.banks.splice(index, 1);
            alert("Bank deleted successfully.");
            this.clearInputs();
            this.updateTable(); 
        } else {
            alert("Error: Bank ID not found.");
        }
    }

    clearInputs() {
        this.entId.value = "";
        this.entName.value = "";
        this.entDeposits.value = "";
        this.entLoans.value = "";
    }

    updateTable() {
        this.tableBody.innerHTML = "";

        if (this.banks.length === 0) {
            this.tableBody.innerHTML = `<tr><td colspan="5" style="text-align:center; color:gray;">No registered banks.</td></tr>`;
            return;
        }

        this.banks.forEach(bank => {
            const row = document.createElement('tr');
            
            row.innerHTML = `
                <td>${bank.id}</td>
                <td>${bank.name}</td>
                <td>$${bank.total_deposits.toFixed(2)}</td>
                <td>$${bank.total_loans.toFixed(2)}</td>
                <td>$${bank.computeNetWorth().toFixed(2)}</td>
            `;

            row.onclick = () => {
                this.entId.value = bank.id;
                this.entName.value = bank.name;
                this.entDeposits.value = bank.total_deposits;
                this.entLoans.value = bank.total_loans;
            };

            this.tableBody.appendChild(row);
        });
    }
}
const fs = require('fs');

class CashRegister {
    constructor(startingBalance, totalSales, securityWithdrawals) {
        this.startingBalance = startingBalance;
        this.totalSales = totalSales;
        this.securityWithdrawals = securityWithdrawals;
        this.expectedBalance = startingBalance + totalSales - securityWithdrawals;
        this.physicalCount = 0;
        this.discrepancy = 0;
    }

    getStartingBalance() { return this.startingBalance; }
    getTotalSales() { return this.totalSales; }
    getSecurityWithdrawals() { return this.securityWithdrawals; }
    getExpectedBalance() { return this.expectedBalance; }
    getPhysicalCount() { return this.physicalCount; }
    getDiscrepancy() { return this.discrepancy; }

    setStartingBalance(startingBalance) {
        this.startingBalance = startingBalance;
        this.expectedBalance = this.startingBalance + this.totalSales - this.securityWithdrawals;
    }

    setTotalSales(totalSales) {
        this.totalSales = totalSales;
        this.expectedBalance = this.startingBalance + this.totalSales - this.securityWithdrawals;
    }

    setSecurityWithdrawals(securityWithdrawals) {
        this.securityWithdrawals = securityWithdrawals;
        this.expectedBalance = this.startingBalance + this.totalSales - this.securityWithdrawals;
    }

    setPhysicalCount(physicalCount) {
        this.physicalCount = physicalCount;
        this.discrepancy = this.physicalCount - this.expectedBalance;
    }

    isBalanced() {
        return this.discrepancy === 0;
    }

    getSurplus() {
        return this.discrepancy > 0 ? this.discrepancy : 0;
    }

    getShortage() {
        return this.discrepancy < 0 ? Math.abs(this.discrepancy) : 0;
    }

    showReport() {
        console.log("\nCAJA REGISTRADORA\n");
        console.log(`Balance inicial: $${this.startingBalance.toFixed(2)}`);
        console.log(`Total ventas: $${this.totalSales.toFixed(2)}`);
        console.log(`Retiros de seguridad: $${this.securityWithdrawals.toFixed(2)}`);
        console.log(`Balance esperado: $${this.expectedBalance.toFixed(2)}`);
        console.log(`Conteo fisico: $${this.physicalCount.toFixed(2)}`);
        console.log("\n VERIFICACION");
        if (this.isBalanced()) {
            console.log("CAJA CUADRADA - No hay discrepancias");
        } else if (this.discrepancy > 0) {
            console.log(`Sobra $${this.getSurplus().toFixed(2)}`);
            console.log("Revisar si hubo errores en vueltos o ventas");
        } else {
            console.log(`Falta $${this.getShortage().toFixed(2)}`);
            console.log("Revisar posibles robos o errores en ventas");
        }
    }

    exportToJSON(filePath) {
        const dir = require('path').dirname(filePath);
        if (!fs.existsSync(dir)) {
            fs.mkdirSync(dir, { recursive: true });
        }
        const data = {
            startingBalance: this.startingBalance,
            totalSales: this.totalSales,
            securityWithdrawals: this.securityWithdrawals,
            expectedBalance: this.expectedBalance,
            physicalCount: this.physicalCount,
            discrepancy: this.discrepancy
        };
        fs.writeFileSync(filePath, JSON.stringify(data, null, 4), 'utf8');
        console.log(`Archivo JSON de caja generado: ${filePath}`);
    }
}

module.exports = CashRegister;
export class Stock {
    constructor() {
        if (this.constructor === Stock) {
            throw new Error("No se puede instanciar una clase abstracta directamente.");
        }
        this.symbol = "";
        this.price = 0.0;
        this.investors = []; // Array equivalente al ArrayList de Java
    }

    addObserver(iinvestor) {
        if (!this.investors.includes(iinvestor)) {
            this.investors.push(iinvestor);
        }
    }

    deleteObserver(iinvestor) {
        this.investors = this.investors.filter(investor => investor !== iinvestor);
    }

    notifyObservers(args) {
        // Recorremos todos los observadores registrados
        this.investors.forEach(investor => {
            investor.update(this, args);
        });
    }

    // Métodos abstractos conceptuales
    getSymbol() { throw new Error("Debe implementar getSymbol()"); }
    getPrice() { throw new Error("Debe implementar getPrice()"); }
}
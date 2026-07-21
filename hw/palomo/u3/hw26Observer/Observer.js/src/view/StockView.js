/**
 * @author Cristian Palomo, Error 404, @ESPE
 * (traducido de Java a JavaScript)
 */
export class StockView {
    static printNotification(investorName, stock, args) {
        console.log(`Notified observer ${investorName}`);
        if (typeof args === "string") {
            console.log(`The symbol of ${stock.getSymbol()} changed to: ${args}`);
        } else if (typeof args === "number") {
            console.log(`The price of ${stock.getSymbol()} changed to: ${args}`);
        }
    }
}

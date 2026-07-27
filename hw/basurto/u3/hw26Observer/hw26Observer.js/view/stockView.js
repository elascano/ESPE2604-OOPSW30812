export class StockView {
    static printNotification(investorName, stock, args) {
        console.log(`Notified observer ${investorName}`);
        if (typeof args === 'string') {
            console.log(`The symbol of ${stock.symbol} changed to: ${args}`);
        } else if (typeof args === 'number') {
            console.log(`The price of ${stock.symbol} changed to: ${args.toFixed(2)}`);
        }
    }
}
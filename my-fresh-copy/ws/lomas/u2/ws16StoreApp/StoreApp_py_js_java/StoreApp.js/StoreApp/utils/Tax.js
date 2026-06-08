export class Tax {
    static computeTotal(price, taxPercentage) {
        return price + (price * (taxPercentage / 100));
    }
}



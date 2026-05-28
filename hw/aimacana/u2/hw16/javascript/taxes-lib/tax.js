export class Tax {
    static computeIva(amount, taxPercentage) {
        return amount * (taxPercentage / 100.0);
    }

    static computeTotal(amount, taxPercentage) {
        return amount + Tax.computeIva(amount, taxPercentage);
    }
}

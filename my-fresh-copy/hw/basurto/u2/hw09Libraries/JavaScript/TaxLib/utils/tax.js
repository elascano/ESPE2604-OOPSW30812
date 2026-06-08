function computeIva(amount, taxPercentage) {
    return amount * taxPercentage / 100;
}

function computeTotal(amount, taxPercentage) {
    return amount + computeIva(amount, taxPercentage);
}

module.exports = {
    computeIva,
    computeTotal
};
class CustomerAnalytics {

    constructor(id, customerName, purchaseCategory) {
        this.id = id;
        this.customerName = customerName;
        this.purchaseCategory = purchaseCategory;
    }

    toString() {
        return `CustomerAnalytics{
            id=${this.id},
            customerName=${this.customerName},
            purchaseCategory=${this.purchaseCategory}
        }`;
    }
}

export default CustomerAnalytics;
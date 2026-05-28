class SupplierManager {

    constructor(id, supplierName, contactEmail) {
        this.id = id;
        this.supplierName = supplierName;
        this.contactEmail = contactEmail;
    }

    toString() {
        return `SupplierManager{
            id=${this.id},
            supplierName=${this.supplierName},
            contactEmail=${this.contactEmail}
        }`;
    }
}

export default SupplierManager;

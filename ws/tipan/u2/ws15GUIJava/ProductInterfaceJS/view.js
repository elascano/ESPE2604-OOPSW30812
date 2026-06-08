class ProductView {

    constructor() {

        this.productInput =
            document.getElementById("product");

        this.priceInput =
            document.getElementById("price");

        this.quantityInput =
            document.getElementById("quantity");

        this.totalLabel =
            document.getElementById("total");

        this.addButton =
            document.getElementById("btnAdd");
    }
}

export default ProductView;
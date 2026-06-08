import Product from "./model.js";
import ProductView from "./view.js";

class ProductController {

    constructor() {

        this.view = new ProductView();

        this.view.addButton.addEventListener(
            "click",
            () => this.calculate()
        );
    }

    calculate() {

        const name =
            this.view.productInput.value;

        const price =
            parseFloat(
                this.view.priceInput.value
            );

        const quantity =
            parseInt(
                this.view.quantityInput.value
            );

        const product =
            new Product(
                name,
                price,
                quantity
            );

        const total =
            product.calculateTotal();

        document.getElementById("total").innerHTML =
            "Total: $" + total;
    }
}

new ProductController();
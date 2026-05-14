class Product {

    constructor(id, name, stock, price) {
        this.id = id;
        this.name = name;
        this.stock = stock;
        this.price = price;
    }

    toString() {
        return `Product{
            id=${this.id},
            name=${this.name},
            stock=${this.stock},
            price=${this.price}
        }`;
    }
}

export default Product;

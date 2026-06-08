import { ProductCategory } from './productCategory.js';

export class Product {
    public productId: string;
    public name: string;
    public price: number;
    public category: ProductCategory;

    constructor(
        productId = '',
        name = '',
        price = 0,
        category: ProductCategory = ProductCategory.HOT_BEVERAGE
    ) {
        this.productId = productId;
        this.name = name;
        this.price = price;
        this.category = category;
    }

    public static fromDocument(doc: any): Product | null {
        if (!doc) return null;
        return new Product(
            doc.productId,
            doc.name,
            doc.price,
            doc.category as ProductCategory
        );
    }
}

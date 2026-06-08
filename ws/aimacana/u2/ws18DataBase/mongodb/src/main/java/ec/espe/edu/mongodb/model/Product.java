package ec.espe.edu.mongodb.model;

import java.math.BigDecimal;

/**
 * Product representation for MongoDB tests.
 * 
 * @author Anthony Aimacaña, MKA programmer, @ESPE
 */
public class Product {
    private String productId;
    private String name;
    private BigDecimal price;
    private ProductCategory category;

    public Product() {
        this.price = BigDecimal.ZERO;
    }

    public Product(String productId, String name, BigDecimal price, ProductCategory category) {
        this.productId = productId;
        this.name = name;
        this.price = price;
        this.category = category;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public ProductCategory getCategory() {
        return category;
    }

    public void setCategory(ProductCategory category) {
        this.category = category;
    }

    @Override
    public String toString() {
        return "Product{" +
                "productId='" + productId + '\'' +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", category=" + category +
                '}';
    }
}

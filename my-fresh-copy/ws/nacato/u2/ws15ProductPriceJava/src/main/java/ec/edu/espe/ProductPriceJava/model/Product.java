package ec.edu.espe.ProductPriceJava.model;

/**
 *
 * @author Angie Nacato, Error 404, @ESPE
 */
public class Product {
    private int id;
    private String product;
    private double price;
    private double vat;
    private double total;

    public Product() {}
    public Product(int id, String product, double price) {
        this.id = id;
        this.product = product;
        this.price = price;
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    public String getProduct() { return product; }
    public void setProduct(String product) { this.product = product; }
    public double getPrice() { return price; }
    public void setPrice(double price) { this.price = price; }
    public double getVat() { return vat; }
    public void setVat(double vat) { this.vat = vat; }
    public double getTotal() { return total; }
    public void setTotal(double total) { this.total = total; }
}
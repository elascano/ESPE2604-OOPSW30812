
package ec.edu.espe.virtualstoreapp.data;
import ec.edu.espe.virtualstoreapp.model.Product;
import java.util.ArrayList;
/**
 *
 * @author Alexander Tipantiza, The Softwarrios, @ESPE
 */
public class ProductData {
    public static ArrayList<Product> products = new ArrayList<>();

    static {
        products.add(new Product(1, "HP Laptop", "Technology", 850, 5));
        products.add(new Product(2, "Gaming Mouse", "Technology", 25, 10));
        products.add(new Product(3, "RGB Keyboard", "Technology", 45, 8));
        products.add(new Product(4, "Nike T-Shirt", "Clothing", 30, 15));
        products.add(new Product(5, "Jeans Pants", "Clothing", 40, 12));
        products.add(new Product(6, "Adidas Shoes", "Footwear", 70, 6));
        products.add(new Product(7, "Headphones", "Technology", 60, 9));
        products.add(new Product(8, "Backpack", "Accessories", 35, 7));
        products.add(new Product(9, "Watch", "Accessories", 120, 4));
        products.add(new Product(10, "Samsung Tablet", "Technology", 300, 3));
    }

    public static ArrayList<Product> getProducts() {
        return products;
    }
    
}


package ec.edu.espe.storeapp.view;

import ec.edu.espe.storeapp.model.Product;
import utils.Tax;

/**
 *
 * @author Alexander Tipantiza < The_Softwarrios of Espeyour>
 */
public class Store {
    public static void main(String[] args) {
    int id;
    String description;
    float price;
    float pvp;
    
    Product product;
    
    id = 1;
    description = "computer";
    price = 100;
    
    pvp = Tax.computeTotal(price, 15F);
    product = new Product(id, description, price);
        System.out.println("product--->" + product);
        
    Product product2;
    id = 2;
    description = "mouse";
    price = 1000;
    
    
    pvp = Tax.computeTotal(price, 15F);
    product2 = new Product(id, description, price);
        System.out.println("product--->" + product2);
            
    
    
    
    
    }

}

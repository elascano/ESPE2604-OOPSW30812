
package ec.edu.espe.store.view;

import ec.edu.espe.store.model.Product;
import utils.Tax;

/**
 *
 * @author Esteban Basurto , CodeBreakers, @ESPE
 */
public class Store {
    public static void main(String[] args) {
        int id;
        String description;
        float price;
        float pvp;
        Product product;
        
        id=1;
        description="Computer";
        price=100;
        
        pvp= Tax.computeTotal(price,15F);
        
        product= new Product(id, description, price);
        
        System.out.println("product--->"+product);
        
        Product product2;
        id=2;
        description="Mouse";
        price=1000;
        
        pvp= Tax.computeTotal(price,15F);
        
        product2= new Product(id, description, price);
        
        System.out.println("product--->2"+product2);
        
    }
    
}

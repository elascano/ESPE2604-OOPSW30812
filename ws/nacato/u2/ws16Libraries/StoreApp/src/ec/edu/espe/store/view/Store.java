package ec.edu.espe.store.view;
import ec.edu.espe.store.model.Product;
import utils.Tax;

/**
 *
 * @author Angie Nacato, Error 404, @ESPE
 */
public class Store {

    public static void main(String[] args) {
        int id;
        String description;
        float price;
        float pvp;
        Product product;
        
        //TODO read from keyboard
        
        id=1;
        description="computer";
        price=100;
        
        pvp = price + Tax.computeTotal(price, 15F);
        
        product = new Product(id, description, price);
        System.out.println("product -->" + product);
        
        Product product2;
        
        id=2;
        description= "mouse";
        price = 1000;
        pvp = price + Tax.computeTotal(price, 15F);
        product2 = new Product(id, description, price, pvp);
        
        System.out.println("product 2 -->" + product2);
    }
}

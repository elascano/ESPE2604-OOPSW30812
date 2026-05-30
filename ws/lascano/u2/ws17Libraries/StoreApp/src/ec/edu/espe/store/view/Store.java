package ec.edu.espe.store.view;

import ec.edu.espe.store.model.Product;
import utils.Tax;

/**
 *
 * @author Edison Lascano, Object Masters, @ESPE
 */
public class Store {

    public static void main(String[] args) {
        int id;
        String description;
        float price;
        float pvp;
        Product product;
        //TODO read from keyboard

        id = 1;
        description = "computer";
        price = 100;

        pvp = Tax.computeTotal(price, 15F);
        
        product = new Product(id, description, price);

        System.out.println("product --> " + product);
        
        Product product2;
        
        id =2;
        description = "mouse";
        price = 3.57F;
        pvp = Tax.computeTotal(price, 15F);
        product2 = new Product(id, description, price, pvp);
        
        System.out.println("prduct 2 --> " + product2);
        
        float addend1 = 1.42F;
        float addend2 = 1.24F;
        float sum;
        sum = addend1 + addend2;
        
        System.out.println("the additon of " + addend1 + " + " + addend2 + " is " + sum);
        
    }

}

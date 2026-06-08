package ec.edu.espe.chickenfarm.view;

import ec.edu.espe.chickenfarm.model.Chicken;
import java.util.ArrayList;


/**
 *
 * @author Edison Lascano, Object Masters, @ESPE
 */
public class ChickenFarmSimulator {

    public static void main(String[] args) {
        Chicken chicken;
        
        chicken = new Chicken(1, "Lucy", "white and brown", 1, true);

        System.out.println("my chicken is --> " + chicken);
        
        ArrayList<Chicken> chickens;
        
        chickens = new ArrayList<>();
        
        chickens.add(chicken);
        chicken = new Chicken(2, "Maruja", "black", 2, false);
        chickens.add(chicken);

        chicken = new Chicken(3, "Bety", "white", 2, true);
        chickens.add(chicken);
        
        
        System.out.println("chickens --> " + chickens);
        
        
    }
}

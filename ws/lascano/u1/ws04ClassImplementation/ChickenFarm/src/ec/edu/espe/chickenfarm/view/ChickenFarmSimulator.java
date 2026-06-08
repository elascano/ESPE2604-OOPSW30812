package ec.edu.espe.chickenfarm.view;

import ec.edu.espe.chickenfarm.model.Chicken;

/**
 *
 * @author Edison Lascano, Object Masters, @ESPE
 */
public class ChickenFarmSimulator {
    public static void main(String[] args) {
        Chicken chicken;
        int numberOfEggs;
        Integer amountOfPoop;
        
        numberOfEggs = 12;
        chicken = new Chicken();
        amountOfPoop = 3;
        System.out.println("amount of poop --> " + amountOfPoop);
        amountOfPoop = new Integer("4");
        System.out.println("amount of poop --> " + amountOfPoop);
       

        System.out.println("number of eggs --> " + numberOfEggs);
        System.out.println("chicken --> " + chicken);
        
        chicken.setName("Lucy");
        System.out.println("chicken name --> " + chicken.getName());
        
        
    }
    
}

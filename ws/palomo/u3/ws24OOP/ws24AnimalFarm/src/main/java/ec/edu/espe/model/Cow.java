/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.espe.model;
import ec.edu.espe.controller.IMeatAnimal;
import java.util.ArrayList;
import java.util.Date;
        
/**
 *
 * @author Cristian
 */
public class Cow extends FarmAnimal implements IMeatAnimal {
     private boolean isProducingMilk;

    public Cow(boolean isProducingMilk, int id, String breed, Date bornOnDate, float weight) {
        super(id, breed, bornOnDate, weight);
        this.isProducingMilk = isProducingMilk;
    }
    
    public float milk(){
        return 0;
    }
    
    public void sendToButcher(){
        //ToDO
    }
    @Override
    public void feed(Food food) {
        System.out.println("Feeding a cow with --> " + food);
    }

    @Override
    public ArrayList<Cut> cut() {
        ArrayList<Cut> cuts;
        cuts = new ArrayList<>();
        System.out.println("Cutting to --> " + cuts);
        return cuts;
    }

    @Override
    public void sendToSlughterHouse(SlughterHouse slaughterHouse) {
        System.out.println("Seeding cow");
    }
    
        public boolean isIsProducingMilk() {
        return isProducingMilk;
    }

    public void setIsProducingMilk(boolean isProducingMilk) {
        this.isProducingMilk = isProducingMilk;
    }
}


package ec.edu.espe.chickencoops.view;

import ec.edu.espe.chickencoops.model.Chicken;
import java.util.Date;

/**
 *
 * @author Jennyfer Nase
 */
public class ChickenFarmSimulator {
    public static void main (String [] args) {
        
    int id;
    String name;
    String color; 
    Date bornOnDate;
    int age ;
    boolean IsMolting;
     
    // todo input from keyboard
    //todo do-while to enter as many chickens as the user wants
    
    Chicken chicken;
    Chicken chickens[];
    chickens = new Chicken[5];
    
    id = 1;
    name ="Lucy";
    color = "brown and white";
    bornOnDate = new Date();
    age= 0;
    IsMolting = false;
    
    chickens [0] = new Chicken (id , name , color , bornOnDate , age , IsMolting);
    
    id = 2;
    name = "Jennyfer Nase";
    color = "Black"; 
    bornOnDate = new Date (06 , 07 , 10);
     age = 0;
    IsMolting = false;
    
    chickens [1] = new Chicken (id , name , color , bornOnDate , age , IsMolting);
    
    id = 3;
    name = "Fernanda";
    color = "Red"; 
    bornOnDate = new Date (06 , 07 , 10);
     age = 0;
    IsMolting = true;
    
     chickens [2] = new Chicken(id , name , color , bornOnDate , age , IsMolting);
     
    id = 4;
    name = "Maria";
    color = "Brown"; 
    bornOnDate = new Date (06 , 07 , 10);
    age = 0;
    IsMolting = true;
  
    chickens [3] = new Chicken(id , name , color , bornOnDate , age , IsMolting);
    
    id = 5;
    name = "Maria";
    color = "Brown"; 
    bornOnDate = new Date (06 , 07 , 10);
    age = 0;
    IsMolting = true;
    
    chickens [4] = new Chicken(id , name , color , bornOnDate , age , IsMolting);
    
    System.out.println("Quiez 2026-04-26 Jennyfer Nase");
     
    for(int i =0; i < 5 ; i++){
        chickens [i]. setId(i+1);
        //System.out.println("name -->" + chickens[i].getName());
        System.out.println("chicken["+ (i+1)+ "]" + chickens [i]);
         
     }
    }
    
}

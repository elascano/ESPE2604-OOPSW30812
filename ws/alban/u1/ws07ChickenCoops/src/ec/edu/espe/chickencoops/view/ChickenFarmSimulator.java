package ec.edu.espe.chickencoops.view;

import ec.edu.espe.chickencoops.model.Chicken;
import java.util.Date;
import java.util.Scanner;

//@author Christopher Lomas,<CodeBros,@ESPE>
public class ChickenFarmSimulator {

    public static void main(String[] args) {
        int id;
        String name;
        String color;
        Date bornOnDate = new Date();
        int age;
        boolean isMolting;
        

        
        //  TODO input from keyboard
        //  TODO do-while to Enter as many chickens as the user wants 
        id = 1;
        name = "Lucy";
        color = "brown and white";
        bornOnDate = new Date();
        isMolting = false;
        age = 0;

        Chicken chicken;
        Chicken chickens[];
        
        chickens=new Chicken [5];
        

        chickens[0] = new Chicken(id, name, color, bornOnDate, age, isMolting);
        

        id = 2;
        name = "Christopher Lomas";
        color = " Red";
        bornOnDate = new Date(126, 11, 17);
        isMolting = false;
        age = 0;

        chickens[1] = new Chicken(id, name, color, bornOnDate, age, isMolting);
        
        
        id = 3;
        name = "Josue Lomas";
        color = " Black";
        bornOnDate = new Date(126, 4, 17);
        isMolting = true;
        age = 0;
        
        id = 4;
        name = "Andres Lomas"; 
        color = "White";
         chickens[3] = new Chicken(id, name, color, bornOnDate, age, isMolting);
    
        id = 5;
        name = "Jonathan Lomas";  
        color = "Yellow";
        chickens[4] = new Chicken(id, name, color, bornOnDate, age, isMolting);

        
        

        
        
        chickens[2]= new Chicken(id, name, color, bornOnDate, age, isMolting);
        chickens[3]= new Chicken(id, name, color, bornOnDate, age, isMolting);
        chickens[4]= new Chicken(id, name, color, bornOnDate, age, isMolting);
        
        
        System.out.println("Quiz 26-4-2026");
        
        for (int i=0; i<5;i++)
        {
            chickens [i].setId(i+1);
            System.out.println("name--->"+chickens[i].getName());
            System.out.println("chicken [" + (i + 1) + "]" + chickens[i]);
        }
        
        

    }
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.espe.chickencoops.view;

import ec.edu.espe.chickencoops.model.Chicken;
import java.util.Date;
//import java.util.Date;

/**
 *
 * @author Odalys Chavez, CodeBreakers, @ESPE
 */
public class ChickenFarmSimulation {
    public static void main(String[] args) {
        int id;
        String name;
        String color;
        Date bornOnDate;
        bornOnDate = new Date();
        //bornOnDate = newDate();
        int age;
        boolean isMolting;
        // TODO imput from keyboard
        //TODO do-while
        id=1;
        name="Lucy";
        color="brown and white";
        bornOnDate= new Date();
        age=0;
        isMolting=false;
        
        Chicken chickens[];
        chickens = new Chicken[5];
        
        chickens[0]= new Chicken(id, name, color, bornOnDate, age, isMolting);
        
        
        
        id= 2;
        name ="Odalys Chavez";
        color="Red";
        bornOnDate= new Date(105, 4, 31);
        age= 0;
        isMolting= false;
        
        chickens[1] = new Chicken(id, name, color, bornOnDate, age, isMolting);
        
        id= 3;
        name ="Jharely Bravo";
        color="Pink";
        bornOnDate= new Date(105, 10, 14);
        age= 0;
        isMolting= true;
        
        chickens[2] = new Chicken(id, name, color, bornOnDate, age, isMolting);
        
        id= 4;
        name ="Hilda Jacome";
        color="Yellow";
        bornOnDate= new Date(70, 0, 1);
        age= 0;
        isMolting= true;
        chickens[3] = new Chicken(id, name, color, bornOnDate, age, isMolting);
        
        id= 5;
        name ="Daylin Gaibor";
        color="Black";
        bornOnDate= new Date(105, 7, 20);
        age= 0;
        isMolting= false;
        chickens[4] = new Chicken(id, name, color, bornOnDate, age, isMolting);
        System.out.println("QUIZ 2026-04-26 Odalys Chavez");
        for(int i=0; i<5; i++){
            chickens[i].setId(i+1);
            //System.out.println("name-->"+ chickens[i].getName());
            System.out.println("chicken ["+ (i+1)+ "]" + chickens[i]);
        }
        
    }
}

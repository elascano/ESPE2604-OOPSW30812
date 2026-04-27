/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.espe.chickencoops.view;

import ec.edu.espe.chickencoops.model.Chicken;
import java.util.Date;

/**
 *
 * @author Cristian, Error 404, @ESPE
 */
public class CkickenFarMSimulator {

    public static void main(String[] args) {
        int id;
        String name;
        String color;
        Date bornOnDate;
        int age;
        boolean isMolting;
        
        //Todo input from keyboard
        //Todo do-while to enter as many 
        id = 1;
        name = "lucy";
        color = "bronw and while";
        bornOnDate = new Date();
        age = 0;
        isMolting = false;

        Chicken chicken;
        Chicken chickens[];
        chickens = new Chicken[7];

        chickens[0] = new Chicken(id, name, color, bornOnDate, age, isMolting);

        id = 2;
        name = "Cristian Palomo";
        color = "Red";
        bornOnDate = new Date(104, 12, 23);
        age = 0;
        isMolting = false;

        chickens[1] = new Chicken(id, name, color, bornOnDate, age, isMolting);
        
        id = 3;
        name = "Cesar";
        color = "Black";
        bornOnDate = new Date(106, 12, 23);
        age = 0;
        isMolting = true;
        
        chickens[2] = new Chicken(id, name, color, bornOnDate, age, isMolting);
        
        id = 4;
        name = "Pedro";
        color = "pink";
        bornOnDate = new Date(107, 12, 21);
        age = 0;
        isMolting = false;
        
        chickens[3] = new Chicken(id, name, color, bornOnDate, age, isMolting);
        
        id = 5;
        name = "Antonio";
        color = "blue";
        bornOnDate = new Date(103, 12, 29);
        age = 0;
        isMolting = false;
        
        chickens[4] = new Chicken(id, name, color, bornOnDate, age, isMolting);
        chickens[5] = new Chicken(id, name, color, bornOnDate, age, isMolting);
        
        id = 6;
        name = "Talia";
        color = "blue";
        bornOnDate = new Date(109, 12, 29);
        age = 0;
        isMolting = false;
        
        chickens[6] = new Chicken(id, name, color, bornOnDate, age, isMolting);
        System.out.println("QUIZ 2026-04-26 Cristian Palomo ");
        
        for(int i = 0; i < 6; i++){
            chickens[i].setId(i+1);
            //System.out.println("name-->"+ chickens [i].getName());
            System.out.println("chicken["+ (i) + "]" + chickens[i]);
        }
    }
}

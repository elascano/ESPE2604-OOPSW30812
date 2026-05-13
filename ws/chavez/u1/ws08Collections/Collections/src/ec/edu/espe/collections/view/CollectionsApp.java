/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.espe.collections.view;

import ec.edu.espe.collections.model.Person;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;

/**
 *
 * @author Odalys Chavez, CodeBreakers, @ESPE
 */
public class CollectionsApp {
    public static void main(String[] args) {
         int id;
        String fullName;
        LocalDate bornOnDate;
        boolean alive;
       
        id = 1;
        fullName = "Odalys Chavez";
        bornOnDate = LocalDate.of(2005, 05, 31);
        alive = true;
        
        Person person = new Person(id, fullName, bornOnDate, alive);
        
        System.out.println(person);
        System.out.println("Age of person 1 is " + person.computeAgeInYears());
        
        id = 2;
        fullName = "Eustaquio Perez de la Fuente Pereira";
        bornOnDate = LocalDate.of(1990, 12, 11);
        alive = false;
        
        Person person2 = new Person(id, fullName, bornOnDate, alive);
        
        System.out.println("Age of person 2 is " + person.computeAgeInYears());
        
        Collection things;
        things = new ArrayList<>();
        System.out.println("size of things -->" + things);
        
        things.add(8000);
        things.add(3.5F);
        things.add("Quito");
        things.add(true);
        
        printTheCollection(things);
        
        things.add(person);
        things.add(person2);
        
        printTheCollection(things);
        
        things.add(4078.76F);
        things.add("a");
        
        printTheCollection(things);
        
        ArrayList<Person> people = new ArrayList<>();
        people.add(person);
        people.add(person2);
        
        System.out.println("\npeople --> " + people);
        System.out.println("");
        
        people.forEach((p)->{
        System.out.println("Person --> " + p);
    });
        
        
    }
    
    private static void printTheCollection(Collection things){
        System.out.println("\nsize of things --> " + things.size());
        System.out.println("These are my things --> \n" + things);
    }

    
}
    


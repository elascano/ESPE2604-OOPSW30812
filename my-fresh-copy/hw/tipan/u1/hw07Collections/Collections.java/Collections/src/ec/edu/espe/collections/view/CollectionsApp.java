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
 * @author Ronald Tipan <The-Softwarrios at ESPE>
 */
public class CollectionsApp {
    public static void main (String[] args) {
        int id;
        String name ;
        LocalDate bornOnDate;
        boolean alive;
        
        id = 1; 
        name = "Ronald Tipan";
        bornOnDate = LocalDate.of(2007, 01 ,31);
        alive = true;
        
        
        
        Person person = new Person(id,name,bornOnDate,alive);
        
        System.out.println(person);
        System.out.println("age of person 1 is " + person.computoAgeInYears());
        
        id = 2;
        name = "Valeria Suntaxi";
        bornOnDate = LocalDate.of(2006, 05 ,12);
        alive = true;
        
        Person person2 = new Person(id, name, bornOnDate, alive);
        
        System.out.println(person2);
        System.out.println("age of person 2 is " + person2.computoAgeInYears());
        
        
        Collection things;
        things = new ArrayList<>();
        things.add(name);
        things.add(1.5);
        things.add("Quito");
        things.add(true);
        printTheCollection(things);
        
        things.add(person);
        things.add(person2);
        
        printTheCollection(things);
        
        things.add(85);
        things.add(451);
        printTheCollection(things);
        
        Collection<Integer> integers;
        integers = new ArrayList<>();
        
        integers.add(5);
        integers.add(id);
        
        ArrayList<Person> people = new ArrayList<>();
        people.add(person);
        people.add(person2);
        
        System.out.println("people -->" +people );
        
        people.forEach(p -> {
              System.out.println("Person --> " + p);
});
    }

    private static void printTheCollection(Collection things) {
        System.out.println("size of things -->" +things.size() );
        System.out.println("These are my Things -->" + things.size() );
    }
       
 }

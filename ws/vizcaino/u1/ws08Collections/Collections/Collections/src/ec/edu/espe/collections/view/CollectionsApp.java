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
 * @author Adrian Vizcaino <The-Softwarrios at ESPE>
 */
public class CollectionsApp {
    public static void main (String[] args) {
        int id;
        String name ;
        LocalDate bornOnDate;
        boolean alive;
        
        id = 1; 
        name = "Adrian Vizcaino";
        bornOnDate = LocalDate.of(2006, 05 ,17);
        alive = true;
        
        Person person = new Person(id,name,bornOnDate,alive);
        
        System.out.println(person);
        
        System.out.println("age of person 1 is " + person.computoAgeInYears());
        
        id = 2;
        name = "Cecilia Torres";
        bornOnDate = LocalDate.of(1940, 05 ,17);
        alive = true;
        
        Person person2 = new Person(id, name, bornOnDate, alive);
        
        System.out.println("age of person 2 is " + person2.computoAgeInYears());
        
        
        Collection things;
        things = new ArrayList<>();
        System.out.println("size of things -->" + things.size());
        things.add(8000);
        things.add(3.5F);
        things.add("Quito");
        things.add(true);
        
        printTheCollection(things);
        
        things.add(person);
        things.add(person2);
        
        printTheCollection(things);
        
        things.add(4078.76F);
        things.add('a');
        printTheCollection(things);
        
        Collection<Integer> integers;
        integers = new ArrayList<>();
        
        integers.add(5);
        integers.add(id);
        
        ArrayList<Person> people = new ArrayList<>();
        people.add(person);
        people.add(person2);
        System.out.println("");
        System.out.println("people -->" +people );
        System.out.println("");
        people.forEach(p -> {
              System.out.println("Person --> " + p);
});
        System.out.println("");
        for(int i = 2 ; i <7 ; i++){
              people.add(new Person(i+1, "Adrian", LocalDate.now(),true));
        }
        
        people.forEach((p) -> {
            System.out.println("Person ->>" +p);
        });
    }
    private static void printTheCollection(Collection things) {
        System.out.println("size of things -->" +things.size() );
        System.out.println("These are my Things -->" + things.size() );
    }
  
 }

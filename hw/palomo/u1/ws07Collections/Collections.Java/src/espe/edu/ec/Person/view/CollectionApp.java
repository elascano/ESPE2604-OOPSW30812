/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package espe.edu.ec.Person.view;
import espe.edu.ec.Person.model.Person;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
/**
 *
 * @author Cristian
 */
public class CollectionApp {
    public static void main(String[] args) {

        int id;
        String fullName;
        LocalDate bornOnDate;
        boolean alive;

        
        id = 1;
        fullName = "Cristian Palomo";
        bornOnDate = LocalDate.of(2005, 01, 23);
        alive = true;

        Person person = new Person(id, fullName, bornOnDate, alive);
        System.out.println(person);
        System.out.println("Age of person 1 is " + person.computeAge());

       
        id = 2;
        fullName = "Martha Bucaran";
        bornOnDate = LocalDate.of(2000, 9, 27);
        alive = false;

        Person person2 = new Person(id, fullName, bornOnDate, alive);
        System.out.println("Age of person 2 is " + person2.computeAge());
        
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
        
        Collection<Integer> integers;
        integers = new ArrayList <>();
        
        integers.add(5);
        integers.add(id);
        
        ArrayList<Person> people;
        people = new ArrayList<>();
        people.add(person);
        people.add(person2);
        
        System.out.println("");
        System.out.println("people --> " + people);
        System.out.println("");
        people.forEach((p)->{
            System.out.println("Person --> " + p);
    });
    people.forEach((p)->{
        System.out.println("Person --> " + p);
        });
    }
    
    private static void printTheCollection(Collection things){
        System.out.println("\nsize of things --> " + things.size());
        System.out.println("These are my things --> \n" + things);
    }
}

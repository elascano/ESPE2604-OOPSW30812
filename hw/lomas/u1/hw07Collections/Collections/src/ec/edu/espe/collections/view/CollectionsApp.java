package ec.edu.espe.collections.view;

import ec.edu.espe.collections.model.Person;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class CollectionsApp {
    public static void main(String[] args) {

        int id;
        String fullName;
        LocalDate bornOnDate;
        boolean alive;

        
        id = 1;
        fullName = "Christopher Lomas";
        bornOnDate = LocalDate.of(2006, 12, 17);
        alive = true;

        Person person = new Person(id, fullName, bornOnDate, alive);
        System.out.println(person);
        System.out.println("Age of person 1 is " + person.computeAge());

       
        id = 2;
        fullName = "Mayra Haro";
        bornOnDate = LocalDate.of(1910, 8, 8);
        alive = false;

        Person person2 = new Person(id, fullName, bornOnDate, alive);
        System.out.println("Age of person 2 is " + person2.computeAge());

        
        List<Person> things = new ArrayList<>();
        System.out.println("Size of things is " + things.size());
        
       
        things.add(person);
        things.add(person2);

        ArrayList<Person>people=new ArrayList();
        people.add(person);
        people.add(person2);
        System.out.println("people"+people);
        
        System.out.println("");
        
        System.out.println("Person"+person);
        
    }
        

    }

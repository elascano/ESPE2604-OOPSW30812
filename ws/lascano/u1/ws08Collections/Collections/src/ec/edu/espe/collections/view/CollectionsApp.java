package ec.edu.espe.collections.view;

import ec.edu.espe.collections.model.Person;
import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.Collection;

/**
 *
 * @author Edison Lascano, Object Masters, @ESPE
 */
public class CollectionsApp {

    public static void main(String[] args) {
        int id;
        String fullName;
        LocalDate bornOnDate;
        boolean alive;
        
        id = 1;
        fullName = "Edison Lascano";
        bornOnDate = LocalDate.of(1970, 12, 17);
        alive = true;
        
        Person person = new Person(id, fullName, bornOnDate, alive);
        
        System.out.println(person);
        
        System.out.println("age of person 1 is " + person.computeAgeInYears());
        
        id = 2;
        fullName = "Tarjelia Tello";
        bornOnDate = LocalDate.of(1910, 8, 8);
        alive = false;
        
        Person person2 = new Person(id, fullName, bornOnDate, alive);
        
        System.out.println("age of person 2 is " + person2.computeAgeInYears());
        
        
        Collection things;
        things = new ArrayList<>();
        System.out.println("size of things --> " + things.size() );
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
        
        ArrayList<Person> people;
        people = new ArrayList<>();
        people.add(person);
        people.add(person2);
        System.out.println("");
        System.out.println("people --> " + people);
        System.out.println("");
        people.forEach((p) -> {
   	         System.out.println("Person --> " + p);
        });
        
        System.out.println("");
        for (int i = 2 ; i <7 ; i++ ) {
   	         people.add(new Person(i+1, "Edison", LocalDate.now(), true));
        }

        people.forEach((p) -> {
   	         System.out.println("Person --> " + p);
        });
    }

    private static void printTheCollection(Collection things) {
        System.out.println("\nsize of things --> " + things.size() );
        System.out.println("These are my things --> \n" + things);
    }

}

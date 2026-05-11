package ec.edu.espe.repaso.view;
import ec.edu.espe.repaso.model.Person;

/**
 *
 * @author Mateo Artieda,MKA Programer, @ESPE
 */
public class PersonReviewPoo {
    public static void main (String [] args){
        int id;
        String name;
        String color;
        int age;
        
        
        id = 1;
        name = "Lucy";
        color = "brown and white";
        age = 0;
        
        Person person;
        Person persons[];
        
        
        persons = new Person[3];
        persons[1] = new Person(id, name, color, age);

System.out.println(persons[1]);
    }
}

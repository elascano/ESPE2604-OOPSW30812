/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.espe.view;

import ec.edu.espe.model.Person;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;

/**
 *
 * @author Brandon Collahuazo, code Bros, @ESPE
 */
public class CollectionControlerApp {

    public static void main(String[] args) {
        int id;
        String fullName;
        LocalDate bornOnDate;
        boolean alive;

        id = 1;
        fullName = "Brandon Collahuazo";
        bornOnDate = LocalDate.of(1999, 03, 04);
        alive = true;
        Person person = new Person(id, fullName, bornOnDate, alive);

        System.out.println(person);
        System.out.println("Age of person 1 is " + person.computeAgeInYears());

        id = 2;
        fullName = "Elizabeth Cumbajin";
        bornOnDate = LocalDate.of(1962, 04, 23);
        alive = true;
        Person person2 = new Person(id, fullName, bornOnDate, alive);

        Collection things;
        things = new ArrayList<>();
        System.out.println("size of things -->" + things);

        things.add(8000);
        things.add(3.5F);
        things.add("Quito");
        things.add(true);

        printTheCollection(things);

        things.add(4078.76F);
        things.add("a");

        printTheCollection(things);

        ArrayList<Person> people = new ArrayList<>();
        people.add(person);
        people.add(person2);

        System.out.println("\npeople --> " + people);
        System.out.println("");

        people.forEach((p) -> {
            System.out.println("Person --> " + p);
        });
        
        System.out.println("");
        for (int i = 2; i < 7; i++) {
            people.add(new Person(i + 1, "pepito", LocalDate.now(), true));
        }
        people.forEach((p) -> {
            System.out.println("Person --> " + p);
        });
    }

    private static void printTheCollection(Collection things) {
        System.out.println("\nsize of things --> " + things.size());
        System.out.println("These are my things --> \n" + things);
    }

}


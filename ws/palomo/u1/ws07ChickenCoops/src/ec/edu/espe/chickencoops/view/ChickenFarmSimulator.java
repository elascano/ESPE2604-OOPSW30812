/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.espe.chickencoops.view;

import ec.edu.espe.chickencoops.model.Chicken;
import java.util.Date;
import java.util.Scanner;

/**
 *
 * @author Cristian, Error 404, @ESPE
 */
public class ChickenFarmSimulator {

    public static void main(String[] args) {

        Scanner keyboard = new Scanner(System.in);

        int id;
        String name;
        String color;
        Date bornOnDate;
        int age;
        boolean isMolting;

        Chicken chickens[] = new Chicken[6];

        for (int i = 0; i < 6; i++) {

            System.out.println("\nChicken #" + (i + 1));

            System.out.print("Enter id: ");
            id = keyboard.nextInt();

            System.out.print("Enter name: ");
            name = keyboard.next();

            System.out.print("Enter color: ");
            color = keyboard.next();

            bornOnDate = new Date();

            System.out.print("Enter age: ");
            age = keyboard.nextInt();

            System.out.print("Is molting? (true/false): ");
            isMolting = keyboard.nextBoolean();

            chickens[i] = new Chicken(id, name, color, bornOnDate, age, isMolting);
        }

        System.out.println("\nQUIZ 2026-04-26 Cristian Palomo");

        for (int i = 0; i < 6; i++) {
            System.out.println("chicken[" + i + "] " + chickens[i]);
        }
    }
}
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.espe.templatemethod;

import java.util.Scanner;

/**
 *
 * @author Daniel Codena, CodeBreakers, @ESPE
 */
public class Coffee extends CaffeineBeverage {

    @Override
    public void brew() {
        System.out.println("Dripping coffe through filter ");
    }

    @Override
    public void addCondiments() {
        System.out.println("Adding sugar an milk");
    }

    @Override
    public String getUserInput() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Would you like milk and sugar with your coffee (y/n)?");
        String answer = scanner.nextLine();

        return answer;
    }

}

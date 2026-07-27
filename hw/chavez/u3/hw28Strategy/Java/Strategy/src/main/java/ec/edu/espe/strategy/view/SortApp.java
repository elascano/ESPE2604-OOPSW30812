/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.espe.strategy.view;

import ec.edu.espe.strategy.controller.SortingContext;

/**
 *
 * @author Odalys Chavez, CodeBreakers, @ESPE
 */
public class SortApp {
    public static void main(String[] args) {

        int[] data = {3,6,4,6,7,8,5,6,7,5,3,3};

        SortingContext sc = new SortingContext();

        int[] sorted = sc.sort(data);

        for (int n : sorted) {
            System.out.print(n + " ");
        }
    }
    
}

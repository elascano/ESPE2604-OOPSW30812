/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.espe.observer;

/**
 *
 * @author Adrian Vizcaino <The-Softwarriors at ESPE>
 */
public class Investor implements IInvestor {
    private String name;

    public Investor(String name) {
        this.name = name;
    }

    public void update(Stock stock, Object args) {
        System.out.print("Notified observer " + name + " ");
        if (args instanceof String) {
            System.out.println("The symbol of " + stock.getSymbol() + " changed to: " + args);
        } else if (args instanceof Double) {
            System.out.println("The price of " + stock.getSymbol() + " changed to: " + args);
        }
    }
}
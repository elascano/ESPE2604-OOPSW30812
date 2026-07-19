/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.espe.observerpattern.model;

/**
 *
 * @author ronal
 */
public class Investor implements IInvestor {

    private String name;

    public Investor(String name) {
        this.name = name;
    }

    @Override
    public void update(Stock stock) {
        System.out.println(
                "Notified " + name
                + " of " + stock.getSymbol()
                + " change to " + stock.getPrice()
        );
    }

    public String getName() {
        return name;
    }
}

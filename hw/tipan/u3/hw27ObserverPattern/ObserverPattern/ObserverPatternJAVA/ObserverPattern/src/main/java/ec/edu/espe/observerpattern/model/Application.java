/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.espe.observerpattern.model;

/**
 *
 * @author ronal
 */
public class Application {

    public static void main(String[] args) {

        IBM ibm = new IBM("IBM", 120.00);

        Investor investor1 = new Investor("Sorros");
        Investor investor2 = new Investor("Berkshire");

        ibm.addInvestor(investor1);
        ibm.addInvestor(investor2);

        ibm.setPrice(121.00);

        ibm.setSymbol("IBM Corporation");

        ibm.removeInvestor(investor1);

        ibm.setPrice(125.00);
    }
}
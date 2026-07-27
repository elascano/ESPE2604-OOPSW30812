/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package ec.edu.espe.observer.model;

import java.util.ArrayList;
import java.util.Iterator;
/**
 *
 * @author Cristian Palomo, Error 404, @ESPE
 */
public abstract class Stock {
    protected String symbol;
    protected double price;
    private ArrayList<Investor> investors = new ArrayList<>();

    public Stock() {}

    public void addObserver(Investor investor) {
        investors.add(investor);
    }

    public void deleteObserver(Investor investor) {
        investors.remove(investor);
    }

    public void notifyObservers(Object args) {
        Iterator<Investor> i = investors.iterator();
        while (i.hasNext()) {
            Investor investor = i.next();
            investor.update(this, args);
        }
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
        notifyObservers(symbol);
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
        notifyObservers(Double.valueOf(price));
    }
}

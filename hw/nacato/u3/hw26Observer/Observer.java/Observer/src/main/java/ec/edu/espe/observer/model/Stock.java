/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.espe.observer.model;

import ec.edu.espe.observer.controller.IInvestor;
import java.util.ArrayList;

/**
 *
 * @author Angie Ñacato, Error 404, @ESPE
 */
public abstract class Stock {

    protected String symbol;
    protected double price;
    private ArrayList<IInvestor> investors = new ArrayList();

    public Stock() {
    }

    public void addObserver(IInvestor iinvestor) {
        investors.add(iinvestor);
    }

    public void deleteObserver(IInvestor iinvestor) {
        investors.remove(iinvestor);
    }

    public void notifyObservers(Object args) {
        for (IInvestor investor : investors) {
            investor.update(this, args);
        }
    }

    public String getSymbol() {
        return symbol;
    }

    public abstract void setSymbol(String symbol);

    public double getPrice() {
        return price;
    }

    public abstract void setPrice(double price);

    public ArrayList<IInvestor> getInvestors() {
        return investors;
    }

    public void setInvestors(ArrayList<IInvestor> investors) {
        this.investors = investors;
    }
    
}

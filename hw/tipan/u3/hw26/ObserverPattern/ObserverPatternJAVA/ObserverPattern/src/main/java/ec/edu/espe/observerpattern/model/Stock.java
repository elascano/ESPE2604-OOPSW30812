/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.espe.observerpattern.model;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ronal
 */
public abstract class Stock {

    private String symbol;
    private double price;
    private List<IInvestor> investors;

    public Stock(String symbol, double price) {
        this.symbol = symbol;
        this.price = price;
        this.investors = new ArrayList<>();
    }

    public void addInvestor(IInvestor investor) {
        investors.add(investor);
    }

    public void removeInvestor(IInvestor investor) {
        investors.remove(investor);
    }

    protected void notifyInvestors() {
        for (IInvestor investor : investors) {
            investor.update(this);
        }
    }

    public String getSymbol() {
        return symbol;
    }

    public double getPrice() {
        return price;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
        notifyInvestors();
    }

    public void setPrice(double price) {
        this.price = price;
        notifyInvestors();
    }
}

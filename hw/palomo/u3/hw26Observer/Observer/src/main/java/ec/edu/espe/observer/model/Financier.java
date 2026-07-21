/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package ec.edu.espe.observer.model;

import ec.edu.espe.observer.view.StockView;

/**
 *
 * @author Cristian Palomo, Error 404, @ESPE
 */
public class Financier implements Investor{
    private String name;
    private String observerState;
    private Stock stock;

    public Financier(String name) {
        this.name = name;
    }

    @Override
    public void update(Stock stock, Object args) {
        this.stock = stock;
        StockView.printNotification(name, stock, args);
    }
}

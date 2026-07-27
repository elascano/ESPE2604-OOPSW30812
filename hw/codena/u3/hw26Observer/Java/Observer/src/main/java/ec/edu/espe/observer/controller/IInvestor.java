/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package ec.edu.espe.observer.controller;

import ec.edu.espe.observer.model.Stock;

/**
 *
 * @author Daniel Codena, CodeBreakers, @ESPE
 */
public interface IInvestor {
    void update(Stock stock, Object args);
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

/**
 *
 * @author Alexander Tipantiza, The Softwarrios, @ESPE
 */
package com.mycompany.storeapp;

import ec.edu.espe.storeapp.model.DataRepository;
import ec.edu.espe.storeapp.view.Menu;

public class StoreApp {

    public static void main(String[] args) {
        // En proyectos Maven de NetBeans, esto crea el json directo en la raíz de "StoreApp"
        String jsonFilePath = "products.json"; 
        
        DataRepository repository = new DataRepository(jsonFilePath);
        Menu menuUI = new Menu(repository);
        
        menuUI.start();
    }
}
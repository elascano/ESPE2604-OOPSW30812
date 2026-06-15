package ec.edu.espe.countrymanager.main;

import ec.edu.espe.countrymanager.controller.CountryController;
import ec.edu.espe.countrymanager.model.CountryModel;
import ec.edu.espe.countrymanager.view.CountryView;

import javax.swing.*;

public class CountryManagerApp {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            String dataFile = "countries.txt";
            
            CountryModel model = new CountryModel(dataFile);
            CountryView view = new CountryView();
            new CountryController(model, view);
            
            view.setVisible(true);
        });
    }
}

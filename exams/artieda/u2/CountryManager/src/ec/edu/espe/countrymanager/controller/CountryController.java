package ec.edu.espe.countrymanager.controller;

import ec.edu.espe.countrymanager.model.Country;
import ec.edu.espe.countrymanager.model.CountryModel;
import ec.edu.espe.countrymanager.view.CountryView;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class CountryController {
    private final CountryModel model;
    private final CountryView view;

    public CountryController(CountryModel model, CountryView view) {
        this.model = model;
        this.view = view;



        this.view.addClearListener(new ClearListener());
        this.view.addFindListener(new FindListener());


        refreshTable();
    }

    private void refreshTable() {
        List<Country> countries = model.getAllCountries();
        view.getTblModel().setRowCount(0);
        for (Country country : countries) {
            Object[] row = {
                country.getId(),
                country.getName(),
                country.getPopulation(),
                country.getArea(),
                String.format("%.2f", country.getPopulationDensity())
            };
            view.getTblModel().addRow(row);
        }
    }



    class FindListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String id = view.getCountryId();
            if (id.isEmpty()) {
                view.showMessage("Please enter a Country ID to search.", "Input Required", JOptionPane.WARNING_MESSAGE);
                return;
            }

            Country country = model.findCountryById(id);
            if (country != null) {
                view.setCountryName(country.getName());
                view.setCountryPopulation(String.valueOf(country.getPopulation()));
                view.setCountryArea(String.valueOf(country.getArea()));
                view.setCountryIdEditable(false);
                view.showMessage("Country found!", "Search Result", JOptionPane.INFORMATION_MESSAGE);
            } else {
                view.showMessage("Country with ID " + id + " not found.", "Not Found", JOptionPane.INFORMATION_MESSAGE);
            }
        }
    }

    class ClearListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            view.clearForm();
        }
    }
}

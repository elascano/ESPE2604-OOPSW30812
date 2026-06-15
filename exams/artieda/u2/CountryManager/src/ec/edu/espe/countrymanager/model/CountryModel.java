package ec.edu.espe.countrymanager.model;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class CountryModel {
    private final List<Country> countries;
    private final String filePath;

    public CountryModel(String filePath) {
        this.filePath = filePath;
        this.countries = new ArrayList<>();
        loadFromFile();
    }

    public synchronized void addCountry(Country country) throws IllegalArgumentException {
        if (findCountryById(country.getId()) != null) {
            throw new IllegalArgumentException("Country with ID " + country.getId() + " already exists.");
        }
        countries.add(country);
        saveToFile();
    }

    public synchronized Country findCountryById(String id) {
        for (Country country : countries) {
            if (country.getId().equalsIgnoreCase(id)) {
                return country;
            }
        }
        return null;
    }

    public synchronized boolean updateCountry(String id, String newName, long newPopulation, double newArea) {
        Country country = findCountryById(id);
        if (country != null) {
            country.setName(newName);
            country.setPopulation(newPopulation);
            country.setArea(newArea);
            saveToFile();
            return true;
        }
        return false;
    }

    public synchronized boolean deleteCountry(String id) {
        Country country = findCountryById(id);
        if (country != null) {
            countries.remove(country);
            saveToFile();
            return true;
        }
        return false;
    }

    public synchronized List<Country> getAllCountries() {
        return new ArrayList<>(countries);
    }

    private void loadFromFile() {
        File file = new File(filePath);
        if (!file.exists()) {
            try {
                file.createNewFile();
                seedInitialData();
            } catch (IOException e) {
                System.err.println("Error creating database file: " + e.getMessage());
            }
            return;
        }

        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = br.readLine()) != null) {
                if (line.trim().isEmpty()) continue;
                try {
                    Country country = Country.fromString(line);
                    if (country != null) {
                        countries.add(country);
                    }
                } catch (Exception e) {
                    System.err.println("Error parsing line: " + line + " - " + e.getMessage());
                }
            }
        } catch (IOException e) {
            System.err.println("Error reading database file: " + e.getMessage());
        }
    }

    private void saveToFile() {
        try (PrintWriter pw = new PrintWriter(new FileWriter(filePath))) {
            for (Country country : countries) {
                pw.println(country.toString());
            }
        } catch (IOException e) {
            System.err.println("Error writing to database file: " + e.getMessage());
        }
    }

    private void seedInitialData() {
        try {
            addCountry(new Country("ECU", "Ecuador", 18000000, 283561.0));
            addCountry(new Country("COL", "Colombia", 51000000, 1141748.0));
            addCountry(new Country("PER", "Peru", 33000000, 1285216.0));
            addCountry(new Country("BRA", "Brazil", 214000000, 8515767.0));
        } catch (Exception e) {
            System.err.println("Error seeding initial data: " + e.getMessage());
        }
    }
}

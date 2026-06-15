package ec.edu.espe.countrymanager.model;

public class Country {
    private String id;
    private String name;
    private long population;
    private double area;

    public Country(String id, String name, long population, double area) {
        this.id = id;
        this.name = name;
        this.population = population;
        this.area = area;
    }


    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public long getPopulation() { return population; }
    public void setPopulation(long population) { this.population = population; }

    public double getArea() { return area; }
    public void setArea(double area) { this.area = area; }


    public double getPopulationDensity() {
        if (area <= 0) {
            return 0.0;
        }
        return (double) population / area;
    }

    @Override
    public String toString() {
        return id + "," + name + "," + population + "," + area;
    }

    public static Country fromString(String line) {
        String[] parts = line.split(",");
        if (parts.length == 4) {
            String id = parts[0].trim();
            String name = parts[1].trim();
            long population = Long.parseLong(parts[2].trim());
            double area = Double.parseDouble(parts[3].trim());
            return new Country(id, name, population, area);
        }
        return null;
    }
}

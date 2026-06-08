package ec.edu.espe.productweight.model;

/**
 *
 * @author Daniel Codena, CodeBreakers, @ESPE
 */
public class Product {

    private String name;
    private double weightPounds;

    public Product(
            String name,
            double weightPounds
    ) {

        this.name = name;
        this.weightPounds = weightPounds;
    }

    public String getName() {

        return name;
    }

    public double getWeightPounds() {

        return weightPounds;
    }
}
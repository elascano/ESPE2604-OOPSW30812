package ec.edu.espe.singleton;

/**
 *
 * @author Andres Sanchez
 */
public class TaxCalculator {

    public static void main(String[] args) {

        Tax tax = Tax.getInstance();

        tax.updateTaxPercentage(15.0f);

        float sale = 100.0f;

        System.out.println("Sale: $" + sale);
        System.out.println("Tax Percentage: " + tax.getPercentage() + "%");
        System.out.println("Total: $" + tax.salesTotal(sale));
    }

}
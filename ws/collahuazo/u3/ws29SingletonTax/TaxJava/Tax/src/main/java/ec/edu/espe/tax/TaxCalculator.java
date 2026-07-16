package ec.edu.espe.tax;

/**
 *
 * @author Collahuazo Brandon, CodeBros,@ESPE
 */
public class TaxCalculator {

    public static void main(String[] args) {

        Tax tax = Tax.getInstance();

        float percentage = 0.15F;
        float price = 100.0F;

        tax.updateTaxPercentage(percentage);

        float total = tax.salesTotal(price);

        System.out.printf("Tax percentage: %.2f%%\n", tax.getPercentage() * 100);
        System.out.printf("Original price: $%.2f\n", price);
        System.out.printf("Total price: $%.2f\n", total);
    }
}

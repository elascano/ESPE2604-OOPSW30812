package ec.edu.espe.productweight.view;

/**
 *
 * @author Daniel Codena, CodeBreakers, @ESPE
 */
import java.util.List;
import java.util.Map;

public class ProductView {

    public void showMenu() {

        System.out.println(
                "\n===== STORE SYSTEM ====="
        );

        System.out.println(
                "1. Add products and save to JSON"
        );

        System.out.println(
                "2. Read JSON and show weights in kilograms"
        );

        System.out.println(
                "3. Exit"
        );
    }

    public void showMessage(String message) {

        System.out.println(message);
    }

    public void showProducts(
            List<Map<String, Object>> products
    ) {

        System.out.println(
                "\n=== PRODUCTS IN KILOGRAMS ==="
        );

        for (Map<String, Object> product : products) {

            System.out.println(
                    "Name: "
                    + product.get("name")
                    + " | Kilograms: "
                    + String.format(
                            "%.2f",
                            product.get("weightKilograms")
                    )
                    + " kg"
            );
        }
    }
}
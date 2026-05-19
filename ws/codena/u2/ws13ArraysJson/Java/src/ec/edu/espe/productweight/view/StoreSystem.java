package ec.edu.espe.productweight.view;

/**
 *
 * @author Daniel Codena, CodeBreakers, @ESPE
 */

import ec.edu.espe.productweight.controller.ProductController;
import java.util.Scanner;

public class StoreSystem {

    public static void main(String[] args) {

        ProductView view =
                new ProductView();

        ProductController controller =
                new ProductController(view);

        Scanner scanner =
                new Scanner(System.in);

        int option;

        do {

            view.showMenu();

            System.out.print(
                    "\nChoose an option: "
            );

            option =
                    scanner.nextInt();

            scanner.nextLine();

            switch (option) {

                case 1:

                    System.out.print(
                            "Enter product name: "
                    );

                    String name =
                            scanner.nextLine();

                    System.out.print(
                            "Enter weight in pounds: "
                    );

                    double weight =
                            scanner.nextDouble();

                    scanner.nextLine();

                    controller.addProduct(
                            name,
                            weight
                    );

                    controller.saveProductsToJSON();

                    break;

                case 2:

                    controller
                            .readProductsAndConvert();

                    break;

                case 3:

                    System.out.println(
                            "\nProgram finished."
                    );

                    break;

                default:

                    System.out.println(
                            "\nInvalid option."
                    );
            }

        } while (option != 3);

        scanner.close();
    }
}
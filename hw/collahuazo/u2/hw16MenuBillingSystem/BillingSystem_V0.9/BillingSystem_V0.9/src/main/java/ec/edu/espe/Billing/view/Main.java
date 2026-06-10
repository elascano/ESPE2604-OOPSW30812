package ec.edu.espe.Billing.view;

import ec.edu.espe.Billing.model.Category;
import ec.edu.espe.Billing.model.Company;
import ec.edu.espe.Billing.model.Customer;
import ec.edu.espe.Billing.model.Invoice;
import ec.edu.espe.Billing.model.Payment;
import ec.edu.espe.Billing.model.Product;
import ec.edu.espe.Billing.model.Supplier;
import java.util.Scanner;
import javax.swing.SwingUtilities;

public class Main {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        System.out.println("Seleccione modo de ejecución:");
        System.out.println("1. Consola");
        System.out.println("2. Interfaz Gráfica (GUI)");
        System.out.print("Opción: ");
        
        int mode = input.nextInt();
        input.nextLine();

        if (mode == 2) {
            SwingUtilities.invokeLater(() -> new BillingVista().setVisible(true));
            return;
        }

        Company company = new Company();
        Customer customer = new Customer();
        Product product = new Product();
        Payment payment = new Payment();
        Invoice invoice = null;

        int option;

        do {
            System.out.println("\n=================================");
            System.out.println("      SISTEMA DE FACTURACION");
            System.out.println("=================================");
            System.out.println("1. Registrar Empresa");
            System.out.println("2. Registrar Cliente");
            System.out.println("3. Registrar Producto");
            System.out.println("4. Mostrar Producto");
            System.out.println("5. Realizar Venta");
            System.out.println("6. Imprimir Factura");
            System.out.println("7. Salir");
            System.out.print("Seleccione una opcion: ");

            option = input.nextInt();
            input.nextLine();

            switch (option) {

                case 1:
                    company.informationEntry();
                    break;

                case 2:
                    customer.informationEntry();
                    break;

                case 3:
                    product.informationEntry();
                    break;

                case 4:
                    product.showInformation();
                    break;

                case 5:

                    if (product.getId() == null) {
                        System.out.println("Primero registre un producto.");
                        break;
                    }

                    System.out.println("\n******** REALIZAR VENTA ********");

                    System.out.print("Ingrese numero de factura: ");
                    int invoiceNumber = input.nextInt();
                    input.nextLine();

                    System.out.print("Ingrese nombre del cajero: ");
                    String cashier = input.nextLine();

                    System.out.print("Cantidad a vender: ");
                    int quantity = input.nextInt();
                    input.nextLine();

                    if (product.reduceStock(quantity)) {

                        invoice = new Invoice(
                                invoiceNumber,
                                cashier,
                                customer.getName()
                        );

                        invoice.calculateTotals(product, quantity);

                        payment.PaymentMethod();

                        double total = invoice.getTotal();

                        System.out.println("Total a pagar: $" + total);

                        System.out.print("Dinero recibido: ");
                        double money = input.nextDouble();
                        input.nextLine();

                        payment.setMoneyPurchased(money);
                        payment.setChange(money - total);

                        System.out.println("Cambio: $" + payment.getChange());

                        System.out.println("Venta realizada correctamente.");
                    }

                    break;
                case 6:

                    if (invoice == null) {
                    System.out.println("No existe ninguna venta registrada.");
                    } else {

                    System.out.println("\n======================================");
                    System.out.println("          " + company.getCompanyName());
                    System.out.println("RUC: " + company.getCompanyId());
                    System.out.println("Direccion: " + company.getCompanyAddress());
                    System.out.println("======================================");

                    customer.showInformation();

                    System.out.print("\nIngrese nuevamente la cantidad vendida: ");
                    quantity = input.nextInt(); 
                    input.nextLine();

                    invoice.showInvoiceTicket(
                            product.getName(),
                            quantity
                    );

                    payment.showInformation();
                }

                break;

                case 7:
                    System.out.println("Gracias por utilizar el sistema.");
                    break;

                default:
                    System.out.println("Opcion invalida.");
            }

        } while (option != 7);
    }
}

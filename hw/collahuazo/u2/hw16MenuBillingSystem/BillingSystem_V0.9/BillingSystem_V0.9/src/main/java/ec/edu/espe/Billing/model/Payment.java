package ec.edu.espe.Billing.model;
import java.util.Scanner;
/**
 *
 * @author Didier Elbay  <Code_Bros , @ESPE>
 */
public class Payment {
    private double moneyPurchased,change;
    private String paymentMethod;
    
    Scanner entrada = new Scanner(System.in);


    public Payment() {
        this.moneyPurchased = 0;
        this.change = 0;
        this.paymentMethod = "";
    }

    public Payment(double moneyPurchased, double change, String paymentMethod) {
        this.moneyPurchased = moneyPurchased;
        this.change = change;
        this.paymentMethod = paymentMethod;
    }

    public double getMoneyPurchased() {
        return moneyPurchased;
    }

    public void setMoneyPurchased(double moneyPurchased) {
        this.moneyPurchased = moneyPurchased;
    }

    public double getChange() {
        return change;
    }

    public void setChange(double change) {
        this.change = change;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }
    
    public void PaymentMethod (){
        System.out.println("Seleccione el metodo de pago:");
        System.out.println("1)Efectivo");
        System.out.println("2)Tarjeta");
        System.out.println("3)Transferencia Bancaria");
        
        int option = entrada.nextInt();
        entrada.nextLine();
        
        switch(option) {
            case 1 -> paymentMethod = "Efectivo";
            case 2 -> paymentMethod = "Tarjeta";
            case 3 -> paymentMethod = "Transferencia";
            default -> paymentMethod = "Desconocido";
        }
    }

    public void informationEntry() {
        System.out.println("* * * * * * * * * * Ingreso de informacion del pago * * * * * * * * * * ");
        System.out.println("Ingrese el dinero recibido :");
        moneyPurchased = entrada.nextDouble();
        System.out.println("Ingrese el cambio :");
        change = entrada.nextDouble();
        entrada.nextLine();
        System.out.println("Ingrese el metodo de pago :");
        paymentMethod = entrada.nextLine();
    }

    public void showInformation() {
        System.out.println("* * * * * * * * * * * * Informacion del pago * * * * * * * * * * * * ");
        System.out.println("Dinero recibido : " + moneyPurchased);
        System.out.println("Cambio :" + change);
        System.out.println("Metodo de pago :" + paymentMethod);
    }
}

package ec.edu.espe.Billing.model;
import java.util.Scanner;

/**
 *
 * @author Didier Elbay  <Code_Bros , @ESPE>
 */
public class Customer {
    private String ruc;
    private String name;
    private String address;
    private String gmailCustomer; 
    // SE AGREGÓ 'private transient' PARA QUE GSON NO SE CAIGA AL LEER EL JSON
    private transient Scanner entrada = new Scanner(System.in);

    public Customer() {
        this.ruc = "";
        this.name = null;
        this.address = null;
        this.gmailCustomer = null;
    }

    public Customer(String ruc, String name, String address, String gmailCustomer) {
        this.ruc = ruc;
        this.name = name;
        this.address = address;
        this.gmailCustomer = gmailCustomer;
    }

    public String getRuc() {
        return ruc;
    }

    public void setRuc(String ruc) {
        this.ruc = ruc;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getGmailCustomer() {
        return gmailCustomer;
    }

    public void setGmailCustomer(String gmailCustomer) {
        this.gmailCustomer = gmailCustomer;
    }

    public void informationEntry() {
        System.out.println("* * * * * * * * * * Ingreso de informacion del cliente * * * * * * * * * * ");
        System.out.println("Ingrese el RUC del cliente :");
        ruc = entrada.nextLine();
        System.out.println("Ingrese el nombre del cliente :");
        name = entrada.nextLine();
        System.out.println("Ingrese la direccion del cliente :");
        address = entrada.nextLine();
        System.out.println("Ingrese el gmail del cliente :");
        gmailCustomer = entrada.nextLine();
    }

    public void showInformation() {
        System.out.println("* * * * * * * * * * * * Informacion del cliente " + ruc + " * * * * * * * * * * * * ");
        System.out.println("Nombre del cliente : " + name);
        System.out.println("RUC del cliente :" + ruc);
        System.out.println("Direccion del cliente :" + address);
        System.out.println("Gmail del cliente :" + gmailCustomer);
    }
}

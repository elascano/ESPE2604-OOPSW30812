package ec.edu.espe.Billing.model;
import java.util.Scanner;

/**
 *
 * @author Christopher Lomas,CodeBros,ESPE
 */
public class Supplier {
    private String ruc;
    private String companyName;
    private String address;
    private String phone;
    private String email;
    Scanner entrada = new Scanner(System.in);

    public Supplier() {
    }

    public Supplier(String ruc, String companyName, String address, String phone, String email) {
        this.ruc = ruc;
        this.companyName = companyName;
        this.address = address;
        this.phone = phone;
        this.email = email;
    }

    public String getRuc() {
        return ruc;
    }

    public void setRuc(String ruc) {
        this.ruc = ruc;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Supplier{" + "ruc=" + ruc + ", companyName=" + companyName + ", address=" + address + ", phone=" + phone + ", email=" + email + '}';
    }

    public void informationEntry() {
        System.out.println("* * * * * * * * * * Ingreso de informacion del proveedor * * * * * * * * * * ");
        System.out.println("Ingrese el RUC del proveedor :");
        ruc = entrada.nextLine();
        System.out.println("Ingrese el nombre de la empresa :");
        companyName = entrada.nextLine();
        System.out.println("Ingrese la direccion del proveedor :");
        address = entrada.nextLine();
        System.out.println("Ingrese el telefono del proveedor :");
        phone = entrada.nextLine();
        System.out.println("Ingrese el email del proveedor :");
        email = entrada.nextLine();
    }

    public void showInformation() {
        System.out.println("* * * * * * * * * * * * Informacion del proveedor " + ruc + " * * * * * * * * * * * * ");
        System.out.println("Nombre de la empresa : " + companyName);
        System.out.println("RUC :" + ruc);
        System.out.println("Direccion :" + address);
        System.out.println("Telefono :" + phone);
        System.out.println("Email :" + email);
    }
}

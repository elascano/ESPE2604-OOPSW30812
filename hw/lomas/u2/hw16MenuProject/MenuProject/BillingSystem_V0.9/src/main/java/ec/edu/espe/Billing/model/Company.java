package ec.edu.espe.Billing.model;
import java.util.Scanner;

/**
 *
 * @author Didier Elbay  <Code_Bros , @ESPE>
 */
public class Company {
    private String companyName,companyId,companyAddress;
    Scanner entrada = new Scanner(System.in);

    public Company() {
        this.companyName = null;
        this.companyId = null;
        this.companyAddress = null;
    }

    public Company(String companyName, String companyId, String companyAddress) {
        this.companyName = companyName;
        this.companyId = companyId;
        this.companyAddress = companyAddress;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getCompanyId() {
        return companyId;
    }

    public void setCompanyId(String companyId) {
        this.companyId = companyId;
    }

    public String getCompanyAddress() {
        return companyAddress;
    }

    public void setCompanyAddress(String companyAddress) {
        this.companyAddress = companyAddress;
    }

    public void informationEntry() {
        System.out.println("* * * * * * * * * * Ingreso de informacion de la empresa * * * * * * * * * * ");
        System.out.println("Ingrese el id de la empresa :");
        companyId = entrada.nextLine();
        System.out.println("Ingrese el nombre de la empresa :");
        companyName = entrada.nextLine();
        System.out.println("Ingrese la direccion de la empresa :");
        companyAddress = entrada.nextLine();
    }

    public void showInformation() {
        System.out.println("* * * * * * * * * * * * Informacion de la empresa " + companyId + " * * * * * * * * * * * * ");
        System.out.println("Nombre de la empresa : " + companyName);
        System.out.println("ID de la empresa :" + companyId);
        System.out.println("Direccion de la empresa :" + companyAddress);
    }
}

package ec.edu.espe.Billing.model;
import java.util.Scanner;

/**
 *
 * @author Christopher Lomas, <Code_Bros , @ESPE>
 */
public class Cashier {
    private String id;
    private String name;
    private String userName;
    private String password;
    Scanner entrada = new Scanner(System.in);

    public Cashier() {
    }

    public Cashier(String id, String name, String userName, String password) {
        this.id = id;
        this.name = name;
        this.userName = userName;
        this.password = password;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "Cashier{" + "id=" + id + ", name=" + name + ", userName=" + userName + '}';
    }

    public void informationEntry() {
        System.out.println("* * * * * * * * * * Ingreso de informacion del cajero * * * * * * * * * * ");
        System.out.println("Ingrese el id del cajero :");
        id = entrada.nextLine();
        System.out.println("Ingrese el nombre del cajero :");
        name = entrada.nextLine();
        System.out.println("Ingrese el nombre de usuario :");
        userName = entrada.nextLine();
        System.out.println("Ingrese la contraseña :");
        password = entrada.nextLine();
    }

    public void showInformation() {
        System.out.println("* * * * * * * * * * * * Informacion del cajero " + id + " * * * * * * * * * * * * ");
        System.out.println("Nombre del cajero : " + name);
        System.out.println("ID del cajero :" + id);
        System.out.println("Nombre de usuario :" + userName);
    }
}

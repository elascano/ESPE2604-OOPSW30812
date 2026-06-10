package ec.edu.espe.Billing.model;
import java.util.Scanner;

/**
 *
 * @author Christopher Lomas
 */
public class Person {
    private String id;
    private String name;
    private String lastName;
    private String address;
    private String phone;
    Scanner entrada = new Scanner(System.in);

    public Person() {
    }

    public Person(String id, String name, String lastName, String address, String phone) {
        this.id = id;
        this.name = name;
        this.lastName = lastName;
        this.address = address;
        this.phone = phone;
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

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
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

    @Override
    public String toString() {
        return "Person{" + "id=" + id + ", name=" + name + ", lastName=" + lastName + ", address=" + address + ", phone=" + phone + '}';
    }

    public void informationEntry() {
        System.out.println("* * * * * * * * * * Ingreso de informacion de la persona * * * * * * * * * * ");
        System.out.println("Ingrese el id de la persona :");
        id = entrada.nextLine();
        System.out.println("Ingrese el nombre de la persona :");
        name = entrada.nextLine();
        System.out.println("Ingrese el apellido de la persona :");
        lastName = entrada.nextLine();
        System.out.println("Ingrese la direccion de la persona :");
        address = entrada.nextLine();
        System.out.println("Ingrese el telefono de la persona :");
        phone = entrada.nextLine();
    }

    public void showInformation() {
        System.out.println("* * * * * * * * * * * * Informacion de la persona " + id + " * * * * * * * * * * * * ");
        System.out.println("Nombre : " + name);
        System.out.println("Apellido : " + lastName);
        System.out.println("ID :" + id);
        System.out.println("Direccion :" + address);
        System.out.println("Telefono :" + phone);
    }
}

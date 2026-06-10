package ec.edu.espe.Billing.model;
import java.util.Scanner;

/**
 *
 * @author Christopher Lomas,  <Code_Bros , @ESPE>
 */
public class Category {
    private String id;
    private String name;
    private String description;
    Scanner entrada = new Scanner(System.in);

    public Category() {
    }

    public Category(String id, String name, String description) {
        this.id = id;
        this.name = name;
        this.description = description;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Category{" + "id=" + id + ", name=" + name + ", description=" + description + '}';
    }

    public void informationEntry() {
        System.out.println("* * * * * * * * * * Ingreso de informacion de la categoria * * * * * * * * * * ");
        System.out.println("Ingrese el id de la categoria :");
        id = entrada.nextLine();
        System.out.println("Ingrese el nombre de la categoria :");
        name = entrada.nextLine();
        System.out.println("Ingrese la descripcion de la categoria :");
        description = entrada.nextLine();
    }

    public void showInformation() {
        System.out.println("* * * * * * * * * * * * Informacion de la categoria " + id + " * * * * * * * * * * * * ");
        System.out.println("Nombre de la categoria : " + name);
        System.out.println("ID de la categoria :" + id);
        System.out.println("Descripcion :" + description);
    }
}

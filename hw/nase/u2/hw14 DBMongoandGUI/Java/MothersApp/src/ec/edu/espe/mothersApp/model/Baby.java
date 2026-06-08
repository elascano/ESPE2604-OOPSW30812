package ec.edu.espe.mothersApp.model;
import java.util.Date;

/**
 * @author Jennyfer Nase, Error 404, @ESPE
 */
public class Baby {

    public String firstName;
    public String lastName;
    public String id;
    public int weight;
    public int height;
    public String birthDate;
    public boolean born;

    public int gestationPeriod;
    public int months;

    public Baby(String firstName,
                String lastName,
                String id,
                int weight,
                int height,
                String birthDate,
                boolean born) {

        this.firstName = firstName;
        this.lastName = lastName;
        this.id = id;
        this.weight = weight;
        this.height = height;
        this.birthDate = birthDate;
        this.born = born;

        this.gestationPeriod = 0;
        this.months = 0;
    }
}
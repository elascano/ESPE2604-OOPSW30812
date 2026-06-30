package ec.edu.espe.oopconcepts.model;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import org.bson.Document;

/**
 *
 * @author Alexander Tipantiza, The Softwarrios, @ESPE
 */
public class Sheep extends FarmAnimal {

    private LocalDate lastShearing;

    public Sheep(int id, String breed, LocalDate bornOnDate, float weight, LocalDate lastShearing) {
        super(id, breed, bornOnDate, weight);
        this.lastShearing = lastShearing;
    }

    @Override
    public Document toDocument() {
        Document document = new Document();

        document.append("_id", getId());
        document.append("type", "Sheep");
        document.append("breed", getBreed());
        Date date = Date.from(getBornOnDate().atStartOfDay(ZoneId.systemDefault()).toInstant());
        document.append("bornOnDate", date);
        document.append("weight", getWeight());

        Date lastShearingDate = Date.from(getLastShearing().atStartOfDay(ZoneId.systemDefault()).toInstant());
        document.append("lastShearing", lastShearingDate);

        return document;
    }

    @Override
    public boolean feed(Food food) {
        String typeOfFood = food.getTypeOfFood();
        
        boolean canFeed = !typeOfFood.equals("Corn");
        
        if(canFeed){
            weight++;
        }
        return canFeed;
    }

    public LocalDate getLastShearing() {
        return lastShearing;
    }

    public void setLastShearing(LocalDate lastShearing) {
        this.lastShearing = lastShearing;
    }

}

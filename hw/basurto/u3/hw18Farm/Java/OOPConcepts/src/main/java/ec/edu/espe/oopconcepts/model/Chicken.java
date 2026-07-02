package ec.edu.espe.oopconcepts.model;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import org.bson.Document;

/**
 *
 * @author Daniel Codena, CodeBreakers, @ESPE
 */
public class Chicken extends FarmAnimal {

    private boolean isMolting;
    private int numberOfEggs;

    public Chicken(int id, String breed, LocalDate bornOnDate, float weight, boolean isMolting, int numberOfEggs) {
        super(id, breed, bornOnDate, weight);
        this.isMolting = isMolting;
        this.numberOfEggs = numberOfEggs;
    }

    public boolean layAnEgg() {
        if (!isMolting) {
            numberOfEggs = numberOfEggs + 1;
        }
        return isMolting;
    }

    @Override
    public Document toDocument() {

        Document document = new Document();

        document.append("_id", getId());
        document.append("type", "Chicken");
        document.append("breed", getBreed());

        Date date = Date.from(getBornOnDate().atStartOfDay(ZoneId.systemDefault()).toInstant());
        document.append("bornOnDate", date);

        document.append("weight", getWeight());

        document.append("isMolting", isMolting());
        document.append("numberOfEggs", getNumberOfEggs());

        return document;
    }

    @Override
    public boolean feed(Food food) {
        String typeOfFood = food.getTypeOfFood();

        boolean canFeed = typeOfFood.equals("Corn") || typeOfFood.equals("Mixed Feed");

        if (canFeed) {
            weight++;
        }
        return canFeed;
    }

    public boolean isMolting() {
        return isMolting;
    }

    public void setIsMolting(boolean isMolting) {
        this.isMolting = isMolting;
    }

    public int getNumberOfEggs() {
        return numberOfEggs;
    }

    public void setNumberOfEggs(int numberOfEggs) {
        this.numberOfEggs = numberOfEggs;
    }

}

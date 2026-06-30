package ec.edu.espe.oopconcepts.model;

import ec.edu.espe.oopconcepts.controller.IMeatAnimal;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import org.bson.Document;

/**
 *
 * @author Alexander Tipantiza, The Softwarrios, @ESPE
 */
public class Cow extends FarmAnimal implements IMeatAnimal {

    private boolean isProducingMilk;

    public Cow(int id, String breed, LocalDate bornOnDate, float weight, boolean isProducingMilk) {
        super(id, breed, bornOnDate, weight);
        this.isProducingMilk = isProducingMilk;
    }

    @Override
    public String toString() {
        return "Cow " + String.valueOf(id) + " produced " + String.valueOf(milk()) + "L of milk";
    }

    public float milk() {
        float quantityOfMilk;

        if (isProducingMilk) {
            quantityOfMilk = weight / 100;
        } else {
            quantityOfMilk = 0;
        }
        return quantityOfMilk;
    }

    @Override
    public Document toDocument() {
        Document document = new Document();

        document.append("_id", getId());
        document.append("type", "Cow");
        document.append("breed", getBreed());

        Date date = Date.from(getBornOnDate().atStartOfDay(ZoneId.systemDefault()).toInstant());
        document.append("bornOnDate", date);

        document.append("weight", getWeight());
        document.append("isProducingMilk", isIsProducingMilk());

        return document;
    }

    @Override
    public ArrayList<Cut> cut() {

        ArrayList<Cut> cuts = new ArrayList<>();

        cuts.add(new Cut(id, "Rib", "Cow", 12F));
        cuts.add(new Cut(id, "Loin", "Cow", 16.8F));
        cuts.add(new Cut(id, "Brisket", "Cow", 9.5F));

        return cuts;
    }

    @Override
    public boolean feed(Food food) {
        String typeOfFood = food.getTypeOfFood();

        boolean canFeed = !typeOfFood.equals("Corn");

        if (canFeed) {
            weight++;
        }
        return canFeed;
    }

    @Override
    public void sendToSlaughterHouse(SlaughterHouse slaughterHouse) {
        System.out.println("Seeding cow");
    }

    public boolean isIsProducingMilk() {
        return isProducingMilk;
    }

    public void setIsProducingMilk(boolean isProducingMilk) {
        this.isProducingMilk = isProducingMilk;
    }

}

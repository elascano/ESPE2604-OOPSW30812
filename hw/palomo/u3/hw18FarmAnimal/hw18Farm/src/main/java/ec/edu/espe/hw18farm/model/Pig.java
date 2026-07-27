/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package ec.edu.espe.hw18farm.model;

import ec.edu.espe.hw18farm.controller.IMeatAnimal;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import org.bson.Document;
/**
 *
 * @author Cristian Palomo, Error 404, @ESPE
 */
public class Pig extends FarmAnimal implements IMeatAnimal{
    private float idealWeight;

    public Pig(int id, String breed, LocalDate bornOnDate, float weight, float idealWeight) {
        super(id, breed, bornOnDate, weight);
        this.idealWeight = idealWeight;
    }

    public boolean sendToButcher() {

        boolean canSendToButcher = (getWeight() >= idealWeight);
        return canSendToButcher;
    }

    @Override
    public Document toDocument() {
        Document document = new Document();

        document.append("_id", getId());
        document.append("type", "Pig");
        document.append("breed", getBreed());
        Date date = Date.from(getBornOnDate().atStartOfDay(ZoneId.systemDefault()).toInstant());
        document.append("bornOnDate", date);
        document.append("weight", getWeight());
        document.append("idealWeight", getIdealWeight());

        return document;
    }

    @Override
    public boolean feed(Food food) {
        String typeOfFood = food.getTypeOfFood();
        
        boolean canFeed = typeOfFood.equals("Corn") || typeOfFood.equals("Mixed Feed");
        
        if(canFeed){
            weight++;
        }
        return canFeed;
    }

    @Override
    public ArrayList<Cut> cut() {

        ArrayList<Cut> cuts = new ArrayList<>();

        if (!sendToButcher()) {
            return cuts;
        }

        cuts.add(new Cut(id, "Ham", "Pig", 12F));
        cuts.add(new Cut(id, "Bacon", "Pig", 8F));
        cuts.add(new Cut(id, "Ribs", "Pig", 6.5F));

        return cuts;
    }

    @Override
    public void sendToSlaughterHouse(SlaughterHouse slaughterHouse) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public float getIdealWeight() {
        return idealWeight;
    }

    public void setIdealWeight(float idealWeight) {
        this.idealWeight = idealWeight;
    }
}

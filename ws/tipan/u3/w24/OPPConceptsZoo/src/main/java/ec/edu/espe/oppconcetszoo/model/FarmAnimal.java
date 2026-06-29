package ec.edu.espe.oppconcetszoo.model;

public abstract class FarmAnimal {

    private int id;
    private String breed;
    private Date bornOn;
    private float weight;

    public FarmAnimal(int id, String breed, Date bornOn, float weight) {
        this.id = id;
        this.breed = breed;
        this.bornOn = bornOn;
        this.weight = weight;
    }

    public int getAgeInMonths() {
        return 1;
    }

    public void feed(Food food) {
        System.out.println(breed + " is eating " + food.getDescription());
    }

    public abstract void born();

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getBreed() {
        return breed;
    }

    public void setBreed(String breed) {
        this.breed = breed;
    }

    public Date getBornOn() {
        return bornOn;
    }

    public void setBornOn(Date bornOn) {
        this.bornOn = bornOn;
    }

    public float getWeight() {
        return weight;
    }

    public void setWeight(float weight) {
        this.weight = weight;
    }

}
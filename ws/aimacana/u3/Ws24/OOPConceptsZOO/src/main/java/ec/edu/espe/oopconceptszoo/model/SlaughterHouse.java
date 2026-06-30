package ec.edu.espe.oopconceptszoo.model;

public class SlaughterHouse {
    public void processAnimal(FarmAnimal animal) {
        System.out.println("Processing " + animal.getBreed() + " at the slaughterhouse.");
    }
}

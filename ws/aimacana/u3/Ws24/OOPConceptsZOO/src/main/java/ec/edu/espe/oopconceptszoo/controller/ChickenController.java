package ec.edu.espe.oopconceptszoo.controller;

import ec.edu.espe.oopconceptszoo.database.ChickenDAO;
import ec.edu.espe.oopconceptszoo.model.Chicken;
import java.util.List;

public class ChickenController {
    private final ChickenDAO chickenDAO;

    public ChickenController() {
        this.chickenDAO = new ChickenDAO();
    }

    public void addChicken(Chicken chicken) {
        chickenDAO.save(chicken);
    }

    public List<Chicken> getAllChickens() {
        return chickenDAO.getAll();
    }
}

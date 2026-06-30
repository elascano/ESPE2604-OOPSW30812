package ec.edu.espe.oopconceptszoo.controller;

import ec.edu.espe.oopconceptszoo.database.SheepDAO;
import ec.edu.espe.oopconceptszoo.model.Sheep;
import java.util.List;

public class SheepController {
    private final SheepDAO sheepDAO;

    public SheepController() {
        this.sheepDAO = new SheepDAO();
    }

    public void addSheep(Sheep sheep) {
        sheepDAO.save(sheep);
    }

    public List<Sheep> getAllSheeps() {
        return sheepDAO.getAll();
    }
}

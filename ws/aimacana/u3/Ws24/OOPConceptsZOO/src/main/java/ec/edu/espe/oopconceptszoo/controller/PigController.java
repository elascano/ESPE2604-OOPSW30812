package ec.edu.espe.oopconceptszoo.controller;

import ec.edu.espe.oopconceptszoo.database.PigDAO;
import ec.edu.espe.oopconceptszoo.model.Pig;
import java.util.List;

public class PigController {
    private final PigDAO pigDAO;

    public PigController() {
        this.pigDAO = new PigDAO();
    }

    public void addPig(Pig pig) {
        pigDAO.save(pig);
    }

    public List<Pig> getAllPigs() {
        return pigDAO.getAll();
    }
}

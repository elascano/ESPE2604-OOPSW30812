package ec.edu.espe.oopconceptszoo.controller;

import ec.edu.espe.oopconceptszoo.database.CowDAO;
import ec.edu.espe.oopconceptszoo.model.Cow;
import java.util.List;

public class CowController {
    private final CowDAO cowDAO;

    public CowController() {
        this.cowDAO = new CowDAO();
    }

    public void addCow(Cow cow) {
        cowDAO.save(cow);
    }

    public List<Cow> getAllCows() {
        return cowDAO.getAll();
    }
}

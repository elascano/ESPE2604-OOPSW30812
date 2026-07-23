package ec.edu.espe.oppconcetszoo.model;

import java.util.ArrayList;

public class SlaughterHouse {

    private String name;
    private ArrayList<Cut> cuts;

    public SlaughterHouse(String name) {
        this.name = name;
        this.cuts = new ArrayList<>();
    }

    public void addCut(Cut cut) {
        cuts.add(cut);
    }

    public String getName() {
        return name;
    }

    public ArrayList<Cut> getCuts() {
        return cuts;
    }

}
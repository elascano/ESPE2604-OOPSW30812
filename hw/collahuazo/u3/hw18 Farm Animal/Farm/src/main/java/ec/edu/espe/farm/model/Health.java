package ec.edu.espe.farm.model;

import java.util.Date;

/**
 * @author Collahuazo Brandon, CodeBros, @ESPE
 */
public class Health {

    private boolean hasAllVaccines;
    private Date lastCheckup;

 
    public Health() {
    }

    
    public Health(boolean hasAllVaccines, Date lastCheckup) {
        this.hasAllVaccines = hasAllVaccines;
        this.lastCheckup = lastCheckup;
    }

    
    
    public boolean isFitForProduction() {
      return this.hasAllVaccines;
    }

    

    public boolean isHasAllVaccines() {
        return hasAllVaccines;
    }

    public void setHasAllVaccines(boolean hasAllVaccines) {
        this.hasAllVaccines = hasAllVaccines;
    }

    public Date getLastCheckup() {
        return lastCheckup;
    }

    public void setLastCheckup(Date lastCheckup) {
        this.lastCheckup = lastCheckup;
    }
}
package ec.edu.espe.parks.view;

import ec.edu.espe.parks.controller.ParkController;
import ec.edu.espe.parks.model.Park;

public class Parks {
    public static void main(String[] args) {
   
        Park model = new Park();
        
       
        FrmPark view = new FrmPark();
        
       
        ParkController controller = new ParkController(view, model);
        
      
        view.setVisible(true);
    }
}
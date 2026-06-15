package ec.edu.espe.parks.controller;

import ec.edu.espe.parks.model.Park;
import ec.edu.espe.parks.view.FrmPark;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

public class ParkController {
    private FrmPark view;
    private Park model;

    public ParkController(FrmPark view, Park model) {
        this.view = view;
        this.model = model;

        this.view.getBtnSave().addActionListener(new SaveButtonListener());
        this.view.getBtnClear().addActionListener(new ClearButtonListener());
    }

    private class SaveButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                
                String id = view.getTxtId().getText().trim();
                String name = view.getTxtName().getText().trim();
                
                if(id.isEmpty() || name.isEmpty()) {
                    JOptionPane.showMessageDialog(view, "Fields cannot be empty.");
                    return;
                }
                
                double area = Double.parseDouble(view.getTxtArea().getText());
                int capacity = Integer.parseInt(view.getTxtCapacity().getText());

                
                model.setId(id);
                model.setName(name);
                model.setArea(area);
                model.setVisitorCapacity(capacity);

             
                double density = model.computeDensity();
                view.getTxtDensityResult().setText(String.format("%.2f m²/person", density));

               
                boolean databaseSaved = model.saveToMongoDB();

                if (databaseSaved) {
                    JOptionPane.showMessageDialog(view, "Success:\nData computed and successfully sent to MongoDB Atlas!");
                } else {
                    JOptionPane.showMessageDialog(view, "Warning:\nDensity computed locally, but database connection failed.\nCheck your URI string.");
                }

            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(view, "Input Error: Please ensure Area and Capacity are numeric.");
            }
        }
    }

    private class ClearButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            view.getTxtId().setText("");
            view.getTxtName().setText("");
            view.getTxtArea().setText("");
            view.getTxtCapacity().setText("");
            view.getTxtDensityResult().setText("");
            
            model.setId("");
            model.setName("");
            model.setArea(0.0);
            model.setVisitorCapacity(0);
        }
    }
}
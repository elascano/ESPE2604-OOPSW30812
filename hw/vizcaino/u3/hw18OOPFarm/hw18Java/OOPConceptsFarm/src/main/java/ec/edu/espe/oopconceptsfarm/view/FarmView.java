/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.espe.oopconceptsfarm.view;

/**
 *
 * @author Adrian Vizcaino <The-Softwarriors at ESPE>
 */
import ec.edu.espe.oopconceptsfarm.controller.FarmController;
import ec.edu.espe.oopconceptsfarm.model.*;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.Calendar;
import java.util.Date;

public class FarmView extends JFrame {

    private JTable tblAnimals;
    private FarmController controller;

    public FarmView(FarmController controller) {
        this.controller = controller;

        setTitle("Farm Management System");
        setSize(1000, 600);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        initializeComponents();
    }

    private Date ageToDate(int months){
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.MONTH,-months);
        return calendar.getTime();
    }

private void initializeComponents() {

    setLayout(new BorderLayout());

    JMenuBar menuBar = new JMenuBar();

    JMenu menuAnimals = new JMenu("Animals");
    JMenu menuActions = new JMenu("Actions");
    JMenu menuCrud = new JMenu("CRUD");

    JMenuItem searchAnimal =
            new JMenuItem("Search Animal");

    JMenuItem deleteAnimal =
            new JMenuItem("Delete Animal");

    JMenuItem addPig =
            new JMenuItem("Add Pig");

    JMenuItem addCow =
            new JMenuItem("Add Cow");

    JMenuItem addChicken =
            new JMenuItem("Add Chicken");

    JMenuItem addSheep =
            new JMenuItem("Add Sheep");

    JMenuItem feedAnimal =
            new JMenuItem("Feed Animal");

    JMenuItem layEggs =
            new JMenuItem("Chicken - Lay Eggs");

    JMenuItem milkCow =
            new JMenuItem("Cow - Milk");

    JMenuItem processPig =
            new JMenuItem("Pig - Process Meat");

    JMenuItem shearSheep =
            new JMenuItem("Sheep - Shear Wool");

    menuAnimals.add(addPig);
    menuAnimals.add(addCow);
    menuAnimals.add(addChicken);
    menuAnimals.add(addSheep);

    menuActions.add(feedAnimal);
    menuActions.add(layEggs);
    menuActions.add(milkCow);
    menuActions.add(processPig);
    menuActions.add(shearSheep);

    menuCrud.add(searchAnimal);
    menuCrud.add(deleteAnimal);

    menuBar.add(menuAnimals);
    menuBar.add(menuActions);
    menuBar.add(menuCrud);

    setJMenuBar(menuBar);

    tblAnimals = new JTable();

    add(
            new JScrollPane(tblAnimals),
            BorderLayout.CENTER);

    addPig.addActionListener(
            e -> addPig());

    addCow.addActionListener(
            e -> addCow());

    addChicken.addActionListener(
            e -> addChicken());

    addSheep.addActionListener(
            e -> addSheep());

    feedAnimal.addActionListener(
            e -> feedAnimal());

    layEggs.addActionListener(
            e -> layEggs());

    milkCow.addActionListener(
            e -> milkCow());

    processPig.addActionListener(
            e -> processPig());

    shearSheep.addActionListener(
            e -> shearSheep());

    searchAnimal.addActionListener(
            e -> searchAnimal());

    deleteAnimal.addActionListener(
            e -> deleteAnimal());

    refreshTable();
}

    private void addPig() {
        try {
            int id=Integer.parseInt(JOptionPane.showInputDialog(this,"Pig ID"));
            String breed=JOptionPane.showInputDialog(this,"Breed");
            float weight=Float.parseFloat(JOptionPane.showInputDialog(this,"Weight"));
            int age=Integer.parseInt(JOptionPane.showInputDialog(this,"Age In Months"));
            float ideal=Float.parseFloat(JOptionPane.showInputDialog(this,"Ideal Weight"));
            int pen=Integer.parseInt(JOptionPane.showInputDialog(this,"Pen Number"));

            Pig pig=new Pig(id,breed,ageToDate(age),weight,"Healthy",ideal,pen);
            controller.addAnimal(pig);
            refreshTable();
        } catch(Exception ex){}
    }

    private void addCow() {
        try {
            int id=Integer.parseInt(JOptionPane.showInputDialog(this,"Cow ID"));
            String breed=JOptionPane.showInputDialog(this,"Breed");
            float weight=Float.parseFloat(JOptionPane.showInputDialog(this,"Weight"));
            int age=Integer.parseInt(JOptionPane.showInputDialog(this,"Age In Months"));
            boolean producing=Boolean.parseBoolean(JOptionPane.showInputDialog(this,"Producing Milk? true/false"));
            float yield=Float.parseFloat(JOptionPane.showInputDialog(this,"Daily Milk Yield"));

            Cow cow=new Cow(id,breed,ageToDate(age),weight,"Healthy",producing,yield);
            controller.addAnimal(cow);
            refreshTable();
        } catch(Exception ex){}
    }

    private void addChicken() {
        try {
            int id=Integer.parseInt(JOptionPane.showInputDialog(this,"Chicken ID"));
            String breed=JOptionPane.showInputDialog(this,"Breed");
            float weight=Float.parseFloat(JOptionPane.showInputDialog(this,"Weight"));
            int age=Integer.parseInt(JOptionPane.showInputDialog(this,"Age In Months"));
            boolean molting=Boolean.parseBoolean(JOptionPane.showInputDialog(this,"Molting? true/false"));
            int eggs=Integer.parseInt(JOptionPane.showInputDialog(this,"Eggs Per Week"));
            String color=JOptionPane.showInputDialog(this,"Egg Color");

            Chicken chicken=new Chicken(id,breed,ageToDate(age),weight,"Healthy",molting,eggs,color);
            controller.addAnimal(chicken);
            refreshTable();
        } catch(Exception ex){}
    }

    private void addSheep() {
        try {
            int id=Integer.parseInt(JOptionPane.showInputDialog(this,"Sheep ID"));
            String breed=JOptionPane.showInputDialog(this,"Breed");
            float weight=Float.parseFloat(JOptionPane.showInputDialog(this,"Weight"));
            int age=Integer.parseInt(JOptionPane.showInputDialog(this,"Age In Months"));
            String quality=JOptionPane.showInputDialog(this,"Wool Quality");

            Sheep sheep=new Sheep(id,breed,ageToDate(age),weight,"Healthy",new Date(),quality);
            controller.addAnimal(sheep);
            refreshTable();
        } catch(Exception ex){}
    }

    private void feedAnimal() {
        int id=Integer.parseInt(JOptionPane.showInputDialog(this,"Animal ID"));
        String foodName=JOptionPane.showInputDialog(this,"Food");
        controller.feedAnimal(id,new Food(1,foodName));
        refreshTable();
    }

 private void layEggs() {

    int id =
            Integer.parseInt(
                    JOptionPane.showInputDialog(
                            this,
                            "Chicken ID"));

    FarmAnimal animal =
            controller.findAnimal(id);

    if (animal instanceof Chicken chicken) {

        int eggs =
                Integer.parseInt(
                        JOptionPane.showInputDialog(
                                this,
                                "How many eggs were laid today?"));

        chicken.setTotalEggsProduced(
                chicken.getTotalEggsProduced() + eggs);

        controller.updateAnimal(chicken);

        JOptionPane.showMessageDialog(
                this,
                "Total eggs produced: "
                + chicken.getTotalEggsProduced());
    }
}

 private void milkCow() {

    int id =
            Integer.parseInt(
                    JOptionPane.showInputDialog(
                            this,
                            "Cow ID"));

    FarmAnimal animal =
            controller.findAnimal(id);

    if (animal instanceof Cow cow) {

        float liters =
                Float.parseFloat(
                        JOptionPane.showInputDialog(
                                this,
                                "How many liters of milk were produced today?"));

        cow.addMilkProduction(liters);

        controller.updateAnimal(cow);

        JOptionPane.showMessageDialog(
                this,
                "Total milk produced: "
                + cow.getTotalMilkProduced()
                + " liters");
    }
}

private void processPig() {

    int id =
            Integer.parseInt(
                    JOptionPane.showInputDialog(
                            this,
                            "Pig ID"));

    FarmAnimal animal =
            controller.findAnimal(id);

    if (animal instanceof Pig pig) {

        float totalMeat = 0;

        StringBuilder result =
                new StringBuilder();

        for (Cut cut : pig.cut()) {

            totalMeat += cut.getWeight();

            result.append(
                    cut.getDescription())
                    .append(" - ")
                    .append(cut.getWeight())
                    .append(" kg\n");
        }

        pig.addMeatProduction(totalMeat);

        controller.updateAnimal(pig);

        result.append("\nTotal Meat Produced: ")
              .append(pig.getTotalMeatProduced())
              .append(" kg");

        JOptionPane.showMessageDialog(
                this,
                result.toString());
    }
}

private void shearSheep() {

    int id =
            Integer.parseInt(
                    JOptionPane.showInputDialog(
                            this,
                            "Sheep ID"));

    FarmAnimal animal =
            controller.findAnimal(id);

    if (animal instanceof Sheep sheep) {

        float wool =
                Float.parseFloat(
                        JOptionPane.showInputDialog(
                                this,
                                "How many kilograms of wool were obtained?"));

        sheep.shear();

        sheep.addWoolProduction(wool);

        controller.updateAnimal(sheep);

        JOptionPane.showMessageDialog(
                this,
                "Total wool produced: "
                + sheep.getTotalWoolProduced()
                + " kg");
    }
}

    private void refreshTable() {
        DefaultTableModel model=new DefaultTableModel();

        model.addColumn("ID");
        model.addColumn("Type");
        model.addColumn("Breed");
        model.addColumn("Weight");
        model.addColumn("Age(Months)");

        for(FarmAnimal animal: controller.getAnimals()){
            model.addRow(new Object[]{
                animal.getId(),
                animal.getClass().getSimpleName(),
                animal.getBreed(),
                animal.getWeight(),
                animal.getAgeInMonths()
            });
        }

        tblAnimals.setModel(model);
    }
     private void searchAnimal() {

    int id =
            Integer.parseInt(
                    JOptionPane.showInputDialog(
                            this,
                            "Animal ID"));

    FarmAnimal animal =
            controller.findAnimal(id);

    if(animal != null){

        JOptionPane.showMessageDialog(
                this,
                "ID: " + animal.getId()
                + "\nType: "
                + animal.getClass().getSimpleName()
                + "\nBreed: "
                + animal.getBreed()
                + "\nWeight: "
                + animal.getWeight()
                + "\nAge: "
                + animal.getAgeInMonths());

    } else {

        JOptionPane.showMessageDialog(
                this,
                "Animal not found");
    }
}
     private void deleteAnimal() {

    try {

        int id =
                Integer.parseInt(
                        JOptionPane.showInputDialog(
                                this,
                                "Animal ID"));

        FarmAnimal animal =
                controller.findAnimal(id);

        if(animal == null){

            JOptionPane.showMessageDialog(
                    this,
                    "Animal not found");

            return;
        }

        controller.getAnimals().remove(animal);

        refreshTable();

        JOptionPane.showMessageDialog(
                this,
                "Animal deleted");

    } catch(Exception ex){

        JOptionPane.showMessageDialog(
                this,
                "Invalid data");
    }
}
    
}


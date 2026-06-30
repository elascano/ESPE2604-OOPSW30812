package ec.edu.espe.farm.model;

/**
 * @author Collahuazo Brandon, CodeBros, @ESPE
 */
public class FarmFinances {
    
    private double totalRevenue;
    private double totalExpenses;

  
    public FarmFinances() {
        this.totalRevenue = 0.0;
        this.totalExpenses = 0.0;
    }

  
    public FarmFinances(double totalRevenue, double totalExpenses) {
        this.totalRevenue = totalRevenue;
        this.totalExpenses = totalExpenses;
    }

   
    public void processAnimalBalance(FarmAnimal animal) {
        
    }

    public double calculateNetProfit() {
        return this.totalRevenue - this.totalExpenses;
    }

  
    public double getTotalRevenue() {
        return totalRevenue;
    }

    public void setTotalRevenue(double totalRevenue) {
        this.totalRevenue = totalRevenue;
    }

    public double getTotalExpenses() {
        return totalExpenses;
    }

    public void setTotalExpenses(double totalExpenses) {
        this.totalExpenses = totalExpenses;
    }
}
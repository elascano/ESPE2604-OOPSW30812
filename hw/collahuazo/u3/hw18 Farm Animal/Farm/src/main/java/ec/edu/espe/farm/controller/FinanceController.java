package ec.edu.espe.farm.controller;
import com.mongodb.client.MongoCollection;
import ec.edu.espe.farm.model.FarmFinances;
import org.bson.Document;
import utils.MongoConnection;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Collahuazo Brandon, CodeBros, @ESPE
 */
public class FinanceController {
    
    private final MongoCollection<Document> collection;

    public FinanceController() {
    
        this.collection = MongoConnection.getDatabase().getCollection("FarmFinances");
    }

 
    public boolean saveFinances(FarmFinances finances) {
        try {
            double revenue = finances.getTotalRevenue();
            double expenses = finances.getTotalExpenses();
            double netProfit = finances.calculateNetProfit();

            Document doc = new Document()
                    .append("totalRevenue", revenue)
                    .append("totalExpenses", expenses)
                    .append("netProfit", netProfit)
                    .append("timestamp", new java.util.Date());

            collection.insertOne(doc);
            return true;
        } catch (Exception e) {
            System.err.println("X Error saving finance record: " + e.getMessage());
            return false;
        }
    }


    public List<Document> getFinanceHistory() {
        List<Document> history = new ArrayList<>();
        try {
            collection.find().into(history);
        } catch (Exception e) {
            System.err.println("X Error retrieving finance history: " + e.getMessage());
        }
        return history;
    }
}
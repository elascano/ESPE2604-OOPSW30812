
package ec.edu.espe.virtualstoreapp.data;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import ec.edu.espe.virtualstoreapp.model.Sale;
import java.io.*;
import java.lang.reflect.Type;
import java.util.ArrayList;
/**
 *
 * @author Alexander Tipantiza, The Softwarrios, @ESPE
 */
public class SaleManager {
    private static final String FILE_PATH = "sales.json";
    private static Gson gson = new GsonBuilder().setPrettyPrinting().create();

    public static void saveSales(ArrayList<Sale> sales) {
        try (Writer writer = new FileWriter(FILE_PATH)) {
            gson.toJson(sales, writer);
        } catch (IOException e) {
            System.out.println("Error saving: " + e.getMessage());
        }
    }

    public static ArrayList<Sale> loadSales() {
        File file = new File(FILE_PATH);
        if (!file.exists()) {
            return new ArrayList<>();
        }
        try (Reader reader = new FileReader(FILE_PATH)) {
            Type type = new TypeToken<ArrayList<Sale>>(){}.getType();
            return gson.fromJson(reader, type);
        } catch (IOException e) {
            return new ArrayList<>();
        }
    }
    
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.espe.mothersApp.model;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Scanner;

/**
 * Calcula semanas de gestación y fecha probable de parto (FPP).
 * Guarda resultados en MongoDB colección: gestation_records
 *
 * @author Jennyfer Nase, Error 404, @ESPE
 */
public class GestationCalculator {

    Scanner sc = new Scanner(System.in);

    public void calculateFromLMP() {
        System.out.print("Enter Date of Last Menstrual Period (YYYY-MM-DD): ");
        String lmp = sc.nextLine();
        LocalDate lmpDate = LocalDate.parse(lmp);
        long currentWeek = ChronoUnit.WEEKS.between(lmpDate, LocalDate.now());
        LocalDate dueDate = lmpDate.plusWeeks(40);
        String trimester = getTrimester((int) currentWeek);

        System.out.println("\n-------------------------------------------");
        System.out.println("RESULT: WEEK " + currentWeek + " OF PREGNANCY");
        System.out.println("TRIMESTER: " + trimester);
        System.out.println("ESTIMATED DUE DATE (FPP): " + dueDate);
    }

    public void calculateFromWeek() {
        int week;
        while (true) {
            System.out.print("Enter current week: ");
            week = sc.nextInt();
            if (week >= 1 && week <= 40) break;
            System.out.println("ERROR: Week must be between 1 and 40.");
        }
        int remainingWeeks = 40 - week;
        LocalDate dueDate = LocalDate.now().plusWeeks(remainingWeeks);
        String trimester = getTrimester(week);

        System.out.println("\n___________________________________");
        System.out.println(" RESULT: WEEK " + week + " OF PREGNANCY");
        System.out.println(" TRIMESTER: " + trimester);
        System.out.println("ESTIMATED DUE DATE (FPP): " + dueDate);
    }

    public static GestationResult calculateFromLMP(String lmpDateStr) {
        LocalDate lmpDate  = LocalDate.parse(lmpDateStr);
        int currentWeek    = (int) ChronoUnit.WEEKS.between(lmpDate, LocalDate.now());
        LocalDate dueDate  = lmpDate.plusWeeks(40);
        String trimester   = getTrimester(currentWeek);
        return new GestationResult(currentWeek, trimester, dueDate.toString(), lmpDateStr, "LMP");
    }

    public static GestationResult calculateFromWeek(int week) {
        int remainingWeeks = 40 - week;
        LocalDate dueDate  = LocalDate.now().plusWeeks(remainingWeeks);
        String trimester   = getTrimester(week);
        return new GestationResult(week, trimester, dueDate.toString(), LocalDate.now().toString(), "WEEK");
    }

    public static void saveToMongo(String motherId, GestationResult result) {
        try {
            MongoDatabase db = MongoConnection.getDatabase();
            MongoCollection<Document> col = db.getCollection("gestation_records");

            Document doc = new Document()
                .append("motherId",      motherId)
                .append("calculatedAt",  LocalDate.now().format(DateTimeFormatter.ISO_LOCAL_DATE))
                .append("method",        result.method)       // "LMP" o "WEEK"
                .append("inputDate",     result.inputDate)
                .append("currentWeek",   result.currentWeek)
                .append("trimester",     result.trimester)
                .append("estimatedDueDate", result.estimatedDueDate);

            col.insertOne(doc);
            System.out.println("✔ Gestation record saved to MongoDB.");
        } catch (Exception e) {
            System.out.println("✖ Error saving to MongoDB: " + e.getMessage());
        }
    }

    private static String getTrimester(int week) {
        if (week <= 12)  return "1st Trimester";
        else if (week <= 27) return "2nd Trimester";
        else return "3rd Trimester";
    }    
    
    public static class GestationResult {
        public int    currentWeek;
        public String trimester;
        public String estimatedDueDate;
        public String inputDate;
        public String method;

        public GestationResult(int currentWeek, String trimester,
                               String estimatedDueDate, String inputDate, String method) {
            this.currentWeek      = currentWeek;
            this.trimester        = trimester;
            this.estimatedDueDate = estimatedDueDate;
            this.inputDate        = inputDate;
            this.method           = method;
        }
    }
}
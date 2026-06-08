/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.espe.mothercsv.utils;
import ec.edu.espe.mothercsv.model.Mother;
import java.io.*;
import java.util.*;
/**
 *
 * @author Cristian
 */
public class MotherCSV {
    private static final String FILE_NAME = System.getProperty("user.home") + "\\Desktop\\mothers.csv";
    public static void saveMother(Mother mother) {
        try (FileWriter fw = new FileWriter(FILE_NAME, true);
             BufferedWriter bw = new BufferedWriter(fw);
             PrintWriter out = new PrintWriter(bw)) {
            out.println(mother.toString());
        } catch (IOException e) {
            System.out.println("Error al guardar: " + e.getMessage());
        }
    }

    public static List<Mother> readMothers() {
        List<Mother> mothers = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(FILE_NAME))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");
                Mother mother = new Mother(
                        Integer.parseInt(data[0]),
                        data[1],
                        Integer.parseInt(data[2]),
                        data[3]
                );
                mothers.add(mother);
            }
        } catch (IOException e) {
            System.out.println("Error al leer: " + e.getMessage());
        }
        return mothers;
    }
}


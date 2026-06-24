/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.espe.controller;
import ec.edu.espe.model.CellPhone;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

/**
 *
 * @author Cristian
 */
public class JsonManager {
    public static void savePhones(List<CellPhone> phones) {

        try {

            FileWriter writer =
                    new FileWriter("data/phones.json");

            writer.write("[\n");

            for (int i = 0; i < phones.size(); i++) {

                CellPhone p = phones.get(i);

                writer.write(
                        "  {\n" +
                        "    \"brand\":\"" + p.getBrand() + "\",\n" +
                        "    \"model\":\"" + p.getModel() + "\",\n" +
                        "    \"imei\":\"" + p.getImei() + "\",\n" +
                        "    \"battery\":" +
                        p.getBattery().getCapacity() + ",\n" +
                        "    \"screen\":" +
                        p.getScreen().getSize() + ",\n" +
                        "    \"operator\":\"" +
                        p.getSimCard().getOperator() + "\"\n" +
                        "  }"
                );

                if (i < phones.size() - 1) {
                    writer.write(",");
                }

                writer.write("\n");
            }

            writer.write("]");

            writer.close();

            System.out.println(
                    "\nData saved successfully.");

        } catch (IOException e) {

            System.out.println(
                    "Error saving file.");
        }
    }
}

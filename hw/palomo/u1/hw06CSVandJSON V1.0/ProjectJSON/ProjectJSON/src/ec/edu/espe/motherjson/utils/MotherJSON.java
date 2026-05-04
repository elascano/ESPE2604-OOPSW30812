/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.espe.motherjson.utils;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import ec.edu.espe.motherjson.model.Mother;
import java.io.*;
import java.lang.reflect.Type;
import java.util.*;
/**
 *
 * @author Cristian
 */
public class MotherJSON {
    private static final String FILE_NAME = System.getProperty("user.home") + "\\Desktop\\mothers.json";
    private static final Gson gson = new Gson();

    public static void saveMothers(List<Mother> mothers) {
        try (Writer writer = new FileWriter(FILE_NAME)) {
            gson.toJson(mothers, writer);
        } catch (IOException e) {
            System.out.println("Error al guardar: " + e.getMessage());
        }
    }

    public static List<Mother> readMothers() {
        List<Mother> mothers = new ArrayList<>();
        try (Reader reader = new FileReader(FILE_NAME)) {
            Type listType = new TypeToken<List<Mother>>(){}.getType();
            mothers = gson.fromJson(reader, listType);
        } catch (IOException e) {
            System.out.println("Error al leer: " + e.getMessage());
        }
        return mothers;
    }
}
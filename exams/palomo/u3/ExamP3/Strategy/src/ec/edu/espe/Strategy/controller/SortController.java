/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package ec.edu.espe.Strategy.controller;

import ec.edu.espe.Strategy.utils.MongoDBConnection;
import ec.edu.espe.Strategy.model.SortingContext;
import ec.edu.espe.Strategy.model.SortingRecord;
import ec.edu.espe.Strategy.model.SortingStrategy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @author Cristian Palomo, Error 404, @ESPE
 */
public class SortController {
    
    private final SortingContext sortingContext;

    public SortController() {
        this.sortingContext = new SortingContext();
    }

    public SortingRecord processAndSort(String inputString) throws IllegalArgumentException {
        int[] unsortedArray = parseAndValidateInput(inputString);
        int size = unsortedArray.length;

        if (size <= 1) {
            throw new IllegalArgumentException("The number of elements must be greater than 1 (Entered size: " + size + ").");
        }

        // Formateamos el texto del arreglo desordenado
        String unsortedStr = formatArrayToString(unsortedArray);

        // Seleccionamos la estrategia y ejecutamos el ordenamiento
        SortingStrategy selectedStrategy = sortingContext.setSortStrategyBasedOnSize(size);
        String algorithmName = selectedStrategy.getClass().getSimpleName();
        
        // Enviamos una copia para evitar mutar el arreglo original si se ordena in-place
        int[] sortedArray = sortingContext.sort(unsortedArray.clone());
        String sortedStr = formatArrayToString(sortedArray);

        SortingRecord record = new SortingRecord(unsortedStr, size, algorithmName, sortedStr);

        // Guardado en la base de datos
        if (!MongoDBConnection.saveSortingRecord(record)) {
            System.err.println("Warning: Result was generated locally but could not be saved to MongoDB.");
        }

        return record;
    }

    public List<SortingRecord> fetchHistory() {
        return MongoDBConnection.getAllRecords();
    }

    // --- Métodos de apoyo (Helper Methods) ---

    private int[] parseAndValidateInput(String inputString) {
        if (inputString == null || inputString.trim().isEmpty()) {
            throw new IllegalArgumentException("Please enter numeric elements separated by commas.");
        }

        List<Integer> list = new ArrayList<>();
        for (String token : inputString.split(",")) {
            String trimmed = token.trim();
            if (!trimmed.isEmpty()) {
                try {
                    list.add(Integer.parseInt(trimmed));
                } catch (NumberFormatException e) {
                    throw new IllegalArgumentException("Invalid element: '" + trimmed + "'. Please enter integers only.");
                }
            }
        }

        return list.stream().mapToInt(Integer::intValue).toArray();
    }

    private String formatArrayToString(int[] array) {
        return Arrays.toString(array).replaceAll("[\\[\\]]", "");
    }
}


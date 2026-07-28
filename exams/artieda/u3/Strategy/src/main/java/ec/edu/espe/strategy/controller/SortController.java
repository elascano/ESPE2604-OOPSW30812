package ec.edu.espe.strategy.controller;

import ec.edu.espe.strategy.model.SortingContext;
import ec.edu.espe.strategy.model.SortingRecord;
import ec.edu.espe.strategy.model.SortingStrategy;
import ec.edu.espe.strategy.utils.MongoDBConnection;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SortController {
    private final SortingContext sortingContext;

    public SortController() {
        this.sortingContext = new SortingContext();
    }

    public SortingRecord processAndSort(String inputString) throws IllegalArgumentException {
        if (inputString == null || inputString.trim().isEmpty()) {
            throw new IllegalArgumentException("Please enter numeric elements separated by commas.");
        }

        String[] tokens = inputString.split(",");
        List<Integer> list = new ArrayList<>();
        for (String token : tokens) {
            String trimmed = token.trim();
            if (!trimmed.isEmpty()) {
                try {
                    list.add(Integer.parseInt(trimmed));
                } catch (NumberFormatException e) {
                    throw new IllegalArgumentException("Invalid element: '" + trimmed + "'. Please enter integers only.");
                }
            }
        }

        int size = list.size();
        if (size <= 1) {
            throw new IllegalArgumentException("The number of elements must be greater than 1 (Entered size: " + size + ").");
        }

        int[] unsortedArray = list.stream().mapToInt(Integer::intValue).toArray();

        SortingStrategy selectedStrategy = sortingContext.setSortStrategyBasedOnSize(size);
        String algorithmName = selectedStrategy.getClass().getSimpleName();

        int[] sortedArray = sortingContext.sort(unsortedArray);

        String unsortedStr = Arrays.toString(unsortedArray).replaceAll("[\\[\\]]", "");
        String sortedStr = Arrays.toString(sortedArray).replaceAll("[\\[\\]]", "");

        SortingRecord record = new SortingRecord(unsortedStr, size, algorithmName, sortedStr);

        boolean dbSaved = MongoDBConnection.saveSortingRecord(record);
        if (!dbSaved) {
            System.err.println("Warning: Result was generated locally but could not be saved to MongoDB.");
        }

        return record;
    }

    public List<SortingRecord> fetchHistory() {
        return MongoDBConnection.getAllRecords();
    }
}

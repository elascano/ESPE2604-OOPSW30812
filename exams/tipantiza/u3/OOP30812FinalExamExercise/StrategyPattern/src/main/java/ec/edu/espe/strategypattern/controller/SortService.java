package ec.edu.espe.strategypattern.controller;

import ec.edu.espe.strategypattern.model.SortingStrategy;
import ec.edu.espe.strategypattern.utils.MongoDBConnection;
import org.bson.Document;

import java.util.Arrays;
import java.util.stream.Collectors;

/**
 *
 * @author Alexander Tipantiza, CodeBreakers, @ESPE
 */

public class SortService {
    private final SortingContext sortingContext;

    public SortService() {
        this.sortingContext = new SortingContext();
    }

    public String executeSortOperation(String rawInput) {
        if (rawInput == null || rawInput.trim().isEmpty()) {
            throw new IllegalArgumentException("Input sequence cannot be empty.");
        }

        int[] numbers = parseInput(rawInput);
        int size = numbers.length;

        if (size <= 1) {
            throw new IllegalArgumentException("Array size must be greater than 1.");
        }

        selectStrategyByRules(size);
        int[] sortedNumbers = sortingContext.sort(numbers);

        String unsortedFormatted = formatArrayToString(numbers);
        String sortedFormatted = formatArrayToString(sortedNumbers);
        String selectedAlgorithm = sortingContext.getSortStrategy().getClass().getSimpleName();

        // Persistir en MongoDB con manejo de errores
        persistSortResult(unsortedFormatted, size, selectedAlgorithm, sortedFormatted);

        return buildOutputSummary(selectedAlgorithm, size, unsortedFormatted, sortedFormatted);
    }

    private int[] parseInput(String rawInput) {
        return Arrays.stream(rawInput.split(","))
                .map(String::trim)
                .mapToInt(Integer::parseInt)
                .toArray();
    }

    private void selectStrategyByRules(int size) {
        System.out.println("Seleccionando estrategia para " + size + " elementos");
        if (size >= 2 && size <= 6) {
            sortingContext.setSortStrategy(new BubbleSort());
            System.out.println("Estrategia seleccionada: BubbleSort");
        } else if (size >= 7 && size <= 10) {
            sortingContext.setSortStrategy(new InsertionSort());
            System.out.println("Estrategia seleccionada: InsertionSort");
        } else {
            sortingContext.setSortStrategy(new QuickSort());
            System.out.println("Estrategia seleccionada: QuickSort");
        }
    }

    private void persistSortResult(String unsorted, int size, String algorithm, String sorted) {
        try {
            Document doc = new Document("unsorted", unsorted)
                    .append("size", size)
                    .append("sort algorithm", algorithm)
                    .append("sorted", sorted)
                    .append("timestamp", System.currentTimeMillis());
            MongoDBConnection.insertRecord(doc);
        } catch (Exception e) {
            System.err.println("Error al persistir en MongoDB: " + e.getMessage());
            // No lanzamos excepción para que el programa continúe
        }
    }

    private String formatArrayToString(int[] array) {
        return Arrays.stream(array)
                .mapToObj(String::valueOf)
                .collect(Collectors.joining(","));
    }

    private String buildOutputSummary(String algorithm, int size, String unsorted, String sorted) {
        return String.format("Algorithm Used: %s\nSize: %d\nUnsorted: %s\nSorted: %s",
                algorithm, size, unsorted, sorted);
    }
}
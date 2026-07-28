
package ec.edu.espe.strategypattern.controller;
import ec.edu.espe.strategypattern.model.*;
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
        if (size >= 2 && size <= 6) {
            sortingContext.setSortStrategy(new BubbleSort());
        } else if (size >= 7 && size <= 10) {
            sortingContext.setSortStrategy(new InsertionSort());
        } else {
            sortingContext.setSortStrategy(new QuickSort());
        }
    }

    private void persistSortResult(String unsorted, int size, String algorithm, String sorted) {
        Document doc = new Document("unsorted", unsorted)
                .append("size", size)
                .append("sort algorithm", algorithm)
                .append("sorted", sorted);
        MongoDBConnection.insertRecord(doc);
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
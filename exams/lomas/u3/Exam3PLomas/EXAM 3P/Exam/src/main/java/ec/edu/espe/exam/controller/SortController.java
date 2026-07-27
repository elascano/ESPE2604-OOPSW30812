package ec.edu.espe.exam.controller;

import ec.edu.espe.exam.model.NumberArray;
import ec.edu.espe.exam.model.SortingContext;

public class SortController {
    private SortingContext sortingContext;

    public SortController() {
        this.sortingContext = new SortingContext();
    }

    public NumberArray processAndSave(int[] unsortedArray) {
        int[] sortedArray = sortingContext.sort(unsortedArray);
        String algorithmName = sortingContext.getAlgorithmName();

        NumberArray numberArray = new NumberArray(unsortedArray, sortedArray, algorithmName);
        DatabaseManager.save(numberArray);

        return numberArray;
    }
}
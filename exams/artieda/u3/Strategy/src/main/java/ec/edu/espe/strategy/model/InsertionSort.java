package ec.edu.espe.strategy.model;

public class InsertionSort implements SortingStrategy {

    @Override
    public int[] sort(int[] data) {
        if (data == null) {
            return new int[0];
        }
        int[] sorted = data.clone();
        int n = sorted.length;
        for (int i = 1; i < n; i++) {
            int key = sorted[i];
            int j = i - 1;
            while (j >= 0 && sorted[j] > key) {
                sorted[j + 1] = sorted[j];
                j = j - 1;
            }
            sorted[j + 1] = key;
        }
        return sorted;
    }
}

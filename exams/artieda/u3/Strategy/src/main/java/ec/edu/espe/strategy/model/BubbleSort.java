package ec.edu.espe.strategy.model;

public class BubbleSort implements SortingStrategy {

    @Override
    public int[] sort(int[] data) {
        if (data == null) {
            return new int[0];
        }
        int[] sorted = data.clone();
        int n = sorted.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (sorted[j] > sorted[j + 1]) {
                    int temp = sorted[j];
                    sorted[j] = sorted[j + 1];
                    sorted[j + 1] = temp;
                }
            }
        }
        return sorted;
    }
}

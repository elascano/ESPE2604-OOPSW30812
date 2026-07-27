package ec.edu.espe.exam.model;

public class SortingContext {
    private SortingStrategy strategy;

    public int[] sort(int[] data) {
        int size = data.length;
        if (size >= 2 && size <= 6) {
            strategy = new BubbleSort();
        } else if (size >= 7 && size <= 10) {
            strategy = new InsertionSort();
        } else {
            strategy = new QuickSort();
        }
        return strategy.sort(data);
    }

    public String getAlgorithmName() {
        if (strategy != null) {
            return strategy.getClass().getSimpleName();
        }
        return "Unknown";
    }
}
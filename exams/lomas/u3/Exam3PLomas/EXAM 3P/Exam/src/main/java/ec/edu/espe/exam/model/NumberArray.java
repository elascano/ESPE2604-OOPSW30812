package ec.edu.espe.exam.model;

import java.util.Arrays;

public class NumberArray {
    private String unsorted;
    private int size;
    private String algorithm;
    private String sorted;

    public NumberArray(int[] unsortedArr, int[] sortedArr, String algorithm) {
        this.unsorted = Arrays.toString(unsortedArr).replaceAll("[\\[\\]\\s]", "");
        this.size = unsortedArr.length;
        this.algorithm = algorithm;
        this.sorted = Arrays.toString(sortedArr).replaceAll("[\\[\\]\\s]", "");
    }

    public String getUnsorted() {
        return unsorted;
    }

    public int getSize() {
        return size;
    }

    public String getAlgorithm() {
        return algorithm;
    }

    public String getSorted() {
        return sorted;
    }
}
package ec.edu.espe.strategy.model;

import org.bson.Document;

public class SortingRecord {
    private String unsorted;
    private int size;
    private String sortAlgorithm;
    private String sorted;

    public SortingRecord() {
    }

    public SortingRecord(String unsorted, int size, String sortAlgorithm, String sorted) {
        this.unsorted = unsorted;
        this.size = size;
        this.sortAlgorithm = sortAlgorithm;
        this.sorted = sorted;
    }

    public String getUnsorted() {
        return unsorted;
    }

    public void setUnsorted(String unsorted) {
        this.unsorted = unsorted;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public String getSortAlgorithm() {
        return sortAlgorithm;
    }

    public void setSortAlgorithm(String sortAlgorithm) {
        this.sortAlgorithm = sortAlgorithm;
    }

    public String getSorted() {
        return sorted;
    }

    public void setSorted(String sorted) {
        this.sorted = sorted;
    }

    public Document toDocument() {
        Document doc = new Document();
        doc.append("unsorted", unsorted);
        doc.append("size", size);
        doc.append("sort algorithm", sortAlgorithm);
        doc.append("sortAlgorithm", sortAlgorithm);
        doc.append("sorted", sorted);
        return doc;
    }

    public static SortingRecord fromDocument(Document doc) {
        if (doc == null) {
            return new SortingRecord("", 0, "", "");
        }
        String unsorted = doc.getString("unsorted");
        if (unsorted == null) unsorted = "";

        int size = doc.getInteger("size", 0);

        String algo = doc.getString("sort algorithm");
        if (algo == null) {
            algo = doc.getString("sortAlgorithm");
        }
        if (algo == null) algo = "";

        String sorted = doc.getString("sorted");
        if (sorted == null) sorted = "";

        return new SortingRecord(unsorted, size, algo, sorted);
    }
}

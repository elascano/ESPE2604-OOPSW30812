/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package ec.edu.espe.Strategy.model;

import org.bson.Document;
/**
 *
 * @author Cristian Palomo, Error 404, @ESPE
 */
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

    // --- Getters & Setters ---

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

    // --- Mapeo BSON / MongoDB ---

    public Document toDocument() {
        return new Document()
                .append("unsorted", unsorted)
                .append("size", size)
                .append("sort algorithm", sortAlgorithm)
                .append("sortAlgorithm", sortAlgorithm)
                .append("sorted", sorted);
    }

    public static SortingRecord fromDocument(Document doc) {
        if (doc == null) {
            return new SortingRecord("", 0, "", "");
        }

        String unsorted = doc.getString("unsorted");
        String sorted = doc.getString("sorted");
        
        // Mantenemos la compatibilidad doble para el campo del algoritmo
        String algo = doc.getString("sort algorithm");
        if (algo == null) {
            algo = doc.getString("sortAlgorithm");
        }

        return new SortingRecord(
            unsorted != null ? unsorted : "",
            doc.getInteger("size", 0),
            algo != null ? algo : "",
            sorted != null ? sorted : ""
        );
    }
}

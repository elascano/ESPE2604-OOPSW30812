/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.espe.products.model;

/**
 *
 * @author Daniel Codena, CodeBreakers, @ESPE
 */
public class Book extends Product{

    private String author;
    private int pages;
    
    @Override
    public void sell() {
        //TODO
    }

    public Book(int id, String name, float price, String author, int pages) {
        super(id, name, price);
        this.author = author;
        this.pages = pages;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getPages() {
        return pages;
    }

    public void setPages(int pages) {
        this.pages = pages;
    }
    
}

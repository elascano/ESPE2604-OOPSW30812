/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.espe.mothersApp.model;

/**
 *
 * @author Jennyfer Nase, Error 404, @ESPE
 */

public class Slide {
    private int id;        
    private String title;  
    private String image;   
    private String text;  

    public Slide(int id, String title, String image, String text) {
        this.id = id;
        this.title = title;
        this.image = image;
        this.text = text;
    }
    
    public void showSlide() {
        System.out.println("____  Visualizando Diapositiva ____ ");
        System.out.println("Título: " + title);
        System.out.println("Imagen: " + image);
        System.out.println("Contenido: " + text);
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }
}
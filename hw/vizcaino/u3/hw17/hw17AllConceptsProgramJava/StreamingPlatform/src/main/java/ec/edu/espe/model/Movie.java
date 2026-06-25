/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.espe.model;

/**
 *
 * @author Adrian Vizcaino <The-Softwarriors at ESPE>
 */
public class Movie extends PlayableContent {

    public Movie(String title, int durationMinutes) {
        super(title, durationMinutes);
    }

    @Override
    public void play() {
        System.out.println("Playing movie: " + getTitle());
    }

    @Override
    public String getContentType() {
        return "Movie";
    }
}
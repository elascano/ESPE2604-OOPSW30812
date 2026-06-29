/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.espe.model;

/**
 *
 * @author Adrian Vizcaino <The-Softwarriors at ESPE>
 */

public class Episode extends PlayableContent {

    private int episodeNumber;

    public Episode(String title, int durationMinutes, int episodeNumber) {
        super(title, durationMinutes);
        this.episodeNumber = episodeNumber;
    }

    public int getEpisodeNumber() {
        return episodeNumber;
    }

    @Override
    public void play() {
        System.out.println("Playing episode " +
                episodeNumber +
                ": " +
                getTitle());
    }

    @Override
    public String getContentType() {
        return "Episode";
    }
}
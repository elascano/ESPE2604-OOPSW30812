/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.espe.model;

/**
 *
 * @author Adrian Vizcaino <The-Softwarriors at ESPE>
 */

import java.util.ArrayList;
import java.util.List;

public class Series extends PlayableContent {

    private List<Episode> episodes;

    public Series(String title, int durationMinutes) {
        super(title, durationMinutes);
        episodes = new ArrayList<>();
    }

    public void addEpisode(Episode episode) {
        episodes.add(episode);
    }

    public List<Episode> getEpisodes() {
        return episodes;
    }

    @Override
    public void play() {
        System.out.println("Playing series: " + getTitle());
    }

    @Override
    public String getContentType() {
        return "Series";
    }
}
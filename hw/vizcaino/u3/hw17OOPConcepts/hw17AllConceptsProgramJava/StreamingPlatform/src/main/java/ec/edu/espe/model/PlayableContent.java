/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package ec.edu.espe.model;

/**
 *
 * @author Adrian Vizcaino <The-Softwarriors at ESPE>
 */

public abstract class PlayableContent implements Playable {

    private String title;
    private int durationMinutes;

    public PlayableContent(String title, int durationMinutes) {
        this.title = title;
        this.durationMinutes = durationMinutes;
    }

    public String getTitle() {
        return title;
    }

    public int getDurationMinutes() {
        return durationMinutes;
    }

    public abstract String getContentType();
}
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.espe.model;

/**
 *
 * @author Adrian Vizcaino <The-Softwarriors at ESPE>
 */
public class StreamingPlatform {

    private String name;

    public StreamingPlatform(String name) {
        this.name = name;
    }

    public void playContent(String user, String content) {
        System.out.println(user + " watching " + content);
    }
}
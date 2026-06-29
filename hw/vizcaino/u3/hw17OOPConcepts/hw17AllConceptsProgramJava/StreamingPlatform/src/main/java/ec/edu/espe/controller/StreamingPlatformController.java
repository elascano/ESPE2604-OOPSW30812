/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.espe.controller;

/**
 *
 * @author Adrian Vizcaino <The-Softwarriors at ESPE>
 */
import ec.edu.espe.view.StreamingPlatformView;

public class StreamingPlatformController {

    private StreamingPlatformView view;

    public StreamingPlatformController() {
        view = new StreamingPlatformView();
    }

    public void run() {
        view.setVisible(true);
    }
}
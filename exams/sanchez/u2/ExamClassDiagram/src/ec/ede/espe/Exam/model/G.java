/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.ede.espe.Exam.model;

/**
 *
 * @author Joel Sanchez <The_Softwarriors at ESPE>
 */
public class G {

    private J j;

    public G(J j) {
        this.j = j;
    }

    public void execute() {
        System.out.println("G executing with " + j);
    }

    @Override
    public String toString() {
        return "G -> " + j;
    }
}


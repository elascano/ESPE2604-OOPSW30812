/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.espe.mazegenerator.controller;

import ec.edu.espe.mazegenerator.view.FrmMaze;

/**
 *
 * @author Daniel Codena, CodeBreakers, @ESPE
 */
public class MazeGeneratorController implements IDraw {

    private IMazeGenerator generator;

    public MazeGeneratorController(IMazeGenerator generator) {
        this.generator = generator;
    }

    public void selectTypeOfMaze() {
        //TODO algorithm to enter data
    }

    @Override
    public FrmMaze drawMaze() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public IMazeGenerator getGenerator() {
        return generator;
    }

    public void setGenerator(IMazeGenerator generator) {
        this.generator = generator;
    }

}

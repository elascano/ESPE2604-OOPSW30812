/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.espe.mazegenerator.model;

/**
 *
 * @author Daniel Codena, CodeBreakers, @ESPE
 */
public abstract class Door {
    protected String cardinalDirection;
    protected boolean horizontalLine;

    public Door(String cardinalDirection, boolean horizontalLine) {
        this.cardinalDirection = cardinalDirection;
        this.horizontalLine = horizontalLine;
    }

    @Override
    public String toString() {
        return "Door{" + "cardinalDirection=" + cardinalDirection + ", horizontalLine=" + horizontalLine + '}';
    }

    public String getCardinalDirection() {
        return cardinalDirection;
    }

    public void setCardinalDirection(String cardinalDirection) {
        this.cardinalDirection = cardinalDirection;
    }

    public boolean isHorizontalLine() {
        return horizontalLine;
    }

    public void setHorizontalLine(boolean horizontalLine) {
        this.horizontalLine = horizontalLine;
    }
    
}

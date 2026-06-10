/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.espe.mothersApp.controller;

/**
 *
 * @author sbart
 */
public class EducationalResourceController {
  private final String[][] tipsMatrix = {
        {
            "Keep the room quiet and dark.",
            "Rock the baby gently.",
            "Avoid loud noises before bedtime."
        },
        {
            "Ensure the baby's mouth is wide open like a yawn.",
            "Bring the baby to the breast, not the breast to the baby.",
            "Make sure the baby's chin touches the breast first."
        },
        {
            "Hold the baby upright against your chest.",
            "Gently pat or rub the baby's back for a few minutes.",
            "Sit the baby on your lap, supporting their chin and chest."
        },
        {
            "Check if the diaper needs to be changed.",
            "Offer a pacifier or check if it has been too long since the last feeding.",
            "CRITICAL: If the baby has been crying constantly for more than 2 hours and has a fever, contact your pediatrician immediately."
        },
        {
            "Keep the cord stump clean and dry. Wash your hands before touching it.",
            "Let the stump fall off naturally; never pull or tug at it.",
            "WARNING: If you notice redness, foul odor, or pus around the umbilical cord, seek medical attention."
        }
    };

    private final String[][] colorsMatrix = {
        { "NORMAL", "NORMAL", "NORMAL" },
        { "NORMAL", "NORMAL", "NORMAL" },
        { "NORMAL", "NORMAL", "NORMAL" },
        { "NORMAL", "NORMAL", "DANGER" },
        { "NORMAL", "NORMAL", "WARNING" }
    };

    /**
     * Obtiene el texto de un tip específico.
     */
    public String getTipContent(int topicIndex, int tipIndex) {
        return tipsMatrix[topicIndex][tipIndex];
    }

    /**
     * Obtiene el nivel de alerta (color) de un tip específico.
     */
    public String getAlertLevel(int topicIndex, int tipIndex) {
        return colorsMatrix[topicIndex][tipIndex];
    }

    /**
     * Obtiene la cantidad total de tips que tiene un tema seleccionado.
     */
    public int getTipsCount(int topicIndex) {
        return tipsMatrix[topicIndex].length;
    }  
}

package ec.edu.espe.rpg.model.exceptions;

/**
 * Excepción base para todas las reglas de negocio del juego.
 * Demuestra el uso de jerarquía de excepciones (POO).
 */
public class GameRuleException extends Exception {
    public GameRuleException(String message) {
        super(message);
    }
}

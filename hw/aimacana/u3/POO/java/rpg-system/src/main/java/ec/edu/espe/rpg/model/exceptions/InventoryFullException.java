package ec.edu.espe.rpg.model.exceptions;

public class InventoryFullException extends GameRuleException {
    public InventoryFullException(String message) {
        super(message);
    }
}

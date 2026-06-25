package ec.edu.espe.rpg.repository;

import ec.edu.espe.rpg.model.entities.Character;
import java.util.List;

public interface CharacterRepository {
    void save(Character character);
    Character findById(String id);
    List<Character> findAll();
    void delete(String id);
}

package ec.espe.edu.mongodb.controller;

import java.util.List;

/**
 * Generic interface defining CRUD contracts for database controllers.
 * Adheres to Dependency Inversion (DIP) and Interface Segregation (ISP) principles.
 * 
 * @param <T> The type of the entity
 * @author Anthony Aimacaña, MKA programmer, @ESPE
 */
public interface IDatabaseController<T> {
    /**
     * Inserts a new entity into the database.
     * 
     * @param entity the entity to create
     */
    void create(T entity);

    /**
     * Retrieves all entities from the collection.
     * 
     * @return list of all entities
     */
    List<T> readAll();

    /**
     * Reads a single entity by its identifier field and value.
     * 
     * @param idField the name of the id field in the database
     * @param idValue the value of the id to search for
     * @return the entity if found, null otherwise
     */
    T readById(String idField, String idValue);

    /**
     * Updates a single field value for an entity identified by its ID.
     * 
     * @param idField the name of the id field
     * @param idValue the value of the id
     * @param fieldName the name of the field to update
     * @param newValue the new value to set
     */
    void update(String idField, String idValue, String fieldName, Object newValue);

    /**
     * Deletes a single entity from the database by its ID.
     * 
     * @param idField the name of the id field
     * @param idValue the value of the id
     */
    void delete(String idField, String idValue);

    /**
     * Deletes all elements in the collection (recreates / cleans the state).
     */
    void cleanCollection();
}

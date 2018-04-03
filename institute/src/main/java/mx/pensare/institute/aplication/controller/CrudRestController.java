package mx.pensare.institute.aplication.controller;



import mx.pensare.institute.aplication.dto.ApplicationDto;

import java.io.Serializable;
import java.util.List;

/**
 * Abstraction of common controllers methods for a crud. Application layer
 *
 * @param <T>  Data transfer object type
 * @param <ID> object identifier
 * @author Alejandro Martin
 * @version 1.0 - 2017/05/21
 */
public interface CrudRestController<T extends ApplicationDto, ID extends Serializable> {

    /**
     * Returns all instances of the entity.
     *
     * @return all entities
     */
    List<T> getAll();

    /**
     * Gets the entity with the indicated identifier.
     *
     * @param id entity identifier
     * @return the entity with the indicated id
     */
    T get(ID id);

    /**
     * Saves the given entity.
     *
     * @param dtoObject entity
     * @return the saved entity
     */
    T create(T dtoObject);

    /**
     * Updates the given entity.
     *
     * @param dtoObject entity
     * @return the saved entity
     */
    T update(T dtoObject, ID id);

    /**
     * Deletes the entity with the indicated identifier.
     *
     * @param id entity identifier
     */
    void delete(ID id);
}
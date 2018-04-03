package mx.pensare.institute.domain.service;

import mx.pensare.institute.domain.entity.DomainEntity;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

/**
 * Abstraction of a domain entity crud.
 *
 * @param <T>  {@link DomainEntity domain entity}
 * @param <ID> identifier type
 * @author Alejandro Martin
 * @version 1.0 - 2017/05/13
 */
public interface CrudService<T extends DomainEntity, ID extends Serializable> {

    /**
     * Gets the entity with the indicated identifier.
     *
     * @param id entity identifier
     * @return the entity with the indicated id
     */
    Optional<T> getById(ID id);

    /**
     * Saves or updated the given entity.
     *
     * @param domainObject entity
     * @return the saved entity
     */
    T saveOrUpdate(T domainObject);

    /**
     * Returns all instances of the entity.
     *
     * @return all entities
     */
    List<T> getAll();

    /**
     * Deletes the entity with the indicated identifier.
     *
     * @param id entity identifier
     */
    void deleteById(ID id);
}

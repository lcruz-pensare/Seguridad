package mx.pensare.institute.aplication.serviceimpl;



import mx.pensare.institute.domain.entity.DomainEntity;
import mx.pensare.institute.domain.repository.GenericRepository;
import mx.pensare.institute.domain.service.CrudService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * Generic implementation for {@link CrudService}, if extra business logic required
 * method must be overwritten.
 *
 * @param <T1> {@link DomainEntity domain entity}
 * @param <ID> identifier type
 * @param <T2> {@link GenericRepository repository interface} for the
 *             {@link DomainEntity domain entity}
 * @author Alejandro Martin
 * @version 2017/05/15
 */
public abstract class AbstractCrudService<T1 extends DomainEntity<ID>,
        ID extends Serializable,
        T2 extends GenericRepository<T1, ID>>
        implements CrudService<T1, ID> {

    /**
     * Entity repository to be used
     */
    protected T2 repository;

    /**
     * Common logger for use in subclasses.
     */
    protected final Log logger = LogFactory.getLog(getClass());

    @Override
    public Optional<T1> getById(ID id) {
        return repository.findById(id);
    }

    @Override
    public T1 saveOrUpdate(T1 domainObject) {
        // set service "metadata" as dates and other fields
//        if (domainObject != null && domainObject.getId() != null) {
//            DomainEntity returnedDomainObject = repository
//                    .findOne(domainObject.getId());
//            if (returnedDomainObject != null) {
//                domainObject.setVersion(
//                        returnedDomainObject.getVersion());
//                domainObject.setCreatedDate(
//                        returnedDomainObject.getCreatedDate());
//                domainObject.setLastUpdatedDate(
//                        returnedDomainObject.getLastUpdatedDate());
//                domainObject.setLogicalDelete(
//                        returnedDomainObject.getLogicalDelete());
//            }
//        }
        return repository.save(domainObject);
    }

    @Override
    public List<T1> getAll() {
        List<T1> list = new ArrayList<>();
        repository.findAll().forEach(list::add);
        return list;
    }

    @Override
    public void deleteById(ID id) {
        repository.deleteById(id);
    }

    // setters & getters

    @Autowired
    public void setRepository(T2 repository) {
        this.repository = repository;
    }
}
package com.example.housemanager.persistence.service;

import com.example.housemanager.persistence.exception.EntryAlreadyExists;
import com.example.housemanager.persistence.exception.EntryDoesNotExist;
import com.example.housemanager.persistence.model.Company;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import javax.swing.text.html.Option;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

/**
 * @param <T>  - Entity model
 * @param <ID> - ID Type
 * @param <R>  - Repository
 */

@Service
public abstract class AbstractEntityService<T, ID, R extends CrudRepository> {

    @Autowired
    protected R repository;

    private static final Logger logger = LoggerFactory.getLogger("Persistence");
    private static final String GENERIC_EXCEPTION_MESSAGE = "Exception thrown during operation:";

    public void save(T entry) {
        ID entityId = getEntityId(entry);
        if (repository.existsById(entityId))
            logger.error(GENERIC_EXCEPTION_MESSAGE, new EntryAlreadyExists(entityId, entry.getClass()));
        else
            repository.save(entry);
    }

    public void update(T entry) {
        ID entryId = getEntityId(entry);
        if (repository.existsById(entryId))
            repository.save(entry);
        else
            logger.error(GENERIC_EXCEPTION_MESSAGE, new EntryDoesNotExist(entryId, Company.class));
    }

    public void delete(T entry) {
        repository.delete(entry);
    }

    public Optional<T> findById(ID id) {
        return repository.findById(id);
    }

    public Iterable<T> findAll() {
        return repository.findAll();
    }

    public void deleteAll() {
        repository.deleteAll();
    }

    abstract protected ID getEntityId(T entry);

}

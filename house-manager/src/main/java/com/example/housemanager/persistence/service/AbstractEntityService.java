package com.example.housemanager.persistence.service;

import com.example.housemanager.persistence.exception.EntryAlreadyExists;
import com.example.housemanager.persistence.exception.EntryDoesNotExist;
import com.example.housemanager.persistence.model.Company;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

/**
 * @param <T> - Entity model
 * @param <R> - Repository
 */

@Service
public abstract class AbstractEntityService<T, R extends CrudRepository> {

    @Autowired
    protected Logger logger;
    protected R repository;

    private static final String GENERIC_EXCEPTION_MESSAGE = "Exception thrown during operation:";

    public void save(T entry) {
        Object entityId = getEntityId(entry);
        if (repository.existsById(entityId))
            logger.error(GENERIC_EXCEPTION_MESSAGE, new EntryAlreadyExists(entityId, entry.getClass()));
        else
            repository.save(entry);
    }

    public void update(T entry) {
        Object entityId = getEntityId(entry);
        if (repository.existsById(entityId))
            repository.save(entry);
        else
            logger.error(GENERIC_EXCEPTION_MESSAGE, new EntryDoesNotExist(entityId, Company.class));
    }

    public void delete(T entry) {
        repository.delete(entry);
    }

    abstract protected Object getEntityId(T entry);
}

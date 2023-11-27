package com.example.transportcompany.service;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.util.Pair;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public abstract class AbstractService<T, ID, R extends CrudRepository<T, ID>> {

    @Autowired
    protected R repository;

    protected Logger log;

    abstract ID getId(T entity);

    protected boolean exists(T entity) {
        return repository.existsById(getId(entity));
    }

    public void save(T entity) {
        if (exists(entity))
            log.warn(entityExistsMessage(entity));
        repository.save(entity);
    }

    public void update(T entity) {
        if (!exists(entity))
            log.warn(entityDoesNotExistMessage(entity));
        repository.save(entity);
    }

    public Optional<T> getById(ID id) {
        return repository.findById(id);
    }

    public void deleteByID(ID id) {
        repository.deleteById(id);
    }

    public void delete(T entity) {
        repository.delete(entity);
    }

    private String entityExistsMessage(T entity) {
        return "Entity with id " + getId(entity).toString() + " already exists and will not be overwritten.";
    }

    private String entityDoesNotExistMessage(T entity) {
        return "Entity with id " + getId(entity).toString() + " does not exist. Use save(entity) to create it.";
    }
    
    public boolean equals(Pair<T, T> entities) {
        return entities.getFirst().equals(entities.getSecond());
    }
}

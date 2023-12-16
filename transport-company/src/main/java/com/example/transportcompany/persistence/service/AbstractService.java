package com.example.transportcompany.persistence.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.InvalidDataAccessApiUsageException;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.util.Pair;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.StreamSupport;

@Service
public abstract class AbstractService<T, ID, R extends CrudRepository<T, ID>> {

    @Autowired
    protected R repository;

    protected Logger log = LoggerFactory.getLogger(this.getClass());

    abstract ID getId(T entity);

    protected boolean exists(T entity) {
        try {
            return repository.existsById(getId(entity));
        } catch (InvalidDataAccessApiUsageException exception) {
            return false;
        }
    }

    public T save(T entity) {
        if (exists(entity))
            log.warn(entityExistsMessage(entity));
        return repository.save(entity);
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

    public void deleteAll() {
        repository.deleteAll();
    }

    public List<T> getAll() {
        return StreamSupport.stream(repository.findAll().spliterator(), false).toList();
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

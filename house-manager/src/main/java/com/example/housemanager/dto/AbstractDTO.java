package com.example.housemanager.dto;

/**
 * @param <T> Entity which this DTO represents
 */
public abstract class AbstractDTO<T> {
    abstract public T toEntity();
}

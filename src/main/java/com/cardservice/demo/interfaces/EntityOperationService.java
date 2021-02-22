package com.cardservice.demo.interfaces;

public interface EntityOperationService<T> {

    boolean add(T entity);
    boolean addAll(Iterable<T> entities);

    void delete(T entity);
    void deleteAll(Iterable<T> entities);

    Boolean update(T entity , T value);

}

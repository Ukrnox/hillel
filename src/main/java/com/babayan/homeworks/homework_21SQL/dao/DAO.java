package com.babayan.homeworks.homework_21SQL.dao;

public interface DAO<T> {
    void create(T entity);
    T read(long id);
    void update(T entity);
    void delete(long id);
}
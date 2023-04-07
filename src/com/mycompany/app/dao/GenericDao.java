package com.mycompany.app.dao;

import java.util.List;

public interface GenericDao <T, K>{
    public T findOne(K id);
    public List<T> findAll();
    public void update(T department);
    public void deleteById(K id);
    public void delete(T obj);
    public void insert(T newDepartment);
}

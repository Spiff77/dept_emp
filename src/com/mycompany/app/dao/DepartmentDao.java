package com.mycompany.app.dao;

import com.mycompany.app.model.Department;

import java.util.List;

public interface DepartmentDao {
    public Department findOne(int id);
    public List<Department> findAll();
    public void update(Department department);
    public void delete(int id);
    public void insert(Department newDepartment);
}

package com.mycompany.app.dao;

import com.mycompany.app.model.Employee;

import java.util.List;

public interface EmployeeDao {
    public Employee findOne(int id);
    public List<Employee> findAll();
    public void update(Employee employee);
    public void delete(int id);
    public void insert(Employee newEmp);
}

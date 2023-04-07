package com.mycompany.app.dao;

import com.mycompany.app.model.Employee;

import java.util.List;

public interface EmployeeDao extends GenericDao<Employee, Integer>{
    public List<Employee> getAllWithSalaryStartingFrom(int amount);
}

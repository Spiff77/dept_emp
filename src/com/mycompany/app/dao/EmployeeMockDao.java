package com.mycompany.app.dao;


import com.mycompany.app.model.Employee;

import java.sql.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

public class EmployeeMockDao implements  EmployeeDao{

    private List<Employee> employeesFakeDb = new ArrayList<>(Arrays.asList(
            new Employee(1238, "Jean", "IT", 7369, new Date(), 2030, 300, 30),
            new Employee(1235, "Paul", "IT", 7369, new Date(), 2030, 300, 30),
            new Employee(1236, "Pierre", "IT", 7369, new Date(), 2030, 300, 30)
    ));

    public Employee findOne(Integer id){
        return this.employeesFakeDb.stream().filter(e -> e.getId() == id).findFirst().orElse(null);
    }

    public List<Employee> findAll(){
        return this.employeesFakeDb;
    }

    public void update(Employee employee){
       Employee employeeToUpdate = this.findOne(employee.getId());
       employeeToUpdate.setName(employee.getName());
       employeeToUpdate.setHireDate(employee.getHireDate());
       /* To be continued */


    }
    public void deleteById(Integer id){
        employeesFakeDb.remove(findOne(id));
    }

    @Override
    public void delete(Employee employee) {
        this.employeesFakeDb.remove(employee);
    }

    public void insert(Employee newEmp){
        employeesFakeDb.add(newEmp);
    }


    @Override
    public List<Employee> getAllWithSalaryStartingFrom(int amount) {
        return this.employeesFakeDb.stream().filter( e -> e.getSalary() > amount).collect(Collectors.toList());
    }
}

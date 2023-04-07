package com.mycompany.app;

import com.mycompany.app.dao.*;
import com.mycompany.app.factory.DaoType;
import com.mycompany.app.factory.DepartmentDaoFactory;
import com.mycompany.app.factory.EmployeeDaoFactory;
import com.mycompany.app.model.Department;
import com.mycompany.app.model.Employee;
import com.mycompany.app.utils.ConnectionManagement;

import java.util.Date;

public class MyEntry {
    public static void main(String[] args) {

        EmployeeDaoFactory.setType(DaoType.MOCK);
        DepartmentDaoFactory.setType(DaoType.MOCK);

        EmployeeDao edao = EmployeeDaoFactory.getDao();
        DepartmentDao ddao = DepartmentDaoFactory.getDao();

        System.out.println("---------------- EMPLOYEE ----------------");
        System.out.println("Inserting emp:");
        Employee employee1 = new Employee(1234, "Jean", "IT", 7369, new Date(), 2030,20, 300, 30);
        edao.insert(employee1);
        Employee employee = edao.findOne(1234);
        System.out.println("Now selecting, found:" + employee);
        employee = edao.findOne(1234);
        employee.setName("SuperJean");
        edao.update(employee);
        System.out.println("now updating, new value from db: " + employee);
        System.out.println("Deleting nom");
        edao.deleteById(1234);
        System.out.println("Checking if we gor null from db: " + edao.findOne(1234));


        System.out.println("---------------- DEPARTMENT ----------------");
        System.out.println("Inserting dep:");
        ddao.insert(new Department(1234, "CLEANING", "LA"));
        Department department = ddao.findOne(1234);
        System.out.println("Now selecting, found:" + department);
        department = ddao.findOne(1234);
        department.setName("MAXINCLEANING");
        ddao.update(department);
        System.out.println("now updating, new value from db: " + department);
        System.out.println("Deleting department");
        ddao.deleteById(1234);
        System.out.println("Checking if we gor null from db: " + ddao.findOne(1234));

        if(EmployeeDaoFactory.getType() == DaoType.JDBC)
            ConnectionManagement.getInstance().closeConnection();
    }
}

// Deux classes: DepartmentJdbc et DepartmentMock qui implementent l'interface...
// ... DepartmentDao. Cette interface contient les methodes classiques de DAO (findAll, insert, etc...)
// Nous avons besoin d'une factory afin de dire si nous utilisons les fausses classes (Mock) ou les classes JDBC...
// Nous allons donc créer DepartmentFactory ainsi qu'une énumeration des options si pas deja disponible


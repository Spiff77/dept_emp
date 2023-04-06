package com.mycompany.app;

import com.mycompany.app.dao.DepartmentDao;
import com.mycompany.app.dao.EmployeeDao;
import com.mycompany.app.model.Department;
import com.mycompany.app.model.Employee;

import java.util.Date;

public class MyEntry {
    public static void main(String[] args) {

        EmployeeDao edao = new EmployeeDao();
        DepartmentDao ddao = new DepartmentDao();

        System.out.println("---------------- EMPLOYEE ----------------");
        System.out.println("Inserting emp:");
        edao.insert(new Employee(1234, "Jean", "IT", 7369, new Date(), 2030, 300, 30));
        Employee employee = edao.findOne(1234);
        System.out.println("Now selecting, found:" + employee);
        employee = edao.findOne(1234);
        employee.setName("SuperJean");
        edao.update(employee);
        System.out.println("now updating, new value from db: " + employee);
        System.out.println("Deleting nom");
        edao.delete(1234);
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
        System.out.println("Deleting nom");
        ddao.delete(1234);
        System.out.println("Checking if we gor null from db: " + ddao.findOne(1234));

    }
}

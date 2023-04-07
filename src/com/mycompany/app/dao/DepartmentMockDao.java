package com.mycompany.app.dao;


import com.mycompany.app.model.Department;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DepartmentMockDao implements  DepartmentDao{

    private List<Department> departmentsFakeDb = new ArrayList<>(Arrays.asList(
            new Department(200, "MARKETING", "LA"),
            new Department(210, "GESTIONCOPIEUSE", "NY"),
            new Department(229, "GESTION", "CREUSE")
    ));

    public Department findOne(Integer id){
        return this.departmentsFakeDb.stream().filter(e -> e.getId() == id).findFirst().orElse(null);
    }

    public List<Department> findAll(){
        return this.departmentsFakeDb;
    }

    public void update(Department department){
       Department departmentToUpdate = this.findOne(department.getId());
       departmentToUpdate.setName(department.getName());
       departmentToUpdate.setLocation(department.getLocation());
       /* To be continues */


    }
    public void deleteById(Integer id){
         departmentsFakeDb.remove(findOne(id));
    }

    @Override
    public void delete(Department department) {
        this.departmentsFakeDb.remove(department);
    }

    public void insert(Department newEmp){
        departmentsFakeDb.add(newEmp);
    }


}

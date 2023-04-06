package com.mycompany.app.dao;


import com.mycompany.app.model.Department;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

// Creér la dao departmentDao puis la tester

public class DepartmentDao {

    public Department findOne(int id){
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Department department = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:9999/scott?user=root");
            stmt = conn.prepareStatement("SELECT * FROM dept where deptno = ?");
            stmt.setInt(1, id);
            rs = stmt.executeQuery();
            if(rs.next()){

                department = new Department(
                        rs.getInt("deptno"),
                        rs.getString("dname"),
                        rs.getString("loc")
                );
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return department;
    }

    public List<Department> findAll(){
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        List<Department> departments = new ArrayList<>();

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            conn = DriverManager.getConnection("jdbc:mysql://localhost:9999/scott?user=root");
            stmt = conn.createStatement();

            rs = stmt.executeQuery("SELECT * FROM dept");
            while(rs.next())
                departments.add(new Department(
                        rs.getInt("deptno"),
                        rs.getString("dname"),
                        rs.getString("loc")
                ));
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return departments;
    }

    public void update(Department department){
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:9999/scott?user=root");
            stmt = conn.prepareStatement("UPDATE dept SET " +
                    "dname = ?, " +
                    "loc = ? " +
                    "WHERE deptno = ?");
            stmt.setString(1, department.getName());
            stmt.setString(2, department.getLocation());
            stmt.setInt(3, department.getId());
            stmt.executeUpdate();

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    public void delete(Department department){
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:9999/scott?user=root");
            stmt = conn.prepareStatement("DELETE FROM dept where deptno = ?");
            stmt.setInt(1, department.getId());
            stmt.executeUpdate();

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    public void delete(int id){
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:9999/scott?user=root");
            stmt = conn.prepareStatement("DELETE FROM dept where deptno = ?");
            stmt.setInt(1, id);
            stmt.executeUpdate();

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    public void insert(Department newEmp){

        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:9999/scott?user=root");
            stmt = conn.prepareStatement("INSERT INTO dept VALUES (?,?,?)");
            stmt.setInt(1, newEmp.getId());
            stmt.setString(2, newEmp.getName());
            stmt.setString(3, newEmp.getLocation());
            stmt.executeUpdate();

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

}

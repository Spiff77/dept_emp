package com.mycompany.app.dao;


import com.mycompany.app.model.Employee;
import com.mycompany.app.utils.ConnectionManagement;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EmployeeJdbcDao implements  EmployeeDao{

    @Override
    public Employee findOne(Integer id){
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Employee employee = null;
        try {

            conn = ConnectionManagement.getInstance().getConnection();
            stmt = conn.prepareStatement("SELECT * FROM emp where empno = ?");
            stmt.setInt(1, id);
            rs = stmt.executeQuery();
            if(rs.next()){

                employee = new Employee(
                        rs.getInt("empno"),
                        rs.getString("ename"),
                        rs.getString("job"),
                        rs.getInt("mgr"),
                        rs.getDate("hiredate"),
                        rs.getInt("sal"),
                        rs.getInt("comm"),
                        rs.getInt("deptno")
                );
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return employee;
    }

    @Override
    public List<Employee> findAll(){
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        List<Employee> employees = new ArrayList<>();

        try {
          conn = ConnectionManagement.getInstance().getConnection();
          stmt = conn.createStatement();

            rs = stmt.executeQuery("SELECT * FROM emp");
            while(rs.next())
                employees.add(new Employee(
                        rs.getInt("empno"),
                        rs.getString("ename"),
                        rs.getString("job"),
                        rs.getInt("mgr"),
                        rs.getDate("hiredate"),
                        rs.getInt("sal"),
                        rs.getInt("comm"),
                        rs.getInt("deptno")
                ));
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return employees;
    }

    @Override
    public void update(Employee employee){
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            conn = ConnectionManagement.getInstance().getConnection();
            stmt = conn.prepareStatement("UPDATE emp SET " +
                    "ename = ?, " +
                    "job = ?, " +
                    "mgr = ?, " +
                    "hiredate = ?, " +
                    "sal = ?, " +
                    "comm = ?, " +
                    "deptno = ? " +
                    "WHERE empno = ?");
            stmt.setString(1, employee.getName());
            stmt.setString(2, employee.getJob());
            stmt.setInt(3, employee.getManagerId());
            stmt.setDate(4, new Date(employee.getHireDate().getTime()));
            stmt.setInt(5, employee.getSalary());
            stmt.setInt(6, employee.getCommission());
            stmt.setInt(7, employee.getDeptId());
            stmt.setInt(8, employee.getId());
            stmt.executeUpdate();

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public void delete(Employee employee){
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            conn = ConnectionManagement.getInstance().getConnection();
            stmt = conn.prepareStatement("DELETE FROM emp where empno = ?");
            stmt.setInt(1, employee.getId());
            stmt.executeUpdate();

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public void deleteById(Integer id){
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            conn = ConnectionManagement.getInstance().getConnection();
            stmt = conn.prepareStatement("DELETE FROM emp where empno = ?");
            stmt.setInt(1, id);
            stmt.executeUpdate();

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public void insert(Employee newEmp){

        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            conn = ConnectionManagement.getInstance().getConnection();
            stmt = conn.prepareStatement("INSERT INTO emp VALUES (?,?,?,?,?,?,?,?)");
            stmt.setInt(1, newEmp.getId());
            stmt.setString(2, newEmp.getName());
            stmt.setString(3, newEmp.getJob());
            stmt.setInt(4, newEmp.getManagerId());
            stmt.setDate(5, new Date(newEmp.getHireDate().getTime()));
            stmt.setInt(6, newEmp.getSalary());
            stmt.setInt(7, newEmp.getCommission());
            stmt.setInt(8, newEmp.getDeptId());
            stmt.executeUpdate();

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public List<Employee> getAllWithSalaryStartingFrom(int amount) {
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        List<Employee> employees = new ArrayList<>();

// TODO
        return employees;
    }
}

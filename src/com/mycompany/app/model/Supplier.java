package com.mycompany.app.model;

import java.util.Date;

public class Supplier {

    private int id;
    private String name;
    private String job;
    private int managerId;
    private Date hireDate;
    private int salary;
    private int commission;
    private int deptId;

    public Supplier(int id, String name, String job, int managerId, Date hireDate, int salary, int commission, int deptId) {
        this.id = id;
        this.name = name;
        this.job = job;
        this.managerId = managerId;
        this.hireDate = hireDate;
        this.salary = salary;
        this.commission = commission;
        this.deptId = deptId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public int getManagerId() {
        return managerId;
    }

    public void setManagerId(int managerId) {
        this.managerId = managerId;
    }

    public Date getHireDate() {
        return hireDate;
    }

    public void setHireDate(Date hireDate) {
        this.hireDate = hireDate;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public int getCommission() {
        return commission;
    }

    public void setCommission(int commission) {
        this.commission = commission;
    }

    public int getDeptId() {
        return deptId;
    }

    public void setDeptId(int deptId) {
        this.deptId = deptId;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Employee{");
        sb.append("id=").append(id);
        sb.append(", name='").append(name).append('\'');
        sb.append(", job='").append(job).append('\'');
        sb.append(", managerId=").append(managerId);
        sb.append(", hireDate=").append(hireDate);
        sb.append(", salary=").append(salary);
        sb.append(", commission=").append(commission);
        sb.append(", deptId=").append(deptId);
        sb.append('}');
        return sb.toString();
    }
}
/*

| empno | ename  | job       | mgr  | hiredate   | sal  | comm | deptno |
+-------+--------+-----------+------+------------+------+------+--------+
|  7369 | SMITH  | CLERK     | 7902 | 2018-02-09 |  800 | NULL |     20 |
|  7499 | ALLEN  | SALESMAN  | 7698 | 2018-06-13 | 1600 |  300 |     30 |
 */

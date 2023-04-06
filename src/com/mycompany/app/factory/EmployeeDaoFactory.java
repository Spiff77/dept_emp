package com.mycompany.app.factory;

import com.mycompany.app.dao.EmployeeDao;
import com.mycompany.app.dao.EmployeeJdbcDao;
import com.mycompany.app.dao.EmployeeMockDao;

public class EmployeeDaoFactory {

    private static DaoType type = DaoType.JDBC;
    private static EmployeeJdbcDao employeeJdbcDao = new EmployeeJdbcDao();
    private static EmployeeMockDao employeeMockDao = new EmployeeMockDao();

    public static EmployeeDao getDao() {
        if(type == com.mycompany.app.factory.DaoType.MOCK){
            return employeeMockDao;
        }else{
            return employeeJdbcDao;
        }
    }

    public static void setType(DaoType type) {
        EmployeeDaoFactory.type = type;
    }
}

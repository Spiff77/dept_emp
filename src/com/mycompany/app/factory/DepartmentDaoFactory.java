package com.mycompany.app.factory;

import com.mycompany.app.dao.DepartmentDao;
import com.mycompany.app.dao.DepartmentJdbcDao;
import com.mycompany.app.dao.DepartmentMockDao;

public class DepartmentDaoFactory {

    private static DaoType type = DaoType.JDBC;
    private static DepartmentJdbcDao departmentJdbcDao = new DepartmentJdbcDao();
    private static DepartmentMockDao departmentMockDao = new DepartmentMockDao();

    public static DepartmentDao getDao() {
        if(type == DaoType.MOCK){
            return departmentMockDao;
        }else{
            return departmentJdbcDao;
        }
    }

    public static void setType(DaoType type) {
        DepartmentDaoFactory.type = type;
    }
}

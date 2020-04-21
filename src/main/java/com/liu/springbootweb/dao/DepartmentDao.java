package com.liu.springbootweb.dao;

import com.liu.springbootweb.entity.Department;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName: DepartmentDao
 * @Description: 部门dao实现
 * @Author: 52945
 * @Date: 2019/10/22 12:37
 * @Version: 1.0
 */
@Component
public class DepartmentDao {

    private static Map<Integer, Department> departments = new HashMap<>();

    static {
        departments.put(1022, new Department(1022, "人力资源部"));
        departments.put(1023, new Department(1023, "财务企划部"));
        departments.put(1024, new Department(1024, "信息技术部"));
        departments.put(1025, new Department(1025, "风险管理部"));
        departments.put(1026, new Department(1026, "国际业务部"));
    }

    public Collection<Department> listDepartments() {
        return departments.values();
    }

    public Department getDepartmentById(Integer id) {
        return departments.get(id);
    }

}

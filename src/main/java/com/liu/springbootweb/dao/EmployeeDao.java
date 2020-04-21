package com.liu.springbootweb.dao;

import com.liu.springbootweb.entity.Department;
import com.liu.springbootweb.entity.Employee;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.*;

/**
 * @ClassName: EmployeeDao
 * @Description: 员工类dao层
 * @Author: 52945
 * @Date: 2019/10/21 17:20
 * @Version: 1.0
 */
@Component
public class EmployeeDao {

    @Resource
    private DepartmentDao departmentDao;

    private static Map<Integer, Employee> employees = new HashMap<>();

    private static Integer uuid = 8;

    static {
        employees.put(1, new Employee(1, "liu", "67231@qq.com", 1, new Date(), new Department(1023, "财务企划部")));
        employees.put(2, new Employee(2, "sunny", "7324@126.com", 0, new Date(), new Department(1022, "人力资源部")));
        employees.put(3, new Employee(3, "haha", "9845@139.com", 1, new Date(), new Department(1024, "信息技术部")));
        employees.put(4, new Employee(4, "andy", "32342@qq.com", 1, new Date(), new Department(1025, "风险管理部")));
        employees.put(5, new Employee(5, "john", "3453@qq.com", 0, new Date(), new Department(1026, "国际业务部")));
        employees.put(6, new Employee(6, "jiji", "87345@163.com", 0, new Date(), new Department(1025, "风险管理部")));
        employees.put(7, new Employee(7, "jason", "3267243@qq.com", 1, new Date(), new Department(1022, "人力资源部")));
    }

    /**
     * @Name listEmployees
     * @Description 获取所有的员工信息
     * @Date 2019/10/22 10:51
     * @Param []
     * @return java.util.Collection<com.liu.springbootweb.entity.Employee>
     **/
    public Collection<Employee> listEmployees(){
        return employees.values();
    }

    public Employee getEmployeeById(Integer id){
        return employees.get(id);
    }

    public void delete(Integer id){
        employees.remove(id);
    }

    public void save(Employee employee){
        if (employee.getId()==null) {
            employee.setId(uuid++);
        }
        //设置部门信息
        employee.setDepartment(departmentDao.getDepartmentById(employee.getDepartment().getId()));
        employees.put(employee.getId(), employee);
    }

}

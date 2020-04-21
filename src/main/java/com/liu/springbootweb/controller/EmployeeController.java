package com.liu.springbootweb.controller;

import com.liu.springbootweb.dao.DepartmentDao;
import com.liu.springbootweb.dao.EmployeeDao;
import com.liu.springbootweb.entity.Department;
import com.liu.springbootweb.entity.Employee;
import com.sun.org.apache.xpath.internal.operations.Mod;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.Collection;

/**
 * @ClassName: EmployeeController
 * @Description: 员工管理控制器
 * @Author: 52945
 * @Date: 2019/10/21 17:05
 * @Version: 1.0
 */
@Controller
public class EmployeeController {

    @Resource
    private EmployeeDao employeeDao;
    @Resource
    private DepartmentDao departmentDao;

    /**
     * @Name listEmployee
     * @Description 获取所有员工列表信息
     * @Date 2019/10/21 17:06
     * @Param []
     * @return java.lang.String
     **/
    @GetMapping("/emps")
    public String listEmployee(Model model){
        Collection<Employee> employees = employeeDao.listEmployees();
        model.addAttribute("emps", employees);
        return "emp/list";
    }

    /**
     * @Name toAdd
     * @Description 跳转添加员工页面
     * @Date 2019/10/22 12:44
     * @Param [model]
     * @return java.lang.String
     **/
    @GetMapping("/add")
    public String toAdd(Model model){
        //获取所有部门信息
        Collection<Department> departments = departmentDao.listDepartments();
        model.addAttribute("departs", departments);
        return "emp/add";
    }

    /**
     * @Name saveOrUpdate
     * @Description 保存/修改
     * @Date 2019/10/28 20:34
     * @Param [employee]
     * @return java.lang.String
     **/
    @PostMapping("/saveOrUpdate")
    public String save(Employee employee){
        //保存员工信息
        employeeDao.save(employee);
        //添加成功之后，跳转到员工列表页面
        //redirect:/   重定向到一个请求路径
        //forword:/   转发到一个请求页面
        return "redirect:/emps";
    }

    /**
     * @Name toUpdate
     * @Description 跳转更新页面
     * @Date 2019/10/28 20:39
     * @Param [id, model]
     * @return java.lang.String
     **/
    @GetMapping("/modify/{id}")
    public String toUpdate(@PathVariable("id") Integer id, Model model){
        //获取用户信息
        Employee employee = employeeDao.getEmployeeById(id);
        model.addAttribute("emp", employee);
        //获取所有部门信息
        Collection<Department> departments = departmentDao.listDepartments();
        model.addAttribute("departs", departments);
        //重用添加页面，新增和修改界面用同一个页面
        return "emp/add";
    }

    /**
     * @Name saveOrUpdate
     * @Description 更新员工
     * @Date 2019/10/28 20:45
     * @Param [employee]
     * @return java.lang.String
     **/
    @PutMapping("/saveOrUpdate")
    public String update(Employee employee){
        //更新员工
        employeeDao.save(employee);
        //更新成功后跳转列表页面
        return "redirect:/emps";
    }

    /**
     * @Name delete
     * @Description 删除员工
     * @Date 2019/10/28 20:45
     * @Param [id]
     * @return java.lang.String
     **/
    @DeleteMapping("/delete/{id}")
    public String delete(@PathVariable("id") Integer id){
        //删除员工
        employeeDao.delete(id);
        //跳转列表页面
        return "redirect:/emps";
    }

}

package com.liu.springbootweb.entity;

import java.util.Date;

/**
 * @ClassName: Employee
 * @Description: 员工实体类
 * @Author: 52945
 * @Date: 2019/10/22 10:47
 * @Version: 1.0
 */
public class Employee {

    private Integer id;
    private String lastName;
    private String email;
    //性别：0:female 1:male
    private Integer gender;
    private Date birth;
    private Department department;

    public Employee() {
    }

    public Employee(Integer id, String lastName, String email, Integer gender, Date birth, Department department) {
        this.id = id;
        this.lastName = lastName;
        this.email = email;
        this.gender = gender;
        this.birth = birth;
        this.department = department;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getGender() {
        return gender;
    }

    public void setGender(Integer gender) {
        this.gender = gender;
    }

    public Date getBirth() {
        return birth;
    }

    public void setBirth(Date birth) {
        this.birth = birth;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

}

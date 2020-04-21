package com.liu.springbootweb.entity;

/**
 * @ClassName: Department
 * @Description: 部门实体类
 * @Author: 52945
 * @Date: 2019/10/22 10:50
 * @Version: 1.0
 */
public class Department {

    private Integer id;
    private String name;

    public Department() {
    }

    public Department(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}

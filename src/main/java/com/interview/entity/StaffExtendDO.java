package com.interview.entity;

import java.io.Serializable;
import java.math.BigDecimal;

public class StaffExtendDO implements Serializable {

    private Long id;

    private String username;

    private Integer age;

    private String department;

    private Integer salary;

    private Long countUsername;

    private BigDecimal sumSalary;

    public StaffExtendDO() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public Integer getSalary() {
        return salary;
    }

    public void setSalary(Integer salary) {
        this.salary = salary;
    }

    public Long getCountUsername() {
        return countUsername;
    }

    public void setCountUsername(Long countUsername) {
        this.countUsername = countUsername;
    }

    public BigDecimal getSumSalary() {
        return sumSalary;
    }

    public void setSumSalary(BigDecimal sumSalary) {
        this.sumSalary = sumSalary;
    }
}

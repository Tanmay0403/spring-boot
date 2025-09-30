package com.example.demo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "employees")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;
    private int manager_id;
    private int department_id;
    private int salary;
    // private int manager_id_id;

    public Employee() {
    }

    public Employee(String name, int department_id, int salary, int manager_id) {
        this.name = name;
        this.department_id = department_id;
        this.salary = salary;
        this.manager_id = manager_id;
    }

    // Getters & Setters
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

    public int getdepartment_id() {
        return department_id;
    }

    public void setdepartment_id(int department_id) {
        this.department_id = department_id;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public int getmanager_id() {
        return manager_id;
    }

    public void setmanager_id(int manager_id) {
        this.manager_id = manager_id;
    }

    @Override
    public String toString() {
        return "Employee [id=" + id + ", name=" + name + ", manager_id=" + manager_id + ", department_id="
                + department_id + ", salary=" + salary + "]";
    }

    
}

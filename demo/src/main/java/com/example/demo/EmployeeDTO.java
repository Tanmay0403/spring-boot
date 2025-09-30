package com.example.demo;

public class EmployeeDTO {
    private int id;
    private String name;
    private int salary;
    private String managerName;
    private String departmentName;

    public EmployeeDTO(int id, String name, int salary, String managerName, String departmentName) {
        this.id = id;
        this.name = name;
        this.salary = salary;
        this.managerName = managerName;
        this.departmentName = departmentName;
    }

    // ✅ Only getters (read-only DTO for SELECT)
    public int getId() {
        return id;
    }
    public String getName() {
        return name;
    }
    public int getSalary() {
        return salary;
    }
    public String getManagerName() {
        return managerName;
    }
    public String getDepartmentName() {
        return departmentName;
    }
}

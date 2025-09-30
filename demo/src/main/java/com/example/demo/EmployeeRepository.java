package com.example.demo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

    @Query("SELECT e FROM Employee e")  // JPQL
    List<Employee> findAllEmployees();

    // 

    // @Query(value = "SELECT  e.id, e.name, m.name AS manager_name, e.salary, e.dept FROM employees e LEFT JOIN employees m ON e.manager_id = m.id;", nativeQuery = true)
    // List<Object[]> findAllEmployeesByNativeSql();

    @Query(value = "SELECT e.id, e.name, e.salary, m.name AS manager_name, d.name AS department_name " +
                   "FROM employees e " +
                   "LEFT JOIN employees m ON e.manager_id = m.id " +
                   "LEFT JOIN department_master d ON e.department_id = d.id",
           nativeQuery = true)
    List<EmployeeDTO> findAllEmployeesWithManager();

    @Query(value = "SELECT id,name FROM employees", nativeQuery = true)
    List<ManagerDTO> findAllManagers();

    @Query(value = "SELECT id,name FROM department_master", nativeQuery = true)
    List<DepartmentDTO> findAllDepartment();


   

    


}

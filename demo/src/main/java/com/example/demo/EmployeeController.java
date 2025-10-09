package com.example.demo;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "http://127.0.0.1:5500")
@RequestMapping("/employee")

public class EmployeeController {

    private final EmployeeRepository repo;

    public EmployeeController(EmployeeRepository repo) {
        this.repo = repo;
    }

    @GetMapping("/listing")
    public List<Employee> getEmployees() {
        return repo.findAllEmployees(); // Uses JPQL
    }

 
    @GetMapping("/nativelist")
    public List<EmployeeDTO> getEmployeesNative() {
        return repo.findAllEmployeesWithManager(); // Uses JPQL
    }

    @PostMapping("/add")
    public String addEmployee(@RequestBody Employee employee) {
        System.out.println(employee);
        repo.save(employee);
        
        return "Employee Added Successfully!";
    }

    @PutMapping("/update")
    public String updateEmployee(@RequestBody Employee employee) {
        if (repo.existsById(employee.getId())) {
            repo.save(employee);
            return "Employee Updated Successfully!";
        }
        return "Employee Not Found!";
    }

    @DeleteMapping("/delete")
    public String deleteEmployee(@RequestBody Employee employee) {
        if (repo.existsById(employee.getId())) {
            repo.deleteById(employee.getId());
            return "Employee Deleted Successfully!";
        }
        return "Employee Not Found!";
    }

    // @RequestMapping(path = "/search", method = RequestMethod.GET)
    // public ArrayList<Employee> searchEmployees(@RequestParam String keyword) {
    //     return emps.stream()
    //             .filter(emp -> emp.getName().toLowerCase().contains(keyword.toLowerCase())
    //             )
    //             .collect(Collectors.toCollection(ArrayList::new));
    // }

        @GetMapping("/managers")
    public List<ManagerDTO> getmanagers() {
        return repo.findAllManagers(); // Uses JPQL
    }
        @GetMapping("/department")
    public List<DepartmentDTO> getdepartment() {
        return repo.findAllDepartment(); // Uses JPQL
    }


}

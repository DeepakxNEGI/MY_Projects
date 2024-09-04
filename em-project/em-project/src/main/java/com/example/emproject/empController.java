package com.example.emproject;

import org.springframework.web.bind.annotation.RestController;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;


@RestController
@CrossOrigin(origins = "http://localhost:3000/")
public class empController {
     //Employeeservice employeeservice = new EmployeeserviceIMP();
    //dependecy injection 
      @Autowired
     Employeeservice employeeservice;

    @GetMapping("employees")
    public List<Employee> GetAllemployees() {
     return employeeservice.readEmployees();
    }
    @GetMapping("employees/{id}")
    public Employee GetAllemployeeById(@PathVariable Long id) {
     return employeeservice.readEmployee(id);
    }

    @PostMapping("employees")
    public String postMethodName(@RequestBody Employee employee) {
        // employees.add(employee);
        return employeeservice.creatEmployee(employee);
        
    }
    @DeleteMapping("employees/{id}")
    public String deleEmployee(@PathVariable long id ){
    if( employeeservice.deleteEmployee(id))
    return "delete successfully";
    return "not found";

}
    @PutMapping("employees/{id}")
    public String putMethodName(@PathVariable Long id, @RequestBody Employee employee) {
       
        
        return employeeservice.updateEmployee(id,employee);
    }
}

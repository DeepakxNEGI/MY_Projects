package com.example.emproject;

import java.util.List;

public interface Employeeservice {

    String creatEmployee(Employee employee);
    List<Employee> readEmployees();
    boolean deleteEmployee(long  id);    
    String updateEmployee(Long id, Employee employee);
    Employee readEmployee(Long id);
    
}

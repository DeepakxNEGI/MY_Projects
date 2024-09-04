package com.example.emproject;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeserviceIMP implements Employeeservice {
  //  List<Employee> employees = new ArrayList<>();


    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public String creatEmployee(Employee employee) {
        EmployeeEnity employeeEnity =new EmployeeEnity();
        BeanUtils.copyProperties(employee, employeeEnity);

        employeeRepository.save(employeeEnity);
     //   employees.add(employee);
        return "saved successfully";

    }
    @Override
    public Employee readEmployee(Long id) {
        EmployeeEnity employeeEnity = employeeRepository.findById(id).get();
        Employee employee =new Employee();
        BeanUtils.copyProperties( employeeEnity,employee);

       return employee;
    }
    @Override
    public List<Employee> readEmployees() {
        List<EmployeeEnity> employeeList =employeeRepository.findAll();
        List<Employee> employees =new ArrayList<>();
        
        for(EmployeeEnity employeeEnity :employeeList){
            Employee emp = new Employee();
            emp.setName(employeeEnity.getName());
            emp.setEmail(employeeEnity.getEmail());
            emp.setId(employeeEnity.getId());
            emp.setPhone(employeeEnity.getPhone());
            employees.add(emp);
        }
        return employees;
    }

    @Override
    public boolean deleteEmployee(long id) {
        EmployeeEnity emp = employeeRepository.findById(id).get();
        employeeRepository.delete(emp);
        return true;
    }

    @Override
    public String updateEmployee(Long id, Employee employee) {
        EmployeeEnity existingEmployee=employeeRepository.findById(id).get();
        existingEmployee.setName(employee.getName());
        existingEmployee.setPhone(employee.getPhone());
        existingEmployee.setEmail(employee.getEmail());
        employeeRepository.save(existingEmployee);
        return "update successfully";
    }

  

    

}
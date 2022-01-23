package com.kgstrivers.androidapi.Controller;

import com.kgstrivers.androidapi.Model.Employee;
import com.kgstrivers.androidapi.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


@RestController
@RequestMapping("/rest")
public class EmployeeController {

    @Autowired
    private EmployeeRepository employeeRepository;


    @PostMapping("/employees")
    public Employee saveEmployee(@RequestBody Employee employee)
    {
        if(employeeRepository.findById(employee.getId())==null) //Duplicate Handle
        {
            employeeRepository.saveEmployee(employee);
            return employee;
        }else
        {
            return null;
        }

    }

    @GetMapping("/employees")
    public List<Employee> findAll()
    {
        return employeeRepository.getAll();
    }

    @GetMapping("/employees/{id}")
    public Employee findbyId(@PathVariable  Integer id)
    {
        return employeeRepository.findById(id);
    }

    @PutMapping("/employees")
    public String update( @RequestBody Employee employee)
    {
         employeeRepository.update(employee);
         return "Update successful";
    }

    @DeleteMapping("/employees/{id}")
    public String delete( @PathVariable("id") Integer id)
    {
        employeeRepository.delete(id);
        return "Deletion successful";
    }

}

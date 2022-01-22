package com.kgstrivers.androidapi.Controller;

import com.kgstrivers.androidapi.Model.Employee;
import com.kgstrivers.androidapi.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/rest")
public class EmployeeController {

    @Autowired
    private EmployeeRepository employeeRepository;


    @PostMapping("/employees")
    public Employee saveEmployee(@RequestBody Employee employee)
    {
        employeeRepository.saveEmployee(employee);
        return employee;
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
         return "Update Successfull";
    }

    @DeleteMapping("/employees/{id}")
    public String delete( @PathVariable("id") Integer id)
    {
        employeeRepository.delete(id);
        return "Deletion Successfull";
    }

}

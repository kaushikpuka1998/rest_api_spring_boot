package com.kgstrivers.androidapi.repository;

import com.kgstrivers.androidapi.Model.Employee;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Locale;


@Repository
public class EmployeeRepository {
    private HashOperations hashOperations;
    private RedisTemplate redisTemplate;

    public EmployeeRepository( RedisTemplate redisTemplate) {
        this.hashOperations = redisTemplate.opsForHash();
        this.redisTemplate = redisTemplate;
    }

    public void saveEmployee(Employee employee)
    {
        hashOperations.put("EMPLOYEE",employee.getId(),employee);
    }

    public List<Employee> getAll()
    {

        List<Employee> employees;
        employees = hashOperations.values("EMPLOYEE");
        return employees;
    }

    public Employee findById(Integer id)
    {
        return (Employee) hashOperations.get("EMPLOYEE",id);
    }

    public void update(Employee employee)
    {
        saveEmployee(employee);
    }

    public void delete(Integer id)
    {
        hashOperations.delete("EMPLOYEE",id);
    }

}

package com.grigorovich.springboot.spring_boot.dao;
import com.grigorovich.springboot.spring_boot.entity.Employee;

import java.util.List;

public interface EmployeeDAO {
    List<Employee> getAllEmployees();

    void saveEmployee(Employee employee);

    Employee getEmployee(int id);

    void deleteEmployee(int id);
}
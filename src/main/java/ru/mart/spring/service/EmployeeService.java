package ru.mart.spring.service;

import ru.mart.spring.model.Employee;

import java.util.List;

public interface EmployeeService {
    public void addEmployee(Employee employee);

    public void updateEmployeeId(long id);

    public void removeEmployeeId(long id);

    public Employee getEmployeeId(long id);

    public List<Employee> listEmployees();


}
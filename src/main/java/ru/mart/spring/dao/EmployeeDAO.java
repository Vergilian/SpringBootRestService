package ru.mart.spring.dao;

import ru.mart.spring.model.Employee;

import java.util.List;

public interface EmployeeDAO {
    public void addEmployee(Employee employee);

    public void updateEmployee(long id);

    public void removeEmployee(long id);

    public Employee getEmployeeId(long id);

    public List<Employee> listEmployees();
}
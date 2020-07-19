package ru.mart.spring.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.mart.spring.model.Employee;
import ru.mart.spring.dao.EmployeeDAO;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private EmployeeDAO employeeDAO;

    public void setEmployeeDAO(EmployeeDAO employeeDAO) {
        this.employeeDAO = employeeDAO;
    }

    @Override
    @Transactional
    public void addEmployee(Employee employee) {
        this.employeeDAO.addEmployee(employee);
    }

    @Override
    @Transactional
    public void updateEmployeeId(long id) {
        this.employeeDAO.updateEmployee(id);
    }

    @Override
    @Transactional
    public void removeEmployeeId(long id) {
        this.employeeDAO.removeEmployee(id);
    }

    @Override
    @Transactional
    public Employee getEmployeeId(long id) {
        return this.employeeDAO.getEmployeeId(id);
    }

    @Override
    @Transactional
    public List<Employee> listEmployees() {
        return this.employeeDAO.listEmployees();
    }

}
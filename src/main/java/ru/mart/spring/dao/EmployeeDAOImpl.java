package ru.mart.spring.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;
import ru.mart.spring.model.Employee;

import java.util.List;

@Repository
public class EmployeeDAOImpl implements EmployeeDAO {
    private static final Logger logger = LoggerFactory.getLogger(EmployeeDAOImpl.class);

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    private SessionFactory sessionFactory;

    @Override
    public void addEmployee(Employee employee) {
        Session session = this.sessionFactory.getCurrentSession();
        session.persist(employee);
        logger.info("Employee successful saved. Employee details: " + employee);
    }

    @Override
    public void updateEmployee(long id) {
        Session session = this.sessionFactory.getCurrentSession();
        session.update(id);
        logger.info("Employee successful udpate. Employee details: " + id);
    }

    @Override
    public void removeEmployee(long id) {
        Session session = this.sessionFactory.getCurrentSession();
        Employee employee = (Employee) session.load(Employee.class, new long[(int) id]);
        if (employee != null) {
            session.delete(employee);
            logger.info("Employee successful removed. Employee details: " + employee);
        }
    }

    @Override
    public Employee getEmployeeId(long id) {
        Session session = this.sessionFactory.getCurrentSession();
        Employee employee = (Employee) session.load(Employee.class, new long[(int) id]);
        logger.info("Employee succeseful loaded. Employee details: " + employee);

        return employee;
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<Employee> listEmployees() {
        Session session = this.sessionFactory.getCurrentSession();
        List<Employee> employeeList = session.createQuery("from Employee ").list();

        for (Employee employee : employeeList) {
            logger.info("Employee list: " + employee);
        }
        return employeeList;
    }
}

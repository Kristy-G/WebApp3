package services;

import dao.EmployeeDao;
import tables.Employee;
import tables.OrderTable;

import java.util.List;

public class EmployeeService {
    private EmployeeDao employeeDao = new EmployeeDao();

    public EmployeeService() {
    }

    public Employee findEmployee(int id) {
        return employeeDao.findById(id);
    }

    public void saveEmployee(Employee employee) {
        employeeDao.save(employee);
    }

    public void deleteEmployee(Employee employee) {
        employeeDao.delete(employee);
    }

    public void updateEmployee(Employee employee) {
        employeeDao.update(employee);
    }

    public List findAllEmployees() {
        return employeeDao.findAll();
    }

    public OrderTable findOrderById(int id) {
        return employeeDao.findOrderById(id);
    }

    public List<Employee> findByName(String s) {
        return employeeDao.findByName(s);
    }

    public List<Employee> findBySecondName(String s) {
        return employeeDao.findBySecondName(s);
    }

    public List<Employee> findBySurname(String s) {
        return employeeDao.findBySurname(s);
    }

    public List<Employee> findByPosition(String s) {
        return employeeDao.findByPosition(s);
    }

}

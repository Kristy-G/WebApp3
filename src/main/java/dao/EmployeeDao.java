package dao;

import org.hibernate.Session;
import org.hibernate.Transaction;
import tables.Employee;
import tables.OrderTable;
import utils.HibernateSessionFactoryUtil;

import java.util.List;

public class EmployeeDao {
    public Employee findById(int id) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Employee e = session.get(Employee.class, id);
        session.close();
        return e;
    }

    public void save(Employee employee) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.save(employee);
        tx1.commit();
        session.close();
    }

    public void update(Employee employee) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.update(employee);
        tx1.commit();
        session.close();
    }

    public void delete(Employee employee) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.delete(employee);
        tx1.commit();
        session.close();
    }

    public OrderTable findOrderById(int id) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        OrderTable o = session.get(OrderTable.class, id);
        session.close();
        return o;
    }

    public List findAll() {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        List<Employee> employees = session.createQuery("From Employee ").list();
        session.close();
        return employees;
    }

    public List<Employee> findByName(String name) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        List<Employee> employees = session.createQuery("from Employee where Name = '" + name + "'").list();
        session.close();
        return employees;
    }

    public List<Employee> findBySecondName(String name) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        List<Employee> employees = session.createQuery("from Employee where Second_name = '" + name + "'").list();
        session.close();
        return employees;
    }

    public List<Employee> findBySurname(String surname) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        List<Employee> employees = session.createQuery("from Employee where Surname = '" + surname + "'").list();
        session.close();
        return employees;
    }

    public List<Employee> findByPosition(String position) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        List<Employee> employees = session.createQuery("from Employee where Position = '" + position + "'").list();
        session.close();
        return employees;
    }
}

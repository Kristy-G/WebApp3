package dao;

import org.hibernate.Session;
import org.hibernate.Transaction;
import tables.Employee;
import tables.Subdivision;
import utils.HibernateSessionFactoryUtil;

import java.util.List;

public class SubdivisionDao {
    public Subdivision findById(int id) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Subdivision s = session.get(Subdivision.class, id);
        session.close();
        return s;
    }

    public void save(Subdivision subdivision) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.save(subdivision);
        tx1.commit();
        session.close();
    }

    public void update(Subdivision subdivision) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.update(subdivision);
        tx1.commit();
        session.close();
    }

    public void delete(Subdivision subdivision) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.delete(subdivision);
        tx1.commit();
        session.close();
    }

    public Employee findEmployeeById(int id) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Employee e = session.get(Employee.class, id);
        session.close();
        return e;
    }

    public List<Subdivision> findAll() {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        List<Subdivision> subdivisions =  session.createQuery("From Subdivision ").list();
        session.close();
        return subdivisions;
    }

    public List<Subdivision> findByName(String name) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        List<Subdivision> subdivisions = session.createQuery("from Subdivision where Subdivision_name = '" + name + "'").list();
        session.close();
        return subdivisions;
    }

    public List<Subdivision> findByContactDetails(String cd) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        List<Subdivision> subdivisions = session.createQuery("from Subdivision where Contact_details = '" + cd + "'").list();
        session.close();
        return subdivisions;
    }

    public List<Subdivision> findByManager(String manager) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        List<Subdivision> subdivisions = session.createQuery("from Subdivision where Manager = '" + manager + "'").list();
        session.close();
        return subdivisions;
    }
}

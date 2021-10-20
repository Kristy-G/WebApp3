package dao;

import org.hibernate.Session;
import org.hibernate.Transaction;
import tables.OrderTable;
import utils.HibernateSessionFactoryUtil;

import java.util.List;

public class OrderDao {
    public OrderTable findById(int id) {
        return HibernateSessionFactoryUtil.getSessionFactory().openSession().get(OrderTable.class, id);
    }

    public void save(OrderTable orderTable) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.save(orderTable);
        tx1.commit();
        session.close();
    }

    public void update(OrderTable orderTable) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.update(orderTable);
        tx1.commit();
        session.close();
    }

    public void delete(OrderTable orderTable) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.delete(orderTable);
        tx1.commit();
        session.close();
    }

    public List findAll() {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        List<OrderTable> orderTable = session.createQuery("From OrderTable ").list();
        session.close();
        return orderTable;
    }

    public List<OrderTable> findBySubject(String subject) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        List<OrderTable> orders = session.createQuery("from OrderTable where Subject_of_order = '" + subject + "'").list();
        session.close();
        return orders;
    }

    public List<OrderTable> findByDeadline(String deadline) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        List<OrderTable> orders = session.createQuery("from OrderTable where Deadline = '" + deadline + "'").list();
        session.close();
        return orders;
    }
}

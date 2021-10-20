package dao;

import org.hibernate.Session;
import org.hibernate.Transaction;
import tables.Organization;
import tables.Subdivision;
import utils.HibernateSessionFactoryUtil;

import java.util.List;

public class OrganizationDao {
    public Organization findById(int id) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Organization c = session.get(Organization.class, id);
        session.close();
        return c;
    }

    public void save(Organization organization) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.save(organization);
        tx1.commit();
        session.close();
    }

    public void update(Organization organization) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.update(organization);
        tx1.commit();
        session.close();
    }

    public void delete(Organization organization) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.delete(organization);
        tx1.commit();
        session.close();
    }

    public Subdivision findSubdivisionById(int id) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Subdivision subdivision = session.get(Subdivision.class, id);
        return subdivision;
    }

    public List findAll() {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        List<Organization> organizations = session.createQuery("from Organization").list();
        session.close();
        return organizations;
    }

    public List findByName(String name) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        List<Organization> organizations = session.createQuery("from Organization where Organization_name = '" + name + "'").list();
        session.close();
        return organizations;
    }

    public List findByAdress(String adress) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        List<Organization> organizations = session.createQuery("from Organization where Physical_adress = '" + adress + "'").list();
        session.close();
        return organizations;
    }

    public List findByLegalAdress(String adress) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        List<Organization> organizations = session.createQuery("from Organization where Legal_adress = '" + adress + "'").list();
        session.close();
        return organizations;
    }

    public List findByDirector(String director) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        List<Organization> organizations = session.createQuery("from Organization where Director = '" + director + "'").list();
        session.close();
        return organizations;
    }
}

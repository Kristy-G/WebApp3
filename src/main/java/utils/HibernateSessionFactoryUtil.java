package utils;

import tables.Employee;
import tables.OrderTable;
import tables.Organization;
import tables.Subdivision;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;


public class HibernateSessionFactoryUtil {

    private static SessionFactory sessionFactory;

    private HibernateSessionFactoryUtil() {}

    public static SessionFactory getSessionFactory() {
        if (sessionFactory == null) {
            try {
                Configuration configuration = new Configuration().configure();
                configuration.addAnnotatedClass(Organization.class);
                configuration.addAnnotatedClass(Subdivision.class);
                configuration.addAnnotatedClass(Employee.class);
                configuration.addAnnotatedClass(OrderTable.class);
                StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties());
                sessionFactory = configuration.buildSessionFactory(builder.build());

            } catch (Exception e) {

            }
        }
        return sessionFactory;
    }
}

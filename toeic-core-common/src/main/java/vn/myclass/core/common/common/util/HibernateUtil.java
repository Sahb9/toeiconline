package vn.myclass.core.common.common.util;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;


public class HibernateUtil {
    private static SessionFactory sessionFactory;
    private static ServiceRegistry serviceRegistry;
    private static final SessionFactory SessionFactory = buildSessionFactory();

    private static SessionFactory buildSessionFactory() {
        try {
            //create session factory from hibernate configuration
            return new Configuration().configure().buildSessionFactory();
//            Configuration configuration = new Configuration();
//            configuration.configure();
//            ServiceRegistry serviceRegistry = new ServiceRegistryBuilder().applySettings(
//                    configuration.getProperties()). buildServiceRegistry();
//            sessionFactory = configuration.buildSessionFactory(serviceRegistry);
//            return sessionFactory;
        } catch (Exception e) {
            System.out.println("session factory fail");
            throw new ExceptionInInitializerError(e);
        }
    }

    public static SessionFactory getSessionFactory() {
        return SessionFactory;
    }
}

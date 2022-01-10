package vn.myclass.core.common.common.util;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {

    private static final SessionFactory SessionFactory = buildSessionFactory();

    private static SessionFactory buildSessionFactory() {
        try {
            //create session factory from hibernate configuration
            return new Configuration().configure().buildSessionFactory();
        } catch (Exception e) {
            System.out.println("session factory fail");
            throw new ExceptionInInitializerError(e);
        }
    }

    public static SessionFactory getSessionFactory() {
        return SessionFactory;
    }
}

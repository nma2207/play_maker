//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package server.util;

import java.io.File;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {
    private static final SessionFactory sessionFactory;

    public HibernateUtil() {
    }

    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    static {
        try {
            sessionFactory = (new Configuration()).configure(new File("./src/server/resources/hibernate.cfg.xml")).buildSessionFactory();
        } catch (Throwable var1) {
            System.err.println("Initial SessionFactory creation failed. " + var1);
            var1.printStackTrace();
            throw new ExceptionInInitializerError(var1);
        }
    }
}

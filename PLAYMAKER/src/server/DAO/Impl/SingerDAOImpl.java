//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package server.DAO.Impl;

import server.DAO.SingerDAO;
import java.awt.Component;
import java.util.ArrayList;
import java.util.Collection;
import javax.swing.JOptionPane;
import org.hibernate.Session;
import server.pack.Singer;
import server.util.HibernateUtil;

public class SingerDAOImpl implements SingerDAO {
    public SingerDAOImpl() {
    }

    public void addSinger(Singer singer, Session session) {
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.save(singer);
            session.getTransaction().commit();
        } catch (Exception var4) {
            JOptionPane.showMessageDialog((Component)null, var4.getMessage(), "Ошибка при добавлении Singer", 0);
        }

    }

    public Singer getSingerById(int idsinger, Session session) {
        Singer singer = null;

        try {
            session = HibernateUtil.getSessionFactory().openSession();
            singer = (Singer)session.load(Singer.class, idsinger);
        } catch (Exception var5) {
            JOptionPane.showMessageDialog((Component)null, var5.getMessage(), "Ошибка 'findById' Singer", 0);
        }

        return singer;
    }

    public Collection getAllSingers(Session session) {
        Object singers = new ArrayList();

        try {
            session = HibernateUtil.getSessionFactory().openSession();
            singers = session.createCriteria(Singer.class).list();
        } catch (Exception var4) {
            JOptionPane.showMessageDialog((Component)null, var4.getMessage(), "Ошибка 'getAll' Singer", 0);
        }

        return (Collection)singers;
    }

    public void deleteSinger(Singer singer, Session session) {
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.delete(singer);
            session.getTransaction().commit();
        } catch (Exception var4) {
            JOptionPane.showMessageDialog((Component)null, var4.getMessage(), "Ошибка при удалении Singer", 0);
        }

    }
}

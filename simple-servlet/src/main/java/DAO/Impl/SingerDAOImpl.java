package DAO.Impl;

import DAO.SingerDAO;
import pack.Singer;

import java.sql.SQLException;
import java.util.Collection;
import java.util.ArrayList;
import java.util.List;
import util.HibernateUtil;
import javax.swing.*;
import org.hibernate.Session;

public class SingerDAOImpl implements SingerDAO {
    public void addSinger(Singer singer) throws SQLException{
        Session session = null;
        try
        {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.save(singer);
            session.getTransaction().commit();
        }
        catch (Exception e)
        {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Ошибка при добавлении Singer", JOptionPane.OK_OPTION);
        }
        finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
    }
    public Singer getSingerById(int idsinger) throws SQLException
    {
        Session session = null;
        Singer singer = null;
        try
        {
            session = HibernateUtil.getSessionFactory().openSession();
            singer = (Singer) session.load(Singer.class, idsinger);
        }
        catch (Exception e)
        {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Ошибка 'findById' Singer", JOptionPane.OK_OPTION);
        }
        finally
        {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
        return singer;
    }
    public Collection getAllSingers() throws SQLException {
        Session session = null;
        List singers = new ArrayList<Singer>();
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            singers = session.createCriteria(Singer.class).list();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Ошибка 'getAll' Singer", JOptionPane.OK_OPTION);
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
        return singers;
    }

    public void deleteSinger(Singer singer) throws SQLException {
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.delete(singer);
            session.getTransaction().commit();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Ошибка при удалении Singer", JOptionPane.OK_OPTION);
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
    }


}
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
    public void addSinger(Singer singer, Session session) {
        //Session session = null;
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

    }
    public Singer getSingerById(int idsinger, Session session)
    {
        //Session session = null;
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
        return singer;
    }
    public Collection getAllSingers(Session session){
        //Session session = null;
        List singers = new ArrayList<Singer>();
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            singers = session.createCriteria(Singer.class).list();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Ошибка 'getAll' Singer", JOptionPane.OK_OPTION);
        }
        return singers;
    }

    public void deleteSinger(Singer singer, Session session){
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.delete(singer);
            session.getTransaction().commit();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Ошибка при удалении Singer", JOptionPane.OK_OPTION);
        }
    }


}
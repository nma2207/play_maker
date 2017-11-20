package DAO.Impl;

import DAO.SongsDAO;
import org.hibernate.query.Query;
import pack.Singer;
import pack.Songs;
import pack.Genre;

import java.sql.SQLException;
import java.util.Collection;
import java.util.ArrayList;
import java.util.List;
import util.HibernateUtil;
import javax.swing.*;
import org.hibernate.Session;

public class SongsDAOImpl implements SongsDAO{
    public void addSong(Songs songs, Session session) {
       // Session session = null;
        try
        {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.save(songs);
            session.getTransaction().commit();
        }
        catch (Exception e)
        {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Ошибка при добавлении Songs", JOptionPane.OK_OPTION);
        }

    }
    public Songs getSongById(int idsong, Session session)
    {
        Songs songs = null;
        try
        {
            session = HibernateUtil.getSessionFactory().openSession();
            songs = (Songs) session.load(Songs.class, idsong);
        }
        catch (Exception e)
        {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Ошибка 'findById' Songs", JOptionPane.OK_OPTION);
        }
        return songs;
    }
    public Collection getAllSongs(Session session)  {
        //Session session = null;
        List songs = new ArrayList<Songs>();
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            songs = session.createCriteria(Songs.class).list();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Ошибка 'getAll' Songs", JOptionPane.OK_OPTION);
        }
        return songs;
    }

    public void deleteSong(Songs songs, Session session) {
        //Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.delete(songs);
            session.getTransaction();//.commit();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Ошибка при удалении Songs", JOptionPane.OK_OPTION);
        }
    }

    public Collection getSongsBySinger(Singer singer, Session session){

        List songs = new ArrayList<Songs>();
        try {
            session = HibernateUtil.getSessionFactory().getCurrentSession();
            session.beginTransaction();
            int idsinger = singer.getIdsinger();
            Query query = session.createQuery(" select s "+ " from Songs s"+ " where s.singer_idsinger = :singerId ").setInteger("singerId",idsinger);
            songs = (List<Songs>)query.list();
            session.getTransaction();//.commit();
        }
        catch (Exception e)
        {
            System.out.println(e.fillInStackTrace());
        }
        return songs;
    }

    public Collection getSongsByGenre(Genre genre,Session session) {
        List songs = new ArrayList<Songs>();
        try {
            session = HibernateUtil.getSessionFactory().getCurrentSession();
            session.beginTransaction();
            int idgenre = genre.getIdgenre();
            Query query = session.createQuery(" select s "+ " from Songs s"+ " where s.genre_idgenre = :genreId ").setInteger("genreId",idgenre);
            songs = (List<Songs>)query.list();
            session.getTransaction();//.commit();

        }
        catch (Exception e)
        {
            System.out.println(e.fillInStackTrace());
        }
        return songs;
    }
}
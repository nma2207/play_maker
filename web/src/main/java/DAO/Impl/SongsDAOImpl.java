package DAO.Impl;

import DAO.SongsDAO;
import converter.Converter;
import org.hibernate.Query;
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
    public void addSong(Songs songs) throws SQLException{
        Session session = null;
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
        finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
    }
    public Songs getSongById(int idsong) throws SQLException
    {
        Session session = null;
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
        finally
        {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
        return songs;
    }
    public Collection getAllSongs() throws SQLException {
        Session session = null;
        List songs = new ArrayList<Songs>();
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            songs = session.createCriteria(Songs.class).list();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Ошибка 'getAll' Songs", JOptionPane.OK_OPTION);
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
        return songs;
    }

    public void deleteSong(Songs songs) throws SQLException {
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.delete(songs);
            session.getTransaction().commit();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Ошибка при удалении Songs", JOptionPane.OK_OPTION);
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
    }

    public Collection getSongsBySinger(Singer singer) throws SQLException {
        Session session = null;
        List songs = new ArrayList<Songs>();
        try {
            session = HibernateUtil.getSessionFactory().getCurrentSession();
            session.beginTransaction();
            long idsinger = singer.getIdsinger();
            ArrayList<Singer> singers= Converter.singerConvert(session.createCriteria(Singer.class).list());
            for(Singer s:singers){
                if(s.getName_singer().equals(singer.getName_singer())) {
                    idsinger = s.getIdsinger();
                    break;
                }
            }
            Query query = session.createQuery(" select s "+ " from Songs s"+ " where s.singer_idsinger = :singerId ").setLong("singerId",idsinger);
            songs = (List<Songs>)query.list();
            session.getTransaction().commit();
        } finally {  if (session != null && session.isOpen())  session.close();}
        return songs;
    }

    public Collection getSongsByGenre(Genre genre) throws SQLException {
        Session session = null;
        List songs = new ArrayList<Songs>();
        try {
            session = HibernateUtil.getSessionFactory().getCurrentSession();
            session.beginTransaction();
            int idgenre = genre.getIdgenre();
            ArrayList<Genre> genres= Converter.genreConvert(session.createCriteria(Genre.class).list());
            for(Genre g: genres){
                if(g.getName_genre().equals(genre.getName_genre())) {
                    idgenre = g.getIdgenre();
                    break;
                }
            }
            Query query = session.createQuery(" select s "+ " from Songs s"+ " where s.genre_idgenre = :genreId ").setInteger("genreId",idgenre);
            songs = (List<Songs>)query.list();
            session.getTransaction().commit();
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
        return songs;
    }
    public Collection getSongsByName(String name) throws SQLException{
        Session session=null;
        List songs = new ArrayList<Songs>();
        try {
            session = HibernateUtil.getSessionFactory().getCurrentSession();
            session.beginTransaction();
            Query query = session.createQuery(" select s "+ " from Songs s"+ " where s.name_song= :name ").setString("name", name);
            songs = (List<Songs>)query.list();
            session.getTransaction().commit();
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
        return songs;

    }
}
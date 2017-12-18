//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package server.DAO.Impl;

import server.DAO.SongsDAO;
import java.awt.Component;
import java.util.ArrayList;
import java.util.Collection;
import javax.swing.JOptionPane;
import org.hibernate.Session;
import org.hibernate.query.Query;
import server.pack.Genre;
import server.pack.Singer;
import server.pack.Songs;
import server.util.HibernateUtil;

public class SongsDAOImpl implements SongsDAO {
    public SongsDAOImpl() {
    }

    public void addSong(Songs songs, Session session) {
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.save(songs);
            session.getTransaction().commit();
        } catch (Exception var4) {
            JOptionPane.showMessageDialog((Component)null, var4.getMessage(), "Ошибка при добавлении Songs", 0);
        }

    }

    public Songs getSongById(int idsong, Session session) {
        Songs songs = null;

        try {
            session = HibernateUtil.getSessionFactory().openSession();
            songs = (Songs)session.load(Songs.class, idsong);
        } catch (Exception var5) {
            JOptionPane.showMessageDialog((Component)null, var5.getMessage(), "Ошибка 'findById' Songs", 0);
        }

        return songs;
    }

    public Collection getAllSongs(Session session) {
        Object songs = new ArrayList();

        try {
            session = HibernateUtil.getSessionFactory().openSession();
            songs = session.createCriteria(Songs.class).list();
        } catch (Exception var4) {
            JOptionPane.showMessageDialog((Component)null, var4.getMessage(), "Ошибка 'getAll' Songs", 0);
        }

        return (Collection)songs;
    }

    public void deleteSong(Songs songs, Session session) {
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.delete(songs);
            session.getTransaction();
        } catch (Exception var4) {
            JOptionPane.showMessageDialog((Component)null, var4.getMessage(), "Ошибка при удалении Songs", 0);
        }

    }

    public Collection getSongsBySinger(Singer singer, Session session) {
        Object songs = new ArrayList();

        try {
            session = HibernateUtil.getSessionFactory().getCurrentSession();
            session.beginTransaction();
            int idsinger = singer.getIdsinger();
            Query query = session.createQuery(" select s  from Songs s where s.singer_idsinger = :singerId ").setInteger("singerId", idsinger);
            songs = query.list();
            session.getTransaction();
        } catch (Exception var6) {
            System.out.println(var6.fillInStackTrace());
        }

        return (Collection)songs;
    }

    public Collection getSongsByGenre(Genre genre, Session session) {
        Object songs = new ArrayList();

        try {
            session = HibernateUtil.getSessionFactory().getCurrentSession();
            session.beginTransaction();
            int idgenre = genre.getIdgenre();
            Query query = session.createQuery(" select s  from Songs s where s.genre_idgenre = :genreId ").setInteger("genreId", idgenre);
            songs = query.list();
            session.getTransaction();
        } catch (Exception var6) {
            System.out.println(var6.fillInStackTrace());
        }

        return (Collection)songs;
    }
}

//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package server.DAO.Impl;

import server.DAO.GenreDAO;
import java.awt.Component;
import java.util.ArrayList;
import java.util.Collection;
import javax.swing.JOptionPane;
import org.hibernate.Session;
import server.pack.Genre;
import server.util.HibernateUtil;

public class GenreDAOImpl implements GenreDAO {
    public GenreDAOImpl() {
    }

    public void addGenre(Genre genre, Session session) {
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.save(genre);
            session.getTransaction().commit();
        } catch (Exception var4) {
            JOptionPane.showMessageDialog((Component)null, var4.getMessage(), "Ошибка при добавлении Genre", 0);
        }

    }

    public Genre getGenreById(int idgenre, Session session) {
        Genre genre = null;

        try {
            session = HibernateUtil.getSessionFactory().openSession();
            genre = (Genre)session.load(Genre.class, idgenre);
        } catch (Exception var5) {
            JOptionPane.showMessageDialog((Component)null, var5.getMessage(), "Ошибка 'findById' Genre", 0);
        }

        return genre;
    }

    public Collection getAllGenres(Session session) {
        Object genres = new ArrayList();

        try {
            session = HibernateUtil.getSessionFactory().openSession();
            genres = session.createCriteria(Genre.class).list();
        } catch (Exception var4) {
            JOptionPane.showMessageDialog((Component)null, var4.getMessage(), "Ошибка 'getAll' Genre", 0);
        }

        return (Collection)genres;
    }

    public void deleteGenre(Genre genre, Session session) {
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.delete(genre);
            session.getTransaction().commit();
        } catch (Exception var4) {
            JOptionPane.showMessageDialog((Component)null, var4.getMessage(), "Ошибка при удалении Genre", 0);
        }

    }
}

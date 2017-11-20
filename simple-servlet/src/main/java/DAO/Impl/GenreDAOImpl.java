package DAO.Impl;

import DAO.GenreDAO;
import pack.Genre;

import java.sql.SQLException;
import java.util.Collection;
import java.util.ArrayList;
import java.util.List;
import util.HibernateUtil;
import javax.swing.*;
import org.hibernate.Session;

public class GenreDAOImpl implements GenreDAO {
    public void addGenre(Genre genre) throws SQLException{
        Session session = null;
        try
        {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.save(genre);
            session.getTransaction().commit();
        }
        catch (Exception e)
        {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Ошибка при добавлении Genre", JOptionPane.OK_OPTION);
        }
        finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
    }
    public Genre getGenreById(int idgenre) throws SQLException
    {
        Session session = null;
        Genre genre = null;
        try
        {
            session = HibernateUtil.getSessionFactory().openSession();
            genre = (Genre) session.load(Genre.class, idgenre);
        }
        catch (Exception e)
        {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Ошибка 'findById' Genre", JOptionPane.OK_OPTION);
        }
        finally
        {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
        return genre;
    }
    public Collection getAllGenres() throws SQLException {
        Session session = null;
        List genres = new ArrayList<Genre>();
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            genres = session.createCriteria(Genre.class).list();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Ошибка 'getAll' Genre", JOptionPane.OK_OPTION);
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
        return genres;
    }

    public void deleteGenre(Genre genre) throws SQLException {
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.delete(genre);
            session.getTransaction().commit();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Ошибка при удалении Genre", JOptionPane.OK_OPTION);
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
    }



}
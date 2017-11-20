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
    public void addGenre(Genre genre, Session session) {
        //Session session = null;
        try
        {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.save(genre);
            session.getTransaction().commit();
        }
        catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Ошибка при добавлении Genre", JOptionPane.OK_OPTION);
        }
    }
    public Genre getGenreById(int idgenre, Session session)
    {
       // Session session = null;
        Genre genre = null;
        try
        {
            session = HibernateUtil.getSessionFactory().openSession();
            genre = (Genre) session.load(Genre.class, idgenre);
        }
        catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Ошибка 'findById' Genre", JOptionPane.OK_OPTION);
        }
        return genre;
    }
    public Collection getAllGenres(Session session){
        //Session session = null;
        List genres = new ArrayList<Genre>();
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            genres = session.createCriteria(Genre.class).list();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Ошибка 'getAll' Genre", JOptionPane.OK_OPTION);
        }
        return genres;
    }

    public void deleteGenre(Genre genre, Session session) {
        //Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.delete(genre);
            session.getTransaction().commit();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Ошибка при удалении Genre", JOptionPane.OK_OPTION);
        }
    }



}
package DAO;

import org.hibernate.Session;
import pack.Singer;
import pack.Genre;
import pack.Songs;

import java.util.Collection;
import java.sql.SQLException;

public interface GenreDAO {
    public void addGenre(Genre genre, Session session);
    public Genre getGenreById(int idgenre, Session session) ;
    public Collection getAllGenres(Session session) ;
    public void deleteGenre(Genre genre, Session session);
}
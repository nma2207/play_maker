package DAO;

import pack.Singer;
import pack.Genre;
import pack.Songs;

import java.util.Collection;
import java.sql.SQLException;

public interface GenreDAO {
    public void addGenre(Genre genre) throws SQLException;
    public Genre getGenreById(int idgenre) throws SQLException;
    public Collection getAllGenres() throws SQLException;
    public void deleteGenre(Genre genre) throws SQLException;
}
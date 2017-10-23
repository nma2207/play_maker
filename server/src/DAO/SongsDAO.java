package DAO;

import pack.Singer;
import pack.Genre;
import pack.Songs;

import java.util.Collection;
import java.sql.SQLException;

public interface SongsDAO {
    public void addSong(Songs songs) throws SQLException;
    public Songs getSongById(int idsong) throws SQLException;
    public Collection getAllSongs() throws SQLException;
    public void deleteSong(Songs songs) throws SQLException;
    public Collection getSongsBySinger(Singer singer) throws SQLException;
    public Collection getSongsByGenre(Genre genre) throws SQLException;
}
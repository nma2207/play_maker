package DAO;

import org.hibernate.Session;
import pack.Singer;
import pack.Genre;
import pack.Songs;

import java.util.Collection;
import java.sql.SQLException;

public interface SongsDAO {
    public void addSong(Songs songs, Session session) ;
    public Songs getSongById(int idsong, Session session);
    public Collection getAllSongs(Session session) ;
    public void deleteSong(Songs songs, Session session) ;
    public Collection getSongsBySinger(Singer singer, Session session);
    public Collection getSongsByGenre(Genre genre, Session session) ;
}
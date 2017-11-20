package DAO;

import org.hibernate.Session;
import pack.Singer;
import pack.Genre;
import pack.Songs;

import java.util.ArrayList;
import java.util.Collection;
import java.sql.SQLException;

public interface SingerDAO {
    public void addSinger(Singer singer, Session session);
    public Singer getSingerById(int idsinger, Session session);
    public Collection getAllSingers(Session session) ;
    public void deleteSinger(Singer singer, Session session);

}
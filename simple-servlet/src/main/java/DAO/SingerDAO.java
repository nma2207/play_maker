package DAO;

import pack.Singer;
import pack.Genre;
import pack.Songs;

import java.util.Collection;
import java.sql.SQLException;

public interface SingerDAO {
    public void addSinger(Singer singer) throws SQLException;
    public Singer getSingerById(int idsinger) throws SQLException;
    public Collection getAllSingers() throws SQLException;
    public void deleteSinger(Singer singer) throws SQLException;

}
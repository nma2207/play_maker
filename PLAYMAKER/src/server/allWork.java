//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//
package server;
import server.DAO.GenreDAO;
import server.DAO.SingerDAO;
import server.DAO.SongsDAO;
import server.DAO.Impl.GenreDAOImpl;
import server.DAO.Impl.SingerDAOImpl;
import server.DAO.Impl.SongsDAOImpl;

public class allWork {
    private static GenreDAO genreDAO = null;
    private static SingerDAO singerDAO = null;
    private static SongsDAO songsDAO = null;
    private static allWork instance = null;

    public allWork() {
    }

    public static synchronized allWork getInstance() {
        if (instance == null) {
            instance = new allWork();
        }

        return instance;
    }

    public GenreDAO getGenreDAO() {
        if (genreDAO == null) {
            genreDAO = new GenreDAOImpl();
        }

        return genreDAO;
    }

    public static SingerDAO getSingerDAO() {
        if (singerDAO == null) {
            singerDAO = new SingerDAOImpl();
        }

        return singerDAO;
    }

    public static SongsDAO getSongsDAO() {
        if (songsDAO == null) {
            songsDAO = new SongsDAOImpl();
        }

        return songsDAO;
    }
}

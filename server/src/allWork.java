import DAO.GenreDAO;
import DAO.Impl.GenreDAOImpl;
import DAO.Impl.SingerDAOImpl;
import DAO.Impl.SongsDAOImpl;
import DAO.SingerDAO;
import DAO.SongsDAO;
import pack.Singer;

public class allWork {
    private static GenreDAO genreDAO = null;
    private static SingerDAO singerDAO = null;
    private static SongsDAO songsDAO = null;
    private static allWork instance = null;

    public static synchronized allWork getInstance(){
        if (instance == null){
            instance = new allWork();
        }
        return instance;
    }

    public GenreDAO getGenreDAO(){
        if (genreDAO == null){
            genreDAO= new GenreDAOImpl();
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
        if (songsDAO == null){
            songsDAO = new SongsDAOImpl();
        }
        return songsDAO;
    }

}

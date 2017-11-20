import org.hibernate.HibernateException;
import org.hibernate.Metamodel;
import org.hibernate.query.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import pack.Genre;
import pack.Singer;
import pack.Songs;

import java.util.Collection;
import java.sql.SQLException;
import javax.persistence.metamodel.EntityType;

import java.util.Iterator;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws SQLException {
        /**Collection singers = allWork.getInstance().getSingerDAO().getAllSingers();
         Iterator iterator = singers.iterator();
         System.out.println("========Все    исполнители=========");
         while (iterator.hasNext()) {
         Singer singer= (Singer) iterator.next();
         System.out.println(singer.getIdsinger() + ". Исполнитель: " + singer.getName_singer());
         Collection songs = allWork.getInstance().getSongsDAO().getSongsBySinger(singer);
         Iterator iterator2 = songs.iterator();
         while (iterator2.hasNext()) {
         Songs song = (Songs) iterator2.next();
         System.out.println(song.getIdsongs() + ". Песня: " + song.getName_song() + ", " + song.getDurability() + ", "+singer.getName_singer());
         }
         }
         Collection genres = allWork.getInstance().getGenreDAO().getAllGenres();
         iterator = genres.iterator();
         System.out.println("========Все    жанры=========");
         while (iterator.hasNext()) {
         Genre genre = (Genre) iterator.next();
         System.out.println(genre.getIdgenre() + ". Жанр: " +  genre.getName_genre());
         Collection songs = allWork.getInstance().getSongsDAO().getSongsByGenre(genre);
         Iterator iterator2 = songs.iterator();
         while (iterator2.hasNext()) {
         Songs song = (Songs) iterator2.next();
         System.out.println(song.getIdsongs() + ". Песня: " + song.getName_song() + ", " + song.getDurability() );
         }
         }
         **/
    }
}
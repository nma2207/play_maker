//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package server.DAO;

import java.util.Collection;
import org.hibernate.Session;
import server.pack.Genre;

public interface GenreDAO {
    void addGenre(Genre var1, Session var2);

    Genre getGenreById(int var1, Session var2);

    Collection getAllGenres(Session var1);

    void deleteGenre(Genre var1, Session var2);
}

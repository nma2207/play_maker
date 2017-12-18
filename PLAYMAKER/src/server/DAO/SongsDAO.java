//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package server.DAO;

import java.util.Collection;
import org.hibernate.Session;
import server.pack.Genre;
import server.pack.Singer;
import server.pack.Songs;

public interface SongsDAO {
    void addSong(Songs var1, Session var2);

    Songs getSongById(int var1, Session var2);

    Collection getAllSongs(Session var1);

    void deleteSong(Songs var1, Session var2);

    Collection getSongsBySinger(Singer var1, Session var2);

    Collection getSongsByGenre(Genre var1, Session var2);
}

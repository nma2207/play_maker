//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package server.DAO;

import java.util.Collection;
import org.hibernate.Session;
import server.pack.Singer;

public interface SingerDAO {
    void addSinger(Singer var1, Session var2);

    Singer getSingerById(int var1, Session var2);

    Collection getAllSingers(Session var1);

    void deleteSinger(Singer var1, Session var2);
}

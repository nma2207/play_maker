package pack;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Set;
import java.util.HashSet;

@Entity
@Table
public class Songs implements Serializable {
    @Id
    private int idsongs;
    private String name_song;
    private String durability;
    private String path;
    private int singer_idsinger;
    private int genre_idgenre;
    /*private Set singers = new HashSet();
    private Set genres = new HashSet();*/
    public Songs(){}
/*
    public void setSingers(Set singers) {
        this.singers = singers;
    }

    public void setGenres(Set genres) {
        this.genres = genres;
    }*/

    public void setSinger_idsinger(int singer_idsinger) {
        this.singer_idsinger = singer_idsinger;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public void setGenre_idgenre(int genre_idgenre) {
        this.genre_idgenre = genre_idgenre;
    }

    public void setDurability(String durability) {
        this.durability = durability;
    }

    public void setIdsongs(int idsongs) {
        this.idsongs = idsongs;
    }

    public void setName_song(String name_song) {
        this.name_song = name_song;
    }

    /*public Set getSingers() {
       return singers;
   }

    public Set getGenres() {
      return genres;
 }*/
    public int getSinger_idsinger() {
        return singer_idsinger;
    }

    public int getGenre_idgenre() {
        return genre_idgenre;
    }

    public int getIdsongs() {
        return idsongs;
    }

    public String getDurability() {
        return durability;
    }

    public String getName_song() {
        return name_song;
    }

    public String getPath() {
        return path;
    }
}

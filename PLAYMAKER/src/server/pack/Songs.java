//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package server.pack;

public class Songs {
    private int idsongs;
    private String name_song;
    private String durability;
    private String path;
    private int singer_idsinger;
    private int genre_idgenre;

    public Songs() {
    }

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

    public int getSinger_idsinger() {
        return this.singer_idsinger;
    }

    public int getGenre_idgenre() {
        return this.genre_idgenre;
    }

    public int getIdsongs() {
        return this.idsongs;
    }

    public String getDurability() {
        return this.durability;
    }

    public String getName_song() {
        return this.name_song;
    }

    public String getPath() {
        return this.path;
    }
}

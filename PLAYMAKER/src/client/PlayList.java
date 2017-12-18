package client;

public class PlayList {
    String Singer;
    String Song;
    String Genre;
    public PlayList(String sing, String song, String gen)
    {
        Singer=sing;
        Song=song;
        Genre=gen;
    }
    PlayList(){}
    public void setSinger(String s)
    {
        Singer=s;
    }
    public void setSong(String s)
    {
        Song=s;
    }
    public void setGenre(String s) { Genre=s; }
    public String getSinger() {
        return Singer;
    }
    public String getSong() {
        return Song;
    }
    public String getGenre() {
        return Genre;
    }
}

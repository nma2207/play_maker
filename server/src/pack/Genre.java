package pack;

public class Genre {
    private int idgenre;
    private String name_genre;
    public Genre(){}

    public void setName_genre(String name_genre) {
        this.name_genre = name_genre;
    }
    public void setIdgenre(int idgenre) {
        this.idgenre = idgenre;
    }
    public String getName_genre() {
        return name_genre;
    }
    public int getIdgenre() {
        return idgenre;
    }
}

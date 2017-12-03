package pack;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
@Entity
@Table
public class Genre implements Serializable{
    @Id
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

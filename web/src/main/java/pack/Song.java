package pack;

public class Song {
    String name;
    String singer;
    String path;
    public String getName(){return name;}

    public String getSinger() {
        return singer;
    }

    public String getPath() {
        return path;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public void setSinger(String singer) {
        this.singer = singer;
    }
}

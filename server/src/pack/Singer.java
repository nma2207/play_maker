package pack;

public class Singer {
    private int idsinger;
    private String name_singer;
    public Singer(){}

    public void setName_singer(String name_singer) {
        this.name_singer = name_singer;
    }

    public void setIdsinger(int idsinger) {
        this.idsinger = idsinger;
    }

    public String getName_singer() {
        return name_singer;
    }

    public int getIdsinger() {
        return idsinger;
    }
}

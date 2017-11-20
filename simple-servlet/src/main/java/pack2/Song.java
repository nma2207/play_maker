package pack2;

import org.json.simple.JSONObject;

public class Song implements  Jsonable{
    int id;
    String singerName;
    String genre;
    String name;
    String durability;
    private String path;
    public Song(){}
    public Song(String name, String genre, String singerName, String durability){
        this.name = name;
        this.genre = genre;
        this.singerName = singerName;
        this.durability = durability;

    }

    public String getSingerName() {
        return singerName;
    }

    public String getGenre() {
        return genre;
    }

    public String getName() {
        return name;
    }

    public String getDurability() {
        return durability;
    }

    public void setSingerName(String singerName){
        this.singerName = singerName;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }
    public void setName(String name){
        this.name = name;
    }
    public void setDurability(String durability){
        this.durability = durability;
    }
    public int getId(){
        return id;
    }
    public void setId(int id){
        this.id = id;
    }

    public JSONObject toJSON(){
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("id", id);
        jsonObject.put("singerName", singerName);
        jsonObject.put("genre", genre);
        jsonObject.put("name", name);
        jsonObject.put("durability", durability);
        return jsonObject;
    }

    public void fromJSON(JSONObject jsonObject)throws  Exception{
            //id =Integer.parseInt(jsonObject.getOrDefault("id", 0).toString());
            singerName =(String)jsonObject.get("singerName");
            genre = (String)jsonObject.get("genre");
            name = (String)jsonObject.get("name");

    }
}

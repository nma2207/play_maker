package pack2;

import org.json.simple.JSONObject;

public class Genre implements Jsonable {
    int id; // может и не надо
    String genre;
    public Genre(){}
    public Genre(String genre){
        this.genre = genre;
    }
    public Genre(int id, String genre){
        this.id = id;
        this.genre = genre;
    }
    public String getGenre(){
        return genre;
    }
    public void setGenre(String genre){
        this.genre = genre;
    }
    public int getId(){
        return id;
    }
    public void setId(int id){
        this.id = id;
    }

    public JSONObject toJSON(){
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("id",id);
        jsonObject.put("genre", genre);
        return jsonObject;
    }

    public void fromJSON(JSONObject jsonObject) throws Exception
    {
        try{
            genre = (String)jsonObject.get("genre");
            //id = Integer.parseInt(jsonObject.getOrDefault("id", 0).toString());
        }
        catch (Exception e){
            throw new Exception("Cannot parse for Genre");
        }
    }

}

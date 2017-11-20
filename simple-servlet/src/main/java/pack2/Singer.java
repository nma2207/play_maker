package pack2;
import org.json.simple.JSONObject;
public class Singer implements Jsonable{
    String name;
    int id; //не знаю, надо ли
    public Singer() {
        name = null;
    }
    public Singer(String name){
        this.name = name;
    }
    public Singer(int id, String name){
        this.id = id;
        this.name = name;
    }
    public String getName(){
        return  name;
    }
    public void setName(){
        this.name = name;
    }
    public int getId(){
        return id;
    }
    public void setId(int id){
        this.id = id;
    }

    public JSONObject toJSON(){
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("name", name);
        jsonObject.put("id", id);
        return jsonObject;
    }

    public void fromJSON(JSONObject jsonObject) throws Exception{
        try {
            name = (String) jsonObject.get("name");
            //id = Integer.parseInt(jsonObject.getOrDefault("id", 0).toString());
        }
        catch (Exception e){
            System.out.println(e.getMessage());
            throw new Exception("Cannot parse for Singer");
        }

    }
}

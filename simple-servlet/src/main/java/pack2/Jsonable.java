package pack2;
import org.json.simple.JSONObject;

public interface Jsonable {
    public JSONObject toJSON();
    public void fromJSON(JSONObject jsonObject) throws Exception;
}

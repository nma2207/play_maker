package test;

import command.Command;
import org.json.simple.JSONObject;
import org.junit.After;
import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;
public class CommandConvertTest extends Assert {
    private final Map<String, JSONObject> stringToJSONData = new HashMap<String, JSONObject>();
    @After
    public void setUpStringToJSONData()
    {
        JSONObject js1= new JSONObject();
        js1.put("command", "play");
        js1.put("path", "D:\\1.wav");
        stringToJSONData.put("play D:\\1.wav", js1);

        JSONObject js2 = new JSONObject();
        js2.put("command", "find");
        js2.put("by", "singer");
        js2.put("value", "Roza");
        stringToJSONData.put("find singer Roza", js2);

        JSONObject js3 = new JSONObject();
        js3.put("command", "find");
        js3.put("by", "song");
        js3.put("value", "Track01");
        stringToJSONData.put("find song Track01", js3);

        JSONObject js4 = new JSONObject();
        js4.put("command", "set");
        js4.put("by", "genre");
        js4.put("value", "rap");
        stringToJSONData.put("set genre rap", js4);



    }
    @After
    public void tearDownStringToJSONData(){
        stringToJSONData.clear();
    }
    @Test
    public void testStringToJSONData(){
        for (Map.Entry<String, JSONObject> entry : stringToJSONData.entrySet()) {
            final JSONObject testData = entry.getValue();
            final String expected = entry.getKey();
            JSONObject actual = null;
            try {
                 actual = Command.parse(expected);
            }
            catch (Exception e){}
            assertEquals(testData, actual);
        }
    }
}

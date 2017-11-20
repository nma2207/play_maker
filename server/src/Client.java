import java.io.BufferedReader;
import java.io.InputStream;
import java.util.Scanner;
import java.net.Socket;
import java.io.PrintWriter;
import java.io.InputStreamReader;
import java.io.OutputStream;
import org.json.simple.JSONObject;
public class Client {
    public static void main(String[] args)
    {

        Socket socket= null;
        try {
            socket = new Socket("127.0.0.1", 6666);
        }
        catch(Exception e){e.printStackTrace(); return;}

        InputStream is = null;
        try {
            is = socket.getInputStream();
        }
        catch (Exception e){
            System.out.println("Cannot get input stream");
            return;
        }
        BufferedReader in = new BufferedReader(new InputStreamReader(is));
        PrintWriter out=null;
        try {
            OutputStream outputStream = socket.getOutputStream();
            out  = new PrintWriter(outputStream, true);
        }
        catch (Exception e){
            System.out.println("Cannot get output stream or/and create printWriter");
            return;
        }
        String output ="";
        JSONObject obj = new JSONObject();
        JSONObject val = new JSONObject();
        val.put("name", "Розовое вино");
        val.put("durability","3");
        val.put("singer","Сингер");
        val.put("genre", "pop");

        obj.put("command","find");
        obj.put("by","song");
        obj.put("value", "pop");
        System.out.println(obj);
        out.println(obj.toJSONString());
        try {
            output = in.readLine();
        } catch (Exception e) {}
        System.out.println(output);


    }
}

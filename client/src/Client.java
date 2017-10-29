import java.io.BufferedReader;
import java.io.InputStream;
import java.util.Scanner;
import java.net.Socket;
import java.io.PrintWriter;
import java.io.InputStreamReader;
import java.io.OutputStream;

import command.Command;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;


import org.json.simple.JSONValue;
import pack.Singer;
import pack.Song;

public class Client {
    public static void main1(String[] args)
    {

        Socket socket= null;
        try {
             socket = new Socket("127.0.0.1", 6666);


        }
        catch(Exception e){
            System.out.println("cannot create socket");
            return;
        }

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
        System.out.println("Write the command");
        Scanner scanner = new Scanner(System.in);
        while(true) {


            String command = scanner.nextLine();
            String [] comm = command.split(" ");


            //System.out.println(command);
            //out.println(command);
            String output = "";
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("command", comm[0]);
            jsonObject.put("name", comm[1]);
            out.println(jsonObject.toJSONString());
            try {
                output = in.readLine();
            } catch (Exception e) {

            }
            System.out.println(output);
        }




    }
    public static void main(String []args){
        try {
            System.out.println(Command.parse("set singer AC/DC").toString());
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
}

package client;

import java.io.BufferedReader;
import java.io.InputStream;
import java.util.Scanner;
import java.net.Socket;
import java.io.PrintWriter;
import java.io.InputStreamReader;
import java.io.OutputStream;
import org.json.simple.JSONObject;

public class Client {
    public BufferedReader in;
    public PrintWriter out;
    Client(){
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
        in = new BufferedReader(new InputStreamReader(is));
        out = null;
        try {
            OutputStream outputStream = socket.getOutputStream();
            out  = new PrintWriter(outputStream, true);
        }
        catch (Exception e){
            System.out.println("Cannot get output stream or/and create printWriter");
            return;
        }
    }
    public  BufferedReader getIn()
    {
        System.out.println("in");
        return this.in;
    }
    public PrintWriter getOut()
    {
        System.out.println("out");
        return this.out;
    }
   // public static void main(String[] args)
    //{



//    }
}

//import java.awt.desktop.SystemSleepEvent;
package server;
import java.net.ServerSocket;
import java.net.Socket;


public class Server {
    public static void main(String[] args)
    {

        try {
            System.out.println("Start server");
            ServerSocket serverSocket = new ServerSocket(6666);
            int k=0;
            while (true)
            {
                Socket socket  = serverSocket.accept();
                System.out.println("Client #"+k);
                k++;
                (new ClientDialog(socket)).start();
            }

        }
        catch (Exception e)
        {

        }

    }
}

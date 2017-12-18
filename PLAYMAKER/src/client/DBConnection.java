package client;
import client.Client;

import javax.sound.sampled.*;
import java.io.BufferedReader;
import java.io.File;
import java.io.PrintWriter;
import java.sql.SQLException;

public class DBConnection
{
    private void PlayMusicSDL(String file) {
        SourceDataLine clipSDL;
        clipSDL  = null;
        AudioInputStream ais=null;
        byte[] b = new byte[2048];
        try {
            File f = new File(file);
            ais = AudioSystem.getAudioInputStream(f);
            AudioFormat af = ais.getFormat();
            DataLine.Info info = new DataLine.Info(SourceDataLine.class, af);
            if (AudioSystem.isLineSupported(info)) {
                clipSDL = (SourceDataLine)AudioSystem.getLine(info);
                clipSDL.open(af);
                clipSDL.start();
                int num=0;
                while ((num=ais.read(b))!=-1)
                    clipSDL.write(b, 0, num);
                clipSDL.drain();
                ais.close();
                clipSDL.stop();
                clipSDL.close();
            }else
            {
                System.exit(0);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    Client connection = null;
    PrintWriter out;
    BufferedReader in;
    public Client getDBConnection ()
    {
        try
        {
            connection = new Client();
            //connection.run();
            //out = connection.getOut();
            //in = connection.getIn();
        }
        catch (Exception e)
        {
            e.getLocalizedMessage();
            System.out.println("Connection Failed! Check output console");
            e.printStackTrace();
            return null;
        }
        return connection;
    }

    public BufferedReader getIn() {
        return in = connection.getIn();
    }

    public PrintWriter getOut() {
        return out = connection.getOut();
    }
}
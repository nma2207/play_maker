
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

import java.util.Collection;

import org.hibernate.Session;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;
import org.json.simple.JSONArray;
import pack.Genre;
import pack.Songs;
import pack.Singer;
import util.HibernateUtil;

public class ClientDialog extends Thread {
    Socket socket;
    public ClientDialog(Socket socket){
        this.socket = socket;
    }
    @Override
    public void run() {
        InputStream is = null;
        try {
            is = socket.getInputStream();
        } catch (Exception e) {
            System.out.println("Cannot get input stream");
            return;
        }
        BufferedReader in = new BufferedReader(new InputStreamReader(is));
        PrintWriter out = null;
        try {
            OutputStream outputStream = socket.getOutputStream();
            out = new PrintWriter(outputStream, true);
        } catch (Exception e) {
            System.out.println("Cannot get output stream or/and create printWriter");
            return;
        }
        /*-Xlint:unchecked*/
        String input;
        try {
            input = in.readLine();
        } catch (Exception e) {
            System.out.println(e.fillInStackTrace());
            System.out.println("Cannot read or write");
            return;
        }
        System.out.println(input);
        JSONObject jsonObject = null;
        try {
            jsonObject = (JSONObject) JSONValue.parseWithException(input);
        } catch (Exception e) {
            System.out.println("JSON exception");
        }
        String command = (String) jsonObject.get("command");
        Session session =null;
        allWork a = new allWork().getInstance();
        if (command.compareTo("find") == 0) {
            String value = (String) jsonObject.get("value");
            try {
                Collection genres = a.getGenreDAO().getAllGenres(session);
                Iterator iterator = genres.iterator();
                JSONArray jsonArray = new JSONArray();
                while (iterator.hasNext()) {
                    Genre genre = (Genre) iterator.next();
                    if (genre.getName_genre().compareTo(value) == 0)
                    {
                        Collection songs = a.getSongsDAO().getSongsByGenre(genre, session);
                        Iterator iterator2 = songs.iterator();
                        while (iterator2.hasNext()) {
                            Songs song = (Songs) iterator2.next();
                            JSONObject obj = new JSONObject();
                            obj.put("name", song.getName_song());
                            obj.put("durability", song.getDurability());
                            int id_singer = song.getSinger_idsinger();
                            Singer singer = a.getSingerDAO().getSingerById(id_singer, session);
                            obj.put("singer", singer.getName_singer());
                            obj.put("genre", value);
                            jsonArray.add(obj);
                            //out.println(obj.toJSONString());
                        }
                    }
                }
                out.println(jsonArray.toJSONString());
            }
            catch (Exception e) {
                //System.out.println("hgd  " + e.fillInStackTrace());
            }
        }
       else {
            try
            {
            String by = (String) jsonObject.get("by");
        if (by.compareTo("genre") == 0)
            {

                String value = (String) jsonObject.get("value");
                Genre g = new Genre();
                g.setName_genre(value);
                a.getGenreDAO().addGenre(g, session);
                out.println("true");
            }
            if (by.compareTo("singer") == 0)
            {
                String value = (String) jsonObject.get("value");
                Singer s = new Singer();
                s.setName_singer(value);
                a.getSingerDAO().addSinger(s, session);

            }
            else
            {
                Songs song = new Songs();
                JSONObject j = (JSONObject)jsonObject.get("value");
                String name = (String)j.get("name");
                String durability = (String)j.get("durability");
                String singer = (String)j.get("singer");
                String genre = (String)j.get("genre");
                song.setName_song(name);
                song.setDurability(durability);
                Genre g = new Genre();
                g.setName_genre(genre);
                int id_genre = isHasGenre(g,session);
                if(id_genre == -1) {
                    a.getGenreDAO().addGenre(g, session);
                    id_genre = g.getIdgenre();
                    System.out.println("id genre = " + id_genre);
                }
                else {
                    System.out.println("Я ТУТАxr");
                    song.setGenre_idgenre(id_genre);
                }
                Singer s = new Singer();
                s.setName_singer(singer);
                int id_singer = isHasSinger(s, session);
                if(id_singer == -1) {
                    System.out.println("Я ТУТА ж");
                    a.getSingerDAO().addSinger(s, session);
                    id_singer = s.getIdsinger();
                    song.setSinger_idsinger(id_singer);
                    System.out.println("id singer = " + id_singer);
                }
                else {
                    System.out.println("Я ТУТачки");
                    song.setSinger_idsinger(id_singer);
                }
                System.out.println("21345");
                song.setPath("path");
                a.getSongsDAO().addSong(song, session);
                System.out.println("дошла сюда сонг нэйм = " + song.getName_song() + " id singer= "
                        + song.getSinger_idsinger() + "id genre = " + song.getGenre_idgenre() + " dur = " + song.getDurability());
            }
            out.println("true");
        }
        catch(Exception e){ out.println("false");}
        }
        System.out.println( a.getSongsDAO().getAllSongs(session));
        if (session != null && session.isOpen()) {
            session.close();
        }
    }
    public int isHasSinger(Singer singer, Session session){
        Collection singers = allWork.getSingerDAO().getAllSingers(session);
        Iterator iterator = singers.iterator();
        while(iterator.hasNext()) {
            Singer s = (Singer) iterator.next();
            if (s.getName_singer().compareTo( singer.getName_singer()) == 0)
                return s.getIdsinger();
        }
        return -1;
    }


    public int isHasGenre(Genre genre, Session session)
    {
        Collection genres = allWork.getInstance().getGenreDAO().getAllGenres(session);
        Iterator iterator = genres.iterator();
        while(iterator.hasNext()) {
            Genre g = (Genre) iterator.next();
            if (g.getName_genre().compareTo( genre.getName_genre()) == 0)
                return g.getIdgenre();
        }
        return -1;
    }
}

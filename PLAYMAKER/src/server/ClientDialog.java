//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//
package server;

import java.io.*;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Collection;
import java.util.Iterator;
import javax.sound.sampled.*;

import APIConnector.Connector;
import org.hibernate.Session;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;
import server.pack.Genre;
import server.pack.Singer;
import server.pack.Songs;

import javax.sound.sampled.Clip;

public class ClientDialog extends Thread {
    Socket socket;

    public ClientDialog(Socket socket) {
        this.socket = socket;
    }
    public static byte[] getBytesFromFile(File file) throws IOException {
        InputStream is = new FileInputStream(file);
        // Get the size of the file
        long length = file.length();
        if (length > Integer.MAX_VALUE) {
            // File is too large
        }
        // Create the byte array to hold the data
        byte[] bytes = new byte[(int)length];
        // Read in the bytes
        int offset = 0;
        int numRead = 0;
        while (offset < bytes.length && (numRead=is.read(bytes, offset, bytes.length-offset)) >= 0) {
            offset += numRead;
        }
        // Ensure all the bytes have been read in
        if (offset < bytes.length) {
            throw new IOException("Could not completely read file "+file.getName());
        }
        // Close the input stream and return bytes
        is.close();
        return bytes;
    }

    public void run() {
        InputStream is = null;
        try {
            is = this.socket.getInputStream();
        } catch (Exception var24) {
            System.out.println("Cannot get input stream");
            return;
        }
        BufferedReader in = new BufferedReader(new InputStreamReader(is));
        PrintWriter out = null;
        try {
            OutputStream outputStream = this.socket.getOutputStream();
            out = new PrintWriter(outputStream, true);
        } catch (Exception var23) {
            System.out.println("Cannot get output stream or/and create printWriter");
            return;
        }
        String input;
        try {
            input = in.readLine();
        } catch (Exception var22) {
            System.out.println(var22.fillInStackTrace());
            System.out.println("Cannot read or write");
            return;
        }


        System.out.println(input);
        JSONObject jsonObject = null;

        try {
            jsonObject = (JSONObject)JSONValue.parseWithException(input);
        } catch (Exception var21) {
            System.out.println("JSON exception");
        }

        String command = (String)jsonObject.get("command");
        Session session = null;
        new allWork();
        allWork a = allWork.getInstance();
        String value;
        if (command.compareTo("find") == 0) {
            String name_song = (String)jsonObject.get("name");
            String name_singer = (String)jsonObject.get("singer");
            Connector connector = new Connector();
            String name_genre = "";
            try {
                name_genre = connector.getGenre(name_singer, name_song);
            }
            catch(Exception e){
                System.out.println("не получили жанр" + e.fillInStackTrace());
            }
            try {
                Collection genres = a.getGenreDAO().getAllGenres((Session)session);
                Iterator iterator = genres.iterator();
                JSONArray jsonArray = new JSONArray();

                label91:
                while(true) {
                    Genre genre;
                    do {
                        if (!iterator.hasNext()) {
                            out.println(jsonArray.toJSONString());
                            break label91;
                        }

                        genre = (Genre)iterator.next();
                    } while(genre.getName_genre().compareTo(name_genre) != 0);

                    Collection songs = allWork.getSongsDAO().getSongsByGenre(genre, (Session)session);
                    Iterator iterator2 = songs.iterator();

                    while(iterator2.hasNext()) {
                        Songs song = (Songs)iterator2.next();
                        JSONObject obj = new JSONObject();
                        obj.put("name", song.getName_song());
                        obj.put("durability", song.getDurability());
                        obj.put("path", song.getPath());
                        int id_singer = song.getSinger_idsinger();
                        Singer singer = allWork.getSingerDAO().getSingerById(id_singer, (Session)session);
                        obj.put("singer", singer.getName_singer());
                        obj.put("genre", name_genre);
                        jsonArray.add(obj);
                    }
                }
            } catch (Exception var25) {
                ;
            }
        } else {
            try {
                Songs song = new Songs();
                String name = (String)jsonObject.get("name");
                String singer = (String)jsonObject.get("singer");
                String genre = (String)jsonObject.get("genre");
                song.setName_song(name);
                int id_song = this.isHasSongName(name, session);
                if (id_song == -1){
                    song.setDurability("0");
                    Genre g = new Genre();
                    g.setName_genre(genre);
                    int id_genre = this.isHasGenre(g, (Session) session);
                    if (id_genre == -1) {
                        a.getGenreDAO().addGenre(g, (Session) session);
                        id_genre = g.getIdgenre();
                        song.setGenre_idgenre(id_genre);
                    } else {
                        song.setGenre_idgenre(id_genre);
                    }
                    Singer s = new Singer();
                    s.setName_singer(singer);
                    int id_singer = this.isHasSinger(s, (Session) session);
                    if (id_singer == -1) {
                        allWork.getSingerDAO().addSinger(s, (Session) session);
                        id_singer = s.getIdsinger();
                        song.setSinger_idsinger(id_singer);
                    } else {
                        song.setSinger_idsinger(id_singer);
                    }
                    song.setPath("path");
                    allWork.getSongsDAO().addSong(song, (Session) session);
                }
                out.println("true");
            } catch (Exception var20) {
                System.out.println(var20.getCause() + " === "+ var20.getMessage());
                out.println(var20.getCause() + " === "+ var20.getMessage());
            }
        }

        //System.out.println(allWork.getSongsDAO().getAllSongs((Session)session));
        if (session != null && ((Session)session).isOpen()) {
            ((Session)session).close();
        }

    }
    public int isHasSongName(String name_song, Session session)
    {
        Collection songs = allWork.getSongsDAO().getAllSongs(session);
        Iterator iterator = songs.iterator();
        Songs s;
        do {
            if (!iterator.hasNext())
                return -1;
            s = (Songs) iterator.next();
        } while(s.getName_song().compareTo(name_song) != 0);

        return s.getIdsongs();
    }

    public int isHasSinger(Singer singer, Session session) {
        Collection singers = allWork.getSingerDAO().getAllSingers(session);
        Iterator iterator = singers.iterator();

        Singer s;
        do {
            if (!iterator.hasNext())
                return -1;
            s = (Singer)iterator.next();
        } while(s.getName_singer().compareTo(singer.getName_singer()) != 0);

        return s.getIdsinger();
    }

    public int isHasGenre(Genre genre, Session session) {
        Collection genres = allWork.getInstance().getGenreDAO().getAllGenres(session);
        Iterator iterator = genres.iterator();

        Genre g;
        do {
            if (!iterator.hasNext())
                return -1;
            g = (Genre)iterator.next();
        } while(g.getName_genre().compareTo(genre.getName_genre()) != 0);

        return g.getIdgenre();
    }
}

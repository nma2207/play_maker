package converter;

import pack.Genre;
import pack.Singer;
import pack.Song;
import pack.Songs;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;

public class Converter {
    public static ArrayList<Songs> songConvert(Collection songs) {
        ArrayList<Songs> result=new ArrayList<>();
//        private int idsongs;
//        private String name_song;
//        private String durability;
//        private String path;
//        private int singer_idsinger;
//        private int genre_idgenre;
        for(Object obj: songs) {
            Songs s =new Songs();
            try {
                //1
                Field idFiled = obj.getClass().getDeclaredField("idsongs");
                idFiled.setAccessible(true);
                int id = (int)idFiled.get(obj);
//2
                Field nameFiled = obj.getClass().getDeclaredField("name_song");
                nameFiled.setAccessible(true);
               String name = (String)nameFiled.get(obj);
//3
                Field durFiled = obj.getClass().getDeclaredField("durability");
                durFiled.setAccessible(true);
               String dur = (String)durFiled.get(obj);
//4
                Field pathFiled = obj.getClass().getDeclaredField("path");
                pathFiled.setAccessible(true);
                String path = (String)pathFiled.get(obj);
//5
                Field singerIdFiled = obj.getClass().getDeclaredField("singer_idsinger");
                singerIdFiled.setAccessible(true);
                int singerId= (int)singerIdFiled.get(obj);
//6
                Field idGenreFiled = obj.getClass().getDeclaredField("genre_idgenre");
                idGenreFiled.setAccessible(true);
                int genreId = (int)idGenreFiled.get(obj);

                s.setIdsongs(id);
                s.setDurability(dur);
                s.setName_song(name);
                s.setPath(path);
                s.setSinger_idsinger(singerId);
                s.setGenre_idgenre(genreId);
                result.add(s);
            }
            catch (Exception e){
                System.out.println(e.getMessage());
            }

        }
        return result;
    }

    public static ArrayList<Genre> genreConvert(Collection genre){

//        private int idgenre;
//        private String name_genre;
        ArrayList<Genre> result = new ArrayList<>();
        for(Object obj: genre) {
            Genre g =new Genre();
            try {
                //1

                Field idFiled = obj.getClass().getDeclaredField("idgenre");
                idFiled.setAccessible(true);
                int id = (int)idFiled.get(obj);
//2
                Field nameFiled = obj.getClass().getDeclaredField("name_genre");
                nameFiled.setAccessible(true);
                String name = (String)nameFiled.get(obj);
                g.setIdgenre(id);
                g.setName_genre(name);
                result.add(g);

            }
            catch (Exception e){
                System.out.println(e.getMessage());
            }

        }
        return result;
    }


    public static ArrayList<Singer> singerConvert(Collection genre){

//        private int idsinger;
//        private String name_singer;
        ArrayList<Singer> result = new ArrayList<>();
        for(Object obj: genre) {
            Singer s =new Singer();
            try {
                //1

                Field idFiled = obj.getClass().getDeclaredField("idsinger");
                idFiled.setAccessible(true);
                int id = (int)idFiled.get(obj);
//2
                Field nameFiled = obj.getClass().getDeclaredField("name_singer");
                nameFiled.setAccessible(true);
                String name = (String)nameFiled.get(obj);
                s.setIdsinger(id);
                s.setName_singer(name);
                result.add(s);

            }
            catch (Exception e){
                System.out.println(e.getMessage());
            }

        }
        return result;
    }
    public static ArrayList<Song> getSongsWithArtist(ArrayList<Singer> singers, ArrayList<Songs> songs)
    {
        ArrayList<Song> res = new ArrayList<>();
        for(Songs s:songs)
        {
            Song song = new Song();
            song.setName(s.getName_song());
            song.setPath(s.getPath());
            String singer = "NoName";
            for(Singer s1:singers)
            {
                if(s1.getIdsinger()==s.getSinger_idsinger()) {
                    singer = s1.getName_singer();
                    break;
                }
            }
            song.setSinger(singer);
            res.add(song);
        }
        return res;
    }
}

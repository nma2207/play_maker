package command;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import pack.Singer;
import pack.Genre;
import  pack.Song;

import java.util.ArrayList;

public class Command {
    /*
    Надо подумать какие команды могут быть
    - типа find by Singer// писать в командной строке что-то типа find singer AC/DC
    -       find by Genre // find genre trep
    -       find by name // find name "в лесу родилась елочка"

    -
    еще надо чтобы можно было отпрвить
        set singer value // set d:/work2017/best_song.mp3
        set genre value
        set song name genre singer  durability
    только надо еще смчоь песню передать
     */
    private static int findCommandLength = 2;
    private static int setSingerCommandLength = 3;
    private static int setGenreCommandLength = 3;
    private static int setSongCommandLength = 6;
    private static int playSongCommandLength = 2;
    public  static JSONObject parse(String command)throws Exception{
        String[] commandArray = command.split(" ");
        if(commandArray.length==0){
            throw new Exception("Command not found");
        }
        switch (commandArray[0]){
            case "find": return parseFindCommand(commandArray);
            case "set": return parseSetCommand(commandArray);
            case "play": return parsePlaySongCommand(commandArray);
        }
        if(command.compareTo("exit")==0){
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("command", "exit");
            return jsonObject;
        }

        return null;
    }
    private static JSONObject parseFindCommand(String[] commArray) throws Exception{
        if(commArray.length != findCommandLength){
            throw new Exception("command 'find' has "+findCommandLength+" arguments");
        }
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("command", commArray[0]);
        jsonObject.put("value", commArray[1]);
        return jsonObject;
    }
    private static JSONObject parseSetCommand(String[] commandArray) throws Exception{
        if(commandArray.length < setSingerCommandLength){
            throw new Exception("Set command has not "+commandArray.length+" arguments");

        }
        switch (commandArray[1]){
            case "singer":return parseSetSingerCommand(commandArray);
            case "genre":return parseSetGenreCommand(commandArray);
            case "song":return parseSetSongCommand(commandArray);

        }
        return null;
    }
    private  static  JSONObject parseSetSingerCommand(String[] commandArray) throws Exception{
        if(commandArray.length != setSingerCommandLength){
            throw new Exception("Command set singer has "+setSingerCommandLength+" arguments");
        }
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("command", commandArray[0]);
        jsonObject.put("by", commandArray[1]);
        jsonObject.put("value", commandArray[2]);
        return jsonObject;
    }
    private  static JSONObject parseSetGenreCommand(String[] commandArray) throws Exception{
        if(commandArray.length != setGenreCommandLength){
            throw new Exception("Command set genre has "+setGenreCommandLength+" arguments");
        }
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("command", commandArray[0]);
        jsonObject.put("by", commandArray[1]);
        jsonObject.put("value", commandArray[2]);
        return jsonObject;
    }
    private  static JSONObject parseSetSongCommand(String[] commandArray) throws Exception {
        if (commandArray.length != setSongCommandLength) {
            throw new Exception("Command set song has " + setSongCommandLength + " arguments");
        }
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("command", commandArray[0]);
        jsonObject.put("by", commandArray[1]);
        jsonObject.put("value", new Song(
                commandArray[2],//name
                commandArray[3], //genre
                commandArray[4], // singer
                commandArray[5] //dirability
                ).toJSON()
        );
        return jsonObject;

    }
    private  static JSONObject parsePlaySongCommand(String[] commandArray) throws Exception{
        if(commandArray.length != playSongCommandLength){
            throw new Exception("Command play has "+playSongCommandLength+ " arguments");
        }
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("command", "play");
        jsonObject.put("path", commandArray[1]);
        return jsonObject;


    }

    public static ArrayList<Song> getSongs(JSONArray jsonArray){
        ArrayList<Song> songList = new ArrayList<Song>();

        for(int i=0; i<jsonArray.size();i++) {
            Song s = new Song();
            try {
                s.fromJSON((JSONObject)jsonArray.get(i));
            }catch (Exception e){
                System.out.println(e.getMessage());
            }
            songList.add(s);
        }
        return songList;
    }


}

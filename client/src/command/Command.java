package command;

import org.json.simple.JSONObject;
import pack.Singer;
import pack.Genre;
import  pack.Song;
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
    static int  findCommandLength = 3;
    static int setSingerCommandLength = 3;
    static int setGenreCommandLength = 3;
    static int setSongCommandLength = 6;
    public  static JSONObject parse(String command)throws Exception{
        String[] commandArray = command.split(" ");
        if(commandArray.length==0){
            throw new Exception("Command not found");
        }
        if (commandArray[0].compareTo("find")==0){
            return parseFindCommand(commandArray);
        }
        else if (commandArray[0].compareTo("set")==0){
            return parseSetCommand(commandArray);
        }
        else
            return null;
    }
    private static JSONObject parseFindCommand(String[] commArray) throws Exception{
        if(commArray.length != findCommandLength){
            throw new Exception("command 'find' has "+findCommandLength+" arguments");
        }
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("command", commArray[0]);
        jsonObject.put("by",commArray[1]);
        jsonObject.put("value", commArray[2]);
        return jsonObject;
    }
    private static JSONObject parseSetCommand(String[] commandArray) throws Exception{
        if(commandArray.length < setSingerCommandLength){
            throw new Exception("Set command has not "+commandArray.length+" arguments");

        }
        if(commandArray[1].compareTo("singer")==0){
            return parseSetSingerCommand(commandArray);
        }
        if(commandArray[1].compareTo("genre")==0){
            return parseSetGenreCommand(commandArray);
        }
        if(commandArray[1].compareTo("song")==0){
            return parseSetSongCommand(commandArray);
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
        jsonObject.put("value", new Singer(commandArray[2]).toJSON());
        return jsonObject;
    }
    private  static JSONObject parseSetGenreCommand(String[] commandArray) throws Exception{
        if(commandArray.length != setGenreCommandLength){
            throw new Exception("Command set genre has "+setGenreCommandLength+" arguments");
        }
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("command", commandArray[0]);
        jsonObject.put("by", commandArray[1]);
        jsonObject.put("value", new Genre(commandArray[2]).toJSON());
        return jsonObject;
    }
    private  static JSONObject parseSetSongCommand(String[] commandArray) throws Exception{
        if(commandArray.length != setSongCommandLength){
            throw new Exception("Command set song has "+setSongCommandLength+" arguments");
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

}

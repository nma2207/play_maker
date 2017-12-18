package APIConnector;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import javax.net.ssl.HttpsURLConnection;
import org.json.*;

public class Connector {
    // Глобальные переменные
    // Жанр последней введённой композиции
    public static String genre = "other";
    // Список всех жанров нашей БД
    public ArrayList<String> genreBase;
    // Настройки
    private final String USER_AGENT = "Mozilla/5.0";
    private static String api_key = "e1cf298670e03f0b5dc57ba71704410b";
    private static String secret_key = "b329c21eb32cc161ecdce3488768ed3c";
    private static String user = "Grunge_Beat";
    private static String project = "Play Maker";

    // Конструкторы
    public Connector()
    {
        String genre = "other";
        String USER_AGENT = "Mozilla/5.0";
        String api_key = "e1cf298670e03f0b5dc57ba71704410b";
        String secret_key = "b329c21eb32cc161ecdce3488768ed3c";
        String user = "Grunge_Beat";
        project = "Play Maker";
        genreBase = new ArrayList<String>();
        genreBase.add("pop");
        genreBase.add("electronic");
        genreBase.add("rock");
        genreBase.add("classical");
        genreBase.add("rap");
        genreBase.add("jazz");
        genreBase.add("folk");
        genreBase.add("trance");
        genreBase.add("experimental");
        genreBase.add("hip-hop");
    }
    public Connector(ArrayList<String> listOfGenres)
    {
        String genre = "other";
        String USER_AGENT = "Mozilla/5.0";
        String api_key = "e1cf298670e03f0b5dc57ba71704410b";
        String secret_key = "b329c21eb32cc161ecdce3488768ed3c";
        String user = "Grunge_Beat";
        project = "Play Maker";
        genreBase = listOfGenres;
    }
    // Функции
    // Получить список похожих песен
    public String getSimilarTracks(String artist, String track) throws Exception {
        return getSimilarTracks(artist, track, api_key);
    }
    private String getSimilarTracks(String artist, String track,  String api_key) throws Exception {
        String url = "http://ws.audioscrobbler.com/2.0/?method=track.getsimilar&artist=" + artist + "&track=" + track + "&api_key=" + api_key + "&format=json";
        return getRequest(url);
    }
    // Получить информацию о песне
    public String getInfo(String artist, String track) throws Exception {
        return getInfo(artist, track, api_key);
    }
    private String getInfo(String artist, String track, String api_key) throws Exception {
        String url = "http://ws.audioscrobbler.com/2.0/?method=track.getInfo&api_key=" + api_key + "&artist=" + artist + "&track=" + track + "&format=json";
        return getRequest(url);
    }
    public String getGenre(String artist, String track) throws Exception {
        return getGenre(artist, track, genreBase);
    }
    // Получить жанр песни
    public String getGenre(String artist, String track, ArrayList<String> genreBase) throws Exception {
        // Список похожих песен
        String myJson = getSimilarTracks(artist, track);
        // System.out.print(myJson);
        // Получаем список
        JSONObject obj = new JSONObject(myJson);
        JSONArray arr = obj.getJSONObject("similartracks").getJSONArray("track");
        // Записываем название песни, её автора
        ArrayList<String> songsName = new ArrayList<String>();
        ArrayList<String> songsArtist = new ArrayList<String>();
        for (int i = 0; i < arr.length(); i++) {
            songsName.add(arr.getJSONObject(i).getString("name"));
            songsArtist.add(arr.getJSONObject(i).getJSONObject("artist").getString("name"));
        }
        // Определяем жанр по пераому найденному совпадению со списком всех жанров
        String genre = "other";
        Boolean isFound = false;
        for (int i = 0; i < arr.length(); i++) {
            ArrayList<String> tags = parseGenres(getInfo(songsArtist.get(i), songsName.get(i)));
            for (int j = 0; j < tags.size(); j++) {
                for (int k = 0; k < genreBase.size(); k++) {
                    if (tags.get(j).toLowerCase().equals(genreBase.get(k))) {
                        genre = tags.get(j);
                        isFound = true;
                    }
                    if (isFound == true) {
                        break;
                    }
                }
                if (isFound == true) {
                    break;
                }
            }
            if (isFound == true) {
                break;
            }
        }
        if (!isFound)
        {
            ArrayList<String> tags = parseGenres(getInfo(artist, track));
            for (int j = 0; j < tags.size(); j++) {
                for (int k = 0; k < genreBase.size(); k++) {
                    if (tags.get(j).toLowerCase().equals(genreBase.get(k))) {
                        genre = tags.get(j);
                        isFound = true;
                    }
                    if (isFound == true) {
                        break;
                    }
                }
                if (isFound == true) {
                    break;
                }
            }
        }
        return genre;
    }
    // Парсинг JSON файла с жанрами
    private ArrayList<String> parseGenres(String myJson) throws Exception {
        JSONObject obj = new JSONObject(myJson);
        JSONArray arr = obj.getJSONObject("track").getJSONObject("toptags").getJSONArray("tag");
        ArrayList<String> songTags = new ArrayList<String>();
        for (int i = 0; i < arr.length(); i++)
        {
            songTags.add(arr.getJSONObject(i).getString("name"));
        }
        return songTags;
    }

    // GET-запрос
    private String getRequest(String url) throws Exception {
        String url2 = url.replaceAll(" ","%20");
        url2 = url2.replaceAll("'", "%27");
        URL obj = new URL(url2);
        HttpURLConnection con = (HttpURLConnection) obj.openConnection();
        // Тип запроса
        con.setRequestMethod("GET");
        // Заголовок запроса
        con.setRequestProperty("User-Agent", USER_AGENT);
        // Информация о запросе
        int responseCode = con.getResponseCode();
        //System.out.println("\nОтправляем GET-запрос к серверу: " + url);
        //System.out.println("Код ответа: " + responseCode);
        // Считываем информацию
        BufferedReader in = new BufferedReader( new InputStreamReader( con.getInputStream() ) );
        String inputLine;
        StringBuffer response = new StringBuffer();
        while ((inputLine = in.readLine()) != null) {
            response.append(inputLine);
        }
        in.close();
        // Вывод результата
        //System.out.println(response.toString());
        return response.toString();
    }

    // POST-запрос
    private String postRequest(String url) throws Exception {
        String url2 = url.replaceAll(" ","%20");
        url2 = url2.replaceAll("'", "%27");
        URL obj = new URL(url2);
        HttpsURLConnection con = (HttpsURLConnection) obj.openConnection();
        // Тип запроса
        con.setRequestMethod("POST");
        // Заголовок запроса
        con.setRequestProperty("User-Agent", USER_AGENT);
        con.setRequestProperty("Accept-Language", "en-US,en;q=0.5");
        String urlParameters = "sn=C02G8416DRJM&cn=&locale=&caller=&num=12345";
        // Отправление POST-запроса
        con.setDoOutput(true);
        DataOutputStream wr = new DataOutputStream(con.getOutputStream());
        wr.writeBytes(urlParameters);
        wr.flush();
        wr.close();
        // Информация о запросе
        int responseCode = con.getResponseCode();
        System.out.println("\nОтправляем POST-запрос к серверу: " + url);
        System.out.println("Параметры запроса: " + urlParameters);
        System.out.println("Код ответа: " + responseCode);
        // Считываем информацию
        BufferedReader in = new BufferedReader( new InputStreamReader( con.getInputStream() ) );
        String inputLine;
        StringBuffer response = new StringBuffer();
        while ((inputLine = in.readLine()) != null) {
            response.append(inputLine);
        }
        in.close();
        // Парсинг должен быть здесь!
        // Вывод результата
        System.out.println(response.toString());
        return response.toString();
    }
}
package client;

import client.PlayList;
import javafx.scene.control.TableView;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.LoadException;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import javafx.scene.control.TextField;
import org.json.JSONString;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;
import javazoom.jl.player.advanced.*;
import javazoom.jl.player.*;
import javax.jws.soap.SOAPBinding;
import javax.sound.sampled.*;
import javax.swing.*;
import java.io.*;
import java.lang.RuntimeException;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class Controller {
    public ArrayList path_list = new ArrayList();
    @FXML TextField mysinger; //какого исполнителя мы вводим
    @FXML TextField mysong; //какую песню мы вводим
    @FXML TableView<PlayList> myTable; //таблица с похожими
    @FXML TableColumn<PlayList,String> tableSinger; //столбец исполнителя
    @FXML TableColumn<PlayList,String> tableSong; //стобец песня
    @FXML TableColumn<PlayList,String> tableGenre; //столбец жанра
    @FXML TextField setsinger; //какого исполнителя мы вводим
    @FXML TextField setsong; //какую песню мы вводим
    @FXML TextField setgenre; //какую песню мы вводим
    public String command ;
    public String sSinger, sSong, sGenre;//сюда пишем то, что ввели
    AdvancedPlayer ap;
    public String getCommand()
    {
        return this.command;
    }
    public String getsSinger()
    {
        return this.sSinger;
    }
    public String getsSong()
    {
        return this.sSong;
    }
    ObservableList<PlayList> data = FXCollections.observableArrayList();
    private void myPlay(String filename){
        try{

            InputStream is=new FileInputStream("songs\\"+filename);
            AudioDevice device=new JavaSoundAudioDevice();
            ap=new AdvancedPlayer(is,device);
            ap.play();

            //ap.close();
        }catch(Exception e){}
    }
    public void Pause() {
        ap.stop();
    }
    public void SetSong(ActionEvent event)throws Exception
    {
        Stage primarStage = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("/client/settingsong.fxml"));
        primarStage.setTitle("Добавление новой песни");
        primarStage.setScene(new Scene(root, 400, 305));
        primarStage.show();
    }

    public void Search (ActionEvent event) //функция выполняет при нажатии на "ПОИСК"
    {
        while (!data.isEmpty())
        {
            data.remove(0);
        }
        Client client = new Client();
        PrintWriter out = client.getOut();
        BufferedReader in = client.getIn();
        command = "find";
        sSinger=mysinger.getText();
        sSong = mysong.getText();
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("command", command);
        jsonObject.put("name", sSong);
        jsonObject.put("singer", sSinger);
        System.out.println((jsonObject.toJSONString()));
        out.println(jsonObject.toJSONString());
        String outp = "";
        try {
            outp = in.readLine();
        }
        catch (Exception e){
            System.out.println(e.fillInStackTrace());
        }
        JSONArray array = (JSONArray) JSONValue.parse(outp);
        org.json.JSONArray ar = new org.json.JSONArray(outp);

        if (array.size() == 0)
        {
            JOptionPane.showMessageDialog(null, "Не найдено похожих песен");//окно тоже
        }
        else {

            // если найдены, то каждая строка в твою таблицу добавляется
            for (int i = 0; i < array.size(); i++) {
                org.json.JSONObject js = ar.getJSONObject(i);
                path_list.add(js.getString("path"));
                String nazvanie_pesni = js.getString("name");
                String pevec = js.getString("singer");
                String zhanr = js.getString("genre");
                System.out.println(nazvanie_pesni + "  " + pevec +  "  "+ zhanr);
                data.add(new PlayList(pevec, nazvanie_pesni, zhanr));
            }
        }
        tableSinger.setCellValueFactory(new PropertyValueFactory<PlayList,String>("Singer"));
        tableSong.setCellValueFactory(new PropertyValueFactory<PlayList,String>("Song"));
        tableGenre.setCellValueFactory(new PropertyValueFactory<PlayList,String>("Genre"));
        myTable.setItems(data);
    }

    public void Playplay()
    {
        int indexSong = myTable.getSelectionModel().getFocusedIndex();//получаешь индекс
        String file =  (path_list.get(indexSong)).toString();
        System.out.println("tuta ya");
        myPlay(file);
    }

    public void NewSong() //используется для добавления новых песен
    {
        Client client = new Client();
        PrintWriter out = client.getOut();
        BufferedReader in = client.getIn();
        String SingerSet=setsinger.getText();
        String SongSet=setsong.getText();
        String GenreSet=setgenre.getText();
        JSONObject jsonObject = new JSONObject();
        command = "set";
        jsonObject.put("command", command);
        jsonObject.put("name", SongSet);
        jsonObject.put("singer", SingerSet);
        jsonObject.put("genre", GenreSet);
        System.out.println((jsonObject.toJSONString()));
        out.println(jsonObject.toJSONString());
        String outp = "";
        try {
            outp = (String) in.readLine();
            if (outp.compareTo("true") == 0)
                JOptionPane.showMessageDialog(null, "Песня добавлена");//здесь должно выйти окно(типа MessageBox в шарпе) и написать что песчня добавленя
            else
                JOptionPane.showMessageDialog(null, "Не удалось добавить песню");//тут наоблорот , что недобавлена, произхошла ошибка
        }
        catch (Exception e){
            System.out.println(e.fillInStackTrace());
        }

    }

}
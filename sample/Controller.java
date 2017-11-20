package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.LoadException;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.control.TextField;
import java.lang.RuntimeException;

import java.awt.*;

public class Controller {

    String Searchcrit;
    @FXML TextField myquestion;
    @FXML TextField setsinger;
    @FXML TextField setgenre;
    @FXML TextField setsong;

    public void pressButton(ActionEvent event) {
        System.out.println("Здарова, ПЁТР!!!");
    }

    public void SetSong(ActionEvent event)throws Exception
    {
        Stage primarStage = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("settingsong.fxml"));
        primarStage.setTitle("Добавление новой песни");
        primarStage.setScene(new Scene(root, 400, 305));
        primarStage.show();
    }

    public void OtherSongs(ActionEvent event)throws Exception
    {
        Stage primaryStag = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("othersons.fxml"));
        primaryStag.setTitle("Похожие песни");
        primaryStag.setScene(new Scene(root, 400, 405));
        primaryStag.show();
    }

    public void SearchSinger(ActionEvent event) {Searchcrit = "Singer";}
    public void SearchGenre(ActionEvent event) {Searchcrit = "Genre";}
    public void SearchSong(ActionEvent event) {Searchcrit = "Song";}

    public void Search (ActionEvent event)
    {
        if (Searchcrit=="Singer") FindBySinger();
        else if (Searchcrit=="Genre") FindByGenre();
        else if (Searchcrit=="Song") FindBySong();
    }

    public void FindBySinger()
    {
     //   command: find;
       // by: Singer;
     //   value: myquestion.getText()
    }

    public void FindByGenre()
    {
      //  command: find;
        //by: Genre;
        //value: myquestion.getText()
        System.out.println("Жанр!!!");
    }

    public void FindBySong()
    {
  //      command: find;
    //    by: Song;
        //value: myquestion.getText()
        System.out.println("Песня!!!");
    }

    public void NewSong()
    {
        //      command: set;
        //    by: Singer/Genre/Song;
        //value: myquestion.getText()
       // name: setsong.getText()
       // durability: durab  //хз что там с продолжительностью
       // singer: setsinger.getText()
       // genre: setgenre.getText()
        System.out.println("z");
    }

}

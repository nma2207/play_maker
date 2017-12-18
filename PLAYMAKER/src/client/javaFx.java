package client;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.event.EventHandler;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.json.simple.JSONObject;
import javafx.scene.input.KeyEvent;
import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;
import java.io.*;
import java.net.Socket;


public class javaFx extends Application {

    public static void main(String[] args) {
        launch(args);


    }

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("/client/sample.fxml"));
        //DBConnection con = new DBConnection();

        Scene scene = new Scene(root, 500, 500);
        primaryStage.setTitle("PlayMaker");
        primaryStage.setScene(scene);
        primaryStage.show();
        /*scene.setOnKeyTyped(new EventHandler<KeyEvent>() {
                                public void handle(KeyEvent ke) {
                                    if (ke.getCharacter().equals(MouseEvent.MOUSE_CLICKED)) {
                                        Controller c = new Controller();
                                        JSONObject jsonObject = new JSONObject();
                                        jsonObject.put("command", c.getCommand());
                                        jsonObject.put("name", "");
                                        jsonObject.put("singer", "");
                                        jsonObject.put("genre", "");
                                    }
                                }
                            });
        //JSONObject jsonObject = new JSONObject();
        //jsonObject.put("command", controller.getCommand());*/

    }


}

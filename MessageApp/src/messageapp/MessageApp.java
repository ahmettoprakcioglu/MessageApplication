/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package messageapp;

import java.io.InputStream;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import messageapp.BIN.DatabaseConn;
import messageapp.HomePage.HomePage;
import messageapp.HomePage.HomePageRegister;

/**
 *
 * @author AHMET
 */
public class MessageApp extends Application {

    public static Scene scene;

    @Override
    public void start(Stage stage) throws Exception {

        DatabaseConn databaseConn = new DatabaseConn();
        databaseConn.connect();
        HomePage root = new HomePage();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.setTitle("AAST Message Application");
        stage.getIcons().add(new Image("/messageapp/Image/StageImage/stageIcon32px.png"));
        stage.setMinWidth(800);
        stage.setMinHeight(600);
        stage.show();
        stage.setOnCloseRequest((event) -> {
            databaseConn.disConnect();
        });

    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

}

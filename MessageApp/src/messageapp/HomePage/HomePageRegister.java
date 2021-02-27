/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package messageapp.HomePage;

import Pojo.Users;
import com.gluonhq.charm.glisten.control.Avatar;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.layout.HBox;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javax.imageio.ImageIO;
import messageapp.BIN.DatabaseManager;

/**
 *
 * @author AHMET
 */
public class HomePageRegister extends HBox {

    @FXML
    private TextField registerFirstName;

    @FXML
    private TextField registerLastName;

    @FXML
    private TextField registerUserName;

    @FXML
    private PasswordField registerPassword;

    @FXML
    private Avatar profileImage;

    @FXML
    private Label fileChooseWarning;

    @FXML
    private HBox tempHBOX;

    private File file;

    private DatabaseManager<Pojo.Defaultimages> databaseImages = new DatabaseManager();
    
    public HomePageRegister() {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("HomePageRegister.fxml"));
        fxmlLoader.setRoot(this);
        fxmlLoader.setController(this);

        try {
            fxmlLoader.load();
        } catch (IOException exception) {
            throw new RuntimeException(exception);
        }
    }

    @FXML
    private void initialize() {
    }

    @FXML
    void registerButton(ActionEvent event) throws IOException {
        
        DatabaseManager<Pojo.Users> data = new DatabaseManager<>();
         Users user;
        if(file!=null){
             user = new Users(registerUserName.getText(), registerFirstName.getText(), registerLastName.getText(), registerPassword.getText(), CopyImageToByteArray(this.file));
        }else{
            user = new Users(registerUserName.getText(), registerFirstName.getText(), registerLastName.getText(), registerPassword.getText(), databaseImages.get(1, Pojo.Defaultimages.class).getDefaultImage());
        }
       

        data.save(user);
        messageapp.MessageApp.scene.setRoot(new HomePage());
    }

    @FXML
    void setProfileImage(ActionEvent event) {
        
        FileChooser filechoose = new FileChooser();
        filechoose.setTitle("Open File Choose");
        filechoose.getExtensionFilters().add(new FileChooser.ExtensionFilter("Image Files", "*.png", "*.jpg", "*.jpeg"));
        Stage stage = (Stage) tempHBOX.getScene().getWindow();

        this.file = filechoose.showOpenDialog(stage);
        if (file != null) {
            profileImage.setImage(new Image(file.toURI().toString()));
        }
        
    }

    public static byte[] CopyImageToByteArray(File file) throws IOException {
        
        BufferedImage bImage = bImage = ImageIO.read(new URL(file.toURI().toString()));
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        ImageIO.write(bImage, "jpg", bos);
        byte[] data = bos.toByteArray();
        return data;
        
    }
}

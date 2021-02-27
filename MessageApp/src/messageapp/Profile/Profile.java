/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package messageapp.Profile;

import com.gluonhq.charm.glisten.control.Avatar;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import messageapp.BIN.config;

/**
 *
 * @author AHMET
 */


public class Profile extends AnchorPane {
    @FXML
    private Label profileFName;

    @FXML
    private Avatar profileImage;
    
   
    public Profile() {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Profile.fxml"));
        fxmlLoader.setRoot(this);
        fxmlLoader.setController(this);
        
        try {
            fxmlLoader.load();
        } catch (IOException exception) {
            throw new RuntimeException(exception);
        }
        
        profileImage.setImage(new Image(new ByteArrayInputStream(messageapp.BIN.CurrentUserDB.currentUser.getProfileImage())));
        profileFName.setText(messageapp.BIN.CurrentUserDB.currentUser.getFirstName()+" "+messageapp.BIN.CurrentUserDB.currentUser.getLastName());
    }
    
    @FXML
    private void initialize() {
        config.AnchorPaneConst(this, 0.0, 0.0, 0.0, 0.0);
    }
}

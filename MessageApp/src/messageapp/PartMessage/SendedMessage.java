/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package messageapp.PartMessage;

import com.gluonhq.charm.glisten.control.Avatar;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.HBox;

/**
 *
 * @author AHMET
 */
public class SendedMessage extends HBox {
    @FXML
    private Label sendedMTime;

    @FXML
    private Label sendedMText;

    @FXML
    private Avatar sendedMAvatar;
    
    public SendedMessage() {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("SendedMessage.fxml"));
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

    public String getSendedMTime() {
        return sendedMTime.getText();
    }

    public void setSendedMTime(String sendedMTime) {
        this.sendedMTime.setText(sendedMTime);
    }

    public String getSendedMText() {
        return sendedMText.getText();
    }

    public void setSendedMText(String sendedMText) {
        this.sendedMText.setText(sendedMText);
    }

    public Avatar getSendedMAvatar() {
        return sendedMAvatar;
    }

    public void setSendedMAvatar(byte [] image) {
        this.sendedMAvatar.setImage(new Image(new ByteArrayInputStream(image)));
    }
    
}

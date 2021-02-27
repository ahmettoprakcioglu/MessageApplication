/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package messageapp.PartMessage;

import com.gluonhq.charm.glisten.control.Avatar;
import java.io.IOException;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;

/**
 *
 * @author AHMET
 */
public class IncomingMessage extends HBox {
    @FXML
    private Avatar incomedMAvatar;

    @FXML
    private Label incomedMText;

    @FXML
    private Label incomedMTime;

    public IncomingMessage() {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("IncomingMessage.fxml"));
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

    public Avatar getIncomedMAvatar() {
        return incomedMAvatar;
    }

    public void setIncomedMAvatar(Avatar incomedMAvatar) {
        this.incomedMAvatar = incomedMAvatar;
    }

    public String getIncomedMText() {
        return incomedMText.getText();
    }

    public void setIncomedMText(String incomedMText) {
        this.incomedMText.setText(incomedMText);
    }

    public String getIncomedMTime() {
        return incomedMTime.getText();
    }

    public void setIncomedMTime(String incomedMTime) {
        this.incomedMTime.setText(incomedMTime);
    }
    
}

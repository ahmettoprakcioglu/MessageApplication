/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package messageapp;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import messageapp.BIN.DatabaseManager;
import messageapp.Inbox.InboxPart;
import messageapp.PartMessage.SendedMessage;
import messageapp.Profile.Profile;

/**
 *
 * @author AHMET
 */
public class FXMLDocumentController implements Initializable {

    @FXML
    private AnchorPane profile_part;
    @FXML
    private VBox inboxVbox;
    @FXML
    private VBox messagePartVbox;
    @FXML
    private TextField messageTextArea;
    @FXML
    private StackPane sendMButton;
    @FXML
    private ScrollPane messageAreaScroll;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        Profile userProfile = new Profile();
        messagePartVbox.heightProperty().addListener(observable -> messageAreaScroll.setVvalue(1D));
        profile_part.getChildren().add(userProfile);

    }

    @FXML
    private void sendButtonFunc(MouseEvent event) {
        createMessage();

    }

    @FXML
    private void sendEnterFunc(KeyEvent event) {
        if (event.getCode().equals(KeyCode.ENTER)) {
            createMessage();
        }

    }

    private void createMessage() {
        SendedMessage sendedM = new SendedMessage();
        sendedM.setSendedMText(messageTextArea.getText());
        sendedM.setSendedMAvatar(messageapp.BIN.CurrentUserDB.currentUser.getProfileImage());
        messagePartVbox.getChildren().add(sendedM);
        messageTextArea.setText("");
    }

}

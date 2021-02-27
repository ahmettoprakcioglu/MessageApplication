/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package messageapp.Inbox;

import Pojo.Message;
import com.gluonhq.charm.glisten.control.Avatar;
import java.io.ByteArrayInputStream;

import java.io.IOException;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Circle;
import messageapp.BIN.MCards;

/**
 *
 * @author AHMET
 */
public class InboxPart extends MCards<Pojo.Message> {

    @FXML
    private Avatar inboxAvatar;

    @FXML
    private Label inboxUserName;

    @FXML
    private Circle inboxOnline;

    @FXML
    private Label inboxPreMessage;

    @FXML
    private Label inboxTime;

    @FXML
    private Label inboxCountMessage;

    private Pojo.Message message;

    public InboxPart() {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("InboxPart.fxml"));
        fxmlLoader.setRoot(this);
        fxmlLoader.setController(this);

        try {
            fxmlLoader.load();
        } catch (IOException exception) {
            throw new RuntimeException(exception);
        }

        this.setOnMouseClicked((event) -> {
            VBox list = (VBox) this.getParent();
            list.getChildren().forEach((t) -> {
                InboxPart inbox = (InboxPart) t;
                t.getStyleClass().clear();
                t.getStyleClass().add("NoSelected");
            });
            this.getStyleClass().clear();
            this.getStyleClass().add("Selected");
        });

    }

    @FXML
    private void initialize() {

    }

    @Override
    public Message getData() {
        return message;
    }

    @Override
    public void setData(Message t) {
        this.message = t;
        inboxAvatar.setImage(new Image(new ByteArrayInputStream(message.getUsersByFromWho().getProfileImage())));
        inboxUserName.setText(message.getUsersByFromWho().getUserName());
        inboxPreMessage.setText(message.getMessageText());
    }

    

}

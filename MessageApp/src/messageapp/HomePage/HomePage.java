/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package messageapp.HomePage;

import java.io.IOException;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import messageapp.BIN.DatabaseManager;

/**
 *
 * @author AHMET
 */
public class HomePage extends HBox {

    @FXML
    private TextField loginUserName;

    @FXML
    private PasswordField loginPassword;

    @FXML
    private Label warningLabel;

    DatabaseManager<Pojo.Users> database = new DatabaseManager();
    

    public HomePage() {

        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("HomePage.fxml"));
        fxmlLoader.setRoot(this);
        fxmlLoader.setController(this);

        try {
            fxmlLoader.load();
        } catch (IOException exception) {
            throw new RuntimeException(exception);
        }
        // warningLabel.setVisible(false);
    }

    @FXML
    private void initialize() {

    }

    @FXML
    void loginButton(ActionEvent event) throws IOException{
        controlAndSet();

    }

    @FXML
    void loginRegisterClick(MouseEvent event) {
        setPageScene(new HomePageRegister());

    }

    @FXML
    void tabMethod(KeyEvent event) throws IOException {
         loginPassword.setFocusTraversable(true);
         if(event.getCode()== KeyCode.ENTER){
           controlAndSet();
         }
    }

    private boolean isControl() {
        return loginUserName.getText() != null && !loginUserName.getText().equals("") && loginPassword.getText() != null && !loginPassword.getText().equals("");
    }
    public void setPageScene(Parent root){
        messageapp.MessageApp.scene.setRoot(root);
    }
    public void controlAndSet() throws IOException{
         if (isControl()) {
            database.gets(Pojo.Users.class).filtered(t -> t.getUserName().equals(loginUserName.getText()) && t.getPassword().equals(loginPassword.getText())).forEach((temp) -> {
                messageapp.BIN.CurrentUserDB.currentUser = temp;
            });
            if (messageapp.BIN.CurrentUserDB.currentUser != null) { 
                setPageScene(FXMLLoader.load(messageapp.MessageApp.class.getResource("FXMLDocument.fxml")));
            } else {
                warningLabel.setVisible(true);
                warningLabel.setText("User Name or Password is not correct.");
                loginPassword.setText("");
            }

        } else {
            warningLabel.setText("Lütfen tüm alanları doldurunuz.");
            warningLabel.setVisible(true);
        }
    }
}

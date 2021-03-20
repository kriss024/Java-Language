package sample;

import javafx.fxml.FXML;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

public class Controller {
    @FXML
    private Text actiontarget;

    @FXML
    private TextField tittel;

    @FXML
    private PasswordField passwordField;

    @FXML
    protected void SubmitButtonAction() {
        actiontarget.setText("User "+tittel.getText()+". Your password is "+passwordField.getText());
    }

    @FXML
    void initialize(){
        actiontarget.setText("Hello!");
    }

}
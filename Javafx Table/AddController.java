package sample;

/**
 * Created by krzys on 23.12.2018.
 */

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class AddController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField firstName;

    @FXML
    private TextField lastName;

    @FXML
    private TextField email;

    @FXML
    private Button btnSave;

    @FXML
    void SaveClick(ActionEvent event) {
        AddDialog.firstName = firstName.getText();
        AddDialog.lastName = lastName.getText();
        AddDialog.email = email.getText();
        AddDialog.save = true;
        Stage stage = (Stage) btnSave.getScene().getWindow();
        stage.close();
    }

    @FXML
    void initialize() {

    }
}

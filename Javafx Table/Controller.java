package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;

import java.net.URL;
import java.util.ResourceBundle;

public class Controller {
    private AddDialog dialog;
    private final ObservableList<Person> data = FXCollections.observableArrayList();

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private AnchorPane panel;

    @FXML
    private Button button;

    @FXML
    private Button button2;


    @FXML
    private TableView<Person> tabela;

    @FXML
    void dodaj(ActionEvent event) {
        AddDialog dialog = new AddDialog();
        dialog.ShowAndWait();
        Person pers = dialog.ReturnPerson();
        if (pers!=null){
            data.add(pers);
            tabela.setItems(data);
        }

    }

    @FXML
    void usun(ActionEvent event) {
        tabela.getItems().removeAll(tabela.getSelectionModel().getSelectedItem());
    }

    @FXML
    void initialize() {
        dialog = new AddDialog();
        TableColumn idNameCol = new TableColumn("ID");
        TableColumn firstNameCol = new TableColumn("First Name");
        TableColumn lastNameCol = new TableColumn("Last Name");
        TableColumn emailCol = new TableColumn("Email");
        tabela.getColumns().addAll(idNameCol, firstNameCol, lastNameCol, emailCol);

        idNameCol.setCellValueFactory(
                new PropertyValueFactory<>("id")
        );
        firstNameCol.setCellValueFactory(
                new PropertyValueFactory<>("firstName")
        );
        lastNameCol.setCellValueFactory(
                new PropertyValueFactory<>("lastName")
        );
        emailCol.setCellValueFactory(
                new PropertyValueFactory<>("email")
        );

    }

}

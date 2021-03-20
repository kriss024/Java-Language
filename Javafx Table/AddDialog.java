package sample;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * Created by krzys on 23.12.2018.
 */
public class AddDialog {
    private Parent secondRoot = null;
    private Scene secondScene = null;
    private Stage newWindow = null;

    public static String firstName;
    public static String lastName;
    public static String email;
    public static boolean save;

    public AddDialog(){
        secondRoot = null;
        secondScene = null;
        newWindow = null;
        save = false;

        try {
            secondRoot = FXMLLoader.load(getClass().getResource("addform.fxml"));
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
        secondScene = new Scene(secondRoot);
        newWindow = new Stage();
        newWindow.setTitle("New/Edit Songs");
        newWindow.setScene(secondScene);
    }

    public void ShowAndWait(){
        newWindow.showAndWait();
    }

    public Person ReturnPerson(){
        if (save) {
            return new Person(firstName, lastName, email);
        } else return null;

    }
}

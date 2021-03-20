package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class Main extends Application {

    public static void main(String[] args) {

        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception{

        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(this.getClass().getResource("sample.fxml"));
        GridPane gridPane = loader.load();

        Scene scene = new Scene(gridPane);

        stage.setTitle("Hello World");
        stage.setScene(scene);
        stage.show();
    }

}

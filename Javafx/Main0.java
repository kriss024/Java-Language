import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;


public class Main extends Application {

    public static void main(String[] args) {

        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception
        {
            StackPane stackPane = new StackPane();
            Button button = new Button("Przycisk");
            stackPane.getChildren().add(button);

            Scene scene = new Scene(stackPane, 400, 600);
            primaryStage.setResizable(false);
            primaryStage.setScene(scene);
            primaryStage.setTitle("Pierwsze okno");
            primaryStage.show();
        }


}

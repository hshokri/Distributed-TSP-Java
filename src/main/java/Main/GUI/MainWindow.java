package Main.GUI;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class MainWindow extends Application {
    public static void Main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        try {
            Parent root = FXMLLoader.load(ClassLoader.getSystemResource("FXML/MainView.fxml"));
            var scene = new Scene(root, 1200, 800);

            stage.setScene(scene);
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        stage.setTitle("TSP distributed solver");
        stage.show();

        stage.onCloseRequestProperty().setValue(e -> {
            System.exit(0);
        });
    }
}

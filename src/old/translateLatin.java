package old;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class translateLatin extends Application{
    @Override
    public void start(Stage stage) throws Exception {
        Parent parent = FXMLLoader.load(getClass().getResource("old/Translate2.fxml"));
        Scene scene = new Scene(parent);
        stage.setTitle("Translate");
        stage.setScene(scene);
        stage.show();
    }
    public static void main(String[] args) {
        launch(args);

    }
}

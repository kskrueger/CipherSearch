package old;

import javafx.application.Application;
        import javafx.fxml.FXMLLoader;
        import javafx.scene.Parent;
        import javafx.scene.Scene;
        import javafx.stage.Stage;

public class TipTaxTotal extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        Parent parent = FXMLLoader.load(getClass().getResource("TipTaxTotal.fxml"));
        Scene scene = new Scene(parent);
        stage.setTitle("Tip Tax Total");
        stage.setScene(scene);
        stage.show();
    }
    public static void main(String[] args) {
        launch(args);

    }

}
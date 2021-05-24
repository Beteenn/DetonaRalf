package Boundary;

import Control.ViewControl;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class Main extends Application {
    public static Stage stage;

    public static BorderPane panePrincipal = new BorderPane();
    public static Scene scn = new Scene(panePrincipal, 1280, 720);

    @Override
    public void start(Stage primaryStage) throws Exception {
        stage = primaryStage;
        ViewControl.setPageView("listLabsBoundary");
        primaryStage.setTitle("Detona Ralf");
        primaryStage.show();
    }

    public static void main(String[] args) {
        Application.launch(Main.class, args);
    }
}

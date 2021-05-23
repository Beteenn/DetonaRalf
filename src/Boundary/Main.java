package Boundary;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class Main extends Application {

    private ListLabsBoundary listLabsBoundary = new ListLabsBoundary();
    private HomeBoundary homeBoundary = new HomeBoundary();
    private LoginBoundary loginBoundary = new LoginBoundary();
    private CreateLabBoundary createLabBoundary= new CreateLabBoundary();
    private UpdateLabBoundary updateLabBoundary= new UpdateLabBoundary();

    @Override
    public void start(Stage stage) throws Exception {
        GridPane gp = new GridPane();
        gp.setStyle("-fx-background-color: #FFFFFF");
        gp.setHgap(100);
        gp.setVgap(15);
        BorderPane panePrincipal = new BorderPane();
        Scene scn = new Scene(panePrincipal, 1280, 720);

        panePrincipal.setTop(Shared.appTopBar(false));
        panePrincipal.setCenter(updateLabBoundary.getCreateLabBoundary());

        stage.setScene(scn);
        stage.setTitle("Detona Ralf");
        stage.show();

    }

    public static void main(String[] args) {
        Application.launch(Main.class, args);
    }
}

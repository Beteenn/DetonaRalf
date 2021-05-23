package Boundary;

import Control.LaboratorioControl;
import Control.Repository;
import Entity.Laboratorio;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class Main extends Application {
    private static Stage stage;
    private static LaboratorioControl _labControl = new LaboratorioControl();

    private static ListLabsBoundary listLabsBoundary = new ListLabsBoundary(_labControl);
    private static HomeBoundary homeBoundary = new HomeBoundary();
    private static LoginBoundary loginBoundary = new LoginBoundary();
    private static CreateLabBoundary createLabBoundary= new CreateLabBoundary(_labControl);
    private static UpdateLabBoundary updateLabBoundary= new UpdateLabBoundary(_labControl);

    BorderPane panePrincipal = new BorderPane();
    Scene scn = new Scene(panePrincipal, 1280, 720);

    @Override
    public void start(Stage primaryStage) throws Exception {
        stage = primaryStage;
        GridPane gp = new GridPane();
        gp.setStyle("-fx-background-color: #FFFFFF");
        gp.setHgap(100);
        gp.setVgap(15);

        panePrincipal.setTop(Shared.appTopBar(true));
        panePrincipal.setCenter(updateLabBoundary.getUpdateLabBoundary());

        primaryStage.setScene(scn);
        primaryStage.setTitle("Detona Ralf");
        primaryStage.show();

    }

    public void setPageView() {
        GridPane gp = new GridPane();
        gp.setStyle("-fx-background-color: #FFFFFF");
        gp.setHgap(100);
        gp.setVgap(15);

        panePrincipal.setTop(Shared.appTopBar(true));
        panePrincipal.setCenter(createLabBoundary.getCreateLabBoundary());

        stage.setScene(scn);
    }

    public void setPreviousView() {
        GridPane gp = new GridPane();
        gp.setStyle("-fx-background-color: #FFFFFF");
        gp.setHgap(100);
        gp.setVgap(15);

        panePrincipal.setTop(Shared.appTopBar(true));
        panePrincipal.setCenter(listLabsBoundary.getListLabsBoundary());

        stage.setScene(scn);
    }

    public static void main(String[] args) {
        Application.launch(Main.class, args);
    }
}

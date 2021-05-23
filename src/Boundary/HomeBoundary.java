package Boundary;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class HomeBoundary extends Application{
  @Override
  public void start(Stage stage) throws Exception {
    GridPane gp = new GridPane();
    gp.setStyle("-fx-background-color: #FFFFFF");
    gp.setHgap(100);
    gp.setVgap(15);
    BorderPane panePrincipal = new BorderPane();
    Scene scn = new Scene(panePrincipal, 1280, 720);

    Button buttonLab = Shared.appButtonLarge("Laboratórios");
    Button buttonProf = Shared.appButtonLarge("Professores");
    Label title = Shared.appTitle("Detona Ralf");
    TextField field = Shared.appInput();
    MenuButton dropDown = Shared.appDropDownButton();

    gp.add(title,1, 0);
    gp.add(buttonLab,0, 1);
    gp.add(buttonProf,1, 1);
    gp.add(field,1, 2);
    gp.add(dropDown,1, 3);

    panePrincipal.setTop(Shared.appHeader(false));
    panePrincipal.setCenter(gp);

    buttonLab.setOnAction(e -> {
      System.out.println("Laboratorios");
    });

    buttonProf.setOnAction(e -> {
      System.out.println("Professores");
    });

    stage.setScene(scn);
    stage.setTitle("Detona Ralf");
    stage.show();

  }

  public static void main(String[] args) {
    Application.launch(HomeBoundary.class, args);
  }
}

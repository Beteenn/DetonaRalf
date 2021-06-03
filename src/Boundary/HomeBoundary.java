package Boundary;

import Control.ViewControl;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;

public class HomeBoundary {

  public Pane getHomeBoundary() {
    GridPane panePrincipal = new GridPane();

    Button buttonLab = Shared.appButtonLarge("Laboratórios");
    Button buttonProf = Shared.appButtonLarge("Professores");

    panePrincipal.setAlignment(Pos.CENTER);
    panePrincipal.setHgap(50);
    panePrincipal.setStyle("-fx-background-color: #FFFFFF");

    panePrincipal.add(buttonLab,1, 1);
    panePrincipal.add(buttonProf,2, 1);

    buttonLab.setOnAction(e -> {
      System.out.println("Laboratorios");
      ViewControl.setPageView("listLabsBoundary");
    });

    buttonProf.setOnAction(e -> {
      System.out.println("Professores");
    });

    return panePrincipal;
  }

}

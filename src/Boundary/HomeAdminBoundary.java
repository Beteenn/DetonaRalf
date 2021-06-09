package Boundary;

import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;

public class HomeAdminBoundary implements TelaStrategy {

  private ExecutorAcoes executor;

  public HomeAdminBoundary(ExecutorAcoes executor) {
    this.executor = executor;
  }

  public Pane getBoundary() {
    GridPane panePrincipal = new GridPane();

    Button buttonLab = new Button("Laboratórios");
    Button buttonProf = new Button("Professores");
    buttonLab.getStyleClass().add("button-large");
    buttonProf.getStyleClass().add("button-large");

    panePrincipal.setAlignment(Pos.CENTER);
    panePrincipal.setHgap(50);

    panePrincipal.add(buttonLab, 1, 1);
    panePrincipal.add(buttonProf, 2, 1);

    buttonLab.setOnAction(e -> {
      executor.navigate("listLabsBoundary");
    });

    buttonProf.setOnAction(e -> {
      executor.navigate("listProfessoresBoundary");
    });

    return panePrincipal;
  }

}

package Boundary;

import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;

public class HomeProfessorBoundary implements TelaStrategy {

  private ExecutorAcoes executor;

  public HomeProfessorBoundary(ExecutorAcoes executor) {
    this.executor = executor;
  }

  public Pane getBoundary() {
    GridPane panePrincipal = new GridPane();

    Button buttonLab = new Button("Reservar Laboratório");
    Button buttonProf = new Button("Minhas Reservas");
    buttonLab.getStyleClass().add("button-large");
    buttonProf.getStyleClass().add("button-large");

    panePrincipal.setAlignment(Pos.CENTER);
    panePrincipal.setHgap(50);

    panePrincipal.add(buttonLab, 1, 1);
    panePrincipal.add(buttonProf, 2, 1);

    buttonLab.setOnAction(e -> {
      executor.navigate("createReservaBoundary");
    });

    buttonProf.setOnAction(e -> {
      executor.navigate("listReservasBoundary");
    });

    return panePrincipal;
  }

}

package Boundary;

import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;

public class HomeBoundary implements TelaStrategy{

  private ExecutorAcoes executor;

  public HomeBoundary(ExecutorAcoes executor) {
    this.executor = executor;
  }

  public Pane getBoundary() {
    GridPane panePrincipal = new GridPane();

    Button buttonLab = new Button("Laboratórios");
    Button buttonProf = new Button("Professores");

    panePrincipal.setAlignment(Pos.CENTER);
    panePrincipal.setHgap(50);
    panePrincipal.setStyle("-fx-background-color: #FFFFFF");

    panePrincipal.add(buttonLab,1, 1);
    panePrincipal.add(buttonProf,2, 1);

    buttonLab.setOnAction(e -> {
      System.out.println("Laboratorios");
      executor.navigate("listLabsBoundary");
    });

    buttonProf.setOnAction(e -> {
      System.out.println("Professores");
    });

    return panePrincipal;
  }

}

package Boundary;

import Control.LaboratorioControl;
import javafx.application.Application;
import javafx.beans.binding.Bindings;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import javafx.util.StringConverter;
import javafx.util.converter.LongStringConverter;

public class ListLabsBoundary extends Application {
  private LaboratorioControl control = new LaboratorioControl();
  private Label textId = Shared.appLabel("Id");

  @Override
  public void start(Stage stage) throws Exception {
    GridPane gp = new GridPane();
    gp.setStyle("-fx-background-color: #FFFFFF");
    gp.setHgap(15);
    gp.setVgap(15);
    BorderPane panePrincipal = new BorderPane();
    Scene scn = new Scene(panePrincipal, 1280, 720);

    panePrincipal.setTop(Shared.appHeader(true));
    panePrincipal.setCenter(Shared.appTable(control.getLabs()));
    Button btnAdd = Shared.appButtonNormal("Adicionar");
    btnAdd.setOnAction(e -> {
      control.addLab();
    });

    panePrincipal.setLeft(btnAdd);

    StringConverter longToStringConverter = new LongStringConverter();

    Bindings.bindBidirectional(textId.textProperty(), control.idProperty(), longToStringConverter);

    stage.setScene(scn);
    stage.setTitle("Detona Ralf");
    stage.show();

  }

  public static void main(String[] args) {
    Application.launch(ListLabsBoundary.class, args);
  }
}

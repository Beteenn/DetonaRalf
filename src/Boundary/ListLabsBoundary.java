package Boundary;

import Control.LaboratorioControl;
import Entity.Laboratorio;
import javafx.beans.binding.Bindings;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.*;
import javafx.util.StringConverter;
import javafx.util.converter.LongStringConverter;

public class ListLabsBoundary {
  private LaboratorioControl control = new LaboratorioControl();
  private Label textId = Shared.appLabel("Id");


  public Pane getListLabsBoundary() {
    GridPane panePrincipal = new GridPane();
    panePrincipal.setAlignment(Pos.CENTER);

    Label titulo = new Label("Laboratórios");
    titulo.setStyle("-fx-font-size: 20px");

    Button btnAdd = Shared.appButtonNormal("Cadastrar");
    btnAdd.setOnAction(e -> {
      control.addLab();
    });

    Region region1 = new Region();
    HBox.setHgrow(region1, Priority.ALWAYS);

    HBox hbox = new HBox(titulo, region1, btnAdd);
    hbox.setPadding(new Insets(0,0,10,0));

    panePrincipal.add(hbox,1,0);
    panePrincipal.add(appTable(control.getLabs()),1,1);
    panePrincipal.setStyle("-fx-background-color: #FFFFFF");

    StringConverter longToStringConverter = new LongStringConverter();

    Bindings.bindBidirectional(textId.textProperty(), control.idProperty(), longToStringConverter);

    return panePrincipal;
  }

  private TableView appTable(ObservableList<Laboratorio> labs) {
    TableView<Laboratorio> tabela = new TableView<>();

    TableColumn<Laboratorio, String> colunaId = new TableColumn<>("Número");
    TableColumn<Laboratorio, String> colunaDesc = new TableColumn<>("Descrição");
    TableColumn<Laboratorio, String> colunaNumero = new TableColumn<>("Ação");

    colunaId.setCellValueFactory(new PropertyValueFactory<>("numero"));
    colunaDesc.setCellValueFactory(new PropertyValueFactory<>("descricao"));
    colunaNumero.setCellValueFactory(new PropertyValueFactory<>("acao"));

    colunaDesc.setMinWidth(500);

    tabela.getColumns().addAll(colunaId, colunaDesc, colunaNumero);
    tabela.setItems(labs);

    return tabela;

  }
}

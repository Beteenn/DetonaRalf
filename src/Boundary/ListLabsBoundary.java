package Boundary;

import Control.LaboratorioControl;
import Control.Repository;
import Entity.Laboratorio;
import javafx.beans.binding.Bindings;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.*;
import javafx.util.Callback;
import javafx.util.StringConverter;
import javafx.util.converter.LongStringConverter;

public class ListLabsBoundary {
  private LaboratorioControl _labControl;

  public ListLabsBoundary(LaboratorioControl control) {
    _labControl = control;
  }

  private TableView<Laboratorio> tabela = new TableView<>();

  private Main main = new Main();

  public Pane getListLabsBoundary() {
    GridPane panePrincipal = new GridPane();
    panePrincipal.setAlignment(Pos.CENTER);

    Label titulo = new Label("Laboratórios");
    titulo.setStyle("-fx-font-size: 20px");

    Button btnAdd = Shared.appButtonNormal("Cadastrar");
    btnAdd.setOnAction(e -> {
      main.setPageView();
    });

    Region region1 = new Region();
    HBox.setHgrow(region1, Priority.ALWAYS);

    HBox hbox = new HBox(titulo, region1, btnAdd);
    hbox.setPadding(new Insets(0,0,10,0));

    panePrincipal.add(hbox,1,0);
    panePrincipal.add(appTable(_labControl.getLabs()),1,1);
    panePrincipal.setStyle("-fx-background-color: #FFFFFF");

    return panePrincipal;
  }

  private TableView appTable(ObservableList<Laboratorio> labs) {
    tabela.getColumns().clear();

    tabela.setItems(labs);

    TableColumn<Laboratorio, String> colunaNumero = new TableColumn<>("Número");
    colunaNumero.setCellValueFactory(new PropertyValueFactory<>("numero"));

    TableColumn<Laboratorio, String> colunaDesc = new TableColumn<>("Descrição");
    colunaDesc.setCellValueFactory(new PropertyValueFactory<>("descricao"));
    colunaDesc.setMinWidth(500);


    tabela.getColumns().addAll(colunaNumero, colunaDesc);

    addButtonToTable();

    return tabela;

  }

  private void addButtonToTable() {
    TableColumn<Laboratorio, Void> colBtn = new TableColumn("Ações");

    Callback<TableColumn<Laboratorio, Void>, TableCell<Laboratorio, Void>> cellFactory = new Callback<TableColumn<Laboratorio, Void>, TableCell<Laboratorio, Void>>() {
      @Override
      public TableCell<Laboratorio, Void> call(final TableColumn<Laboratorio, Void> param) {
        final TableCell<Laboratorio, Void> cell = new TableCell<Laboratorio, Void>() {

          private final Button btn = new Button("Action");

          {
            btn.setOnAction((ActionEvent event) -> {
              Laboratorio lab = getTableView().getItems().get(getIndex());
              System.out.println("selectedData: " + lab.getId());
              System.out.println("selectedData: " + lab.getDescricao());
            });
          }

          @Override
          public void updateItem(Void item, boolean empty) {
            super.updateItem(item, empty);
            if (empty) {
              setGraphic(null);
            } else {
              setGraphic(btn);
            }
          }
        };
        return cell;
      }
    };

    colBtn.setCellFactory(cellFactory);

    tabela.getColumns().add(colBtn);

  }
}

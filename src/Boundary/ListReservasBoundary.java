package Boundary;

import Control.LaboratorioControl;
import Entity.Laboratorio;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.*;
import javafx.util.Callback;

import javax.swing.*;

public class ListReservasBoundary implements TelaStrategy {
  private LaboratorioControl _labControl = new LaboratorioControl();
  private ExecutorAcoes executor;

  public ListReservasBoundary(ExecutorAcoes executor) {
    this.executor = executor;
  }

  private TableView<Laboratorio> tabela = new TableView<>();

  public Pane getBoundary() {
    GridPane panePrincipal = new GridPane();
    panePrincipal.setAlignment(Pos.CENTER);

    Label titulo = new Label("Laboratórios");
    titulo.getStyleClass().add("titulo");

    Button btnCadastrar = new Button("Cadastrar");
    btnCadastrar.setOnAction(e -> {
      executor.navigate("createLabBoundary");
    });

    Region region1 = new Region();
    HBox.setHgrow(region1, Priority.ALWAYS);

    HBox hbox = new HBox(titulo, region1, btnCadastrar);
    hbox.setPadding(new Insets(0, 0, 10, 0));

    panePrincipal.add(hbox, 1, 0);

    panePrincipal.add(appTable(_labControl.listLabs()), 1, 1);

    return panePrincipal;
  }

  private TableView appTable(ObservableList<Laboratorio> labs) {
    tabela.getColumns().clear();

    tabela.setItems(labs);

    TableColumn<Laboratorio, String> colunaNumero = new TableColumn<>("Número");
    colunaNumero.setCellValueFactory(new PropertyValueFactory<>("numero"));

    TableColumn<Laboratorio, String> colunaDesc = new TableColumn<>("Descrição");
    colunaDesc.setCellValueFactory(new PropertyValueFactory<>("descricao"));
    colunaDesc.setMinWidth(450);

    tabela.getColumns().addAll(colunaNumero, colunaDesc);

    addButtonToTable();

    return tabela;

  }

  private void addButtonToTable() {
    TableColumn<Laboratorio, Void> colBtn = new TableColumn("Ações");
    colBtn.setMinWidth(250);

    Callback<TableColumn<Laboratorio, Void>, TableCell<Laboratorio, Void>> cellFactory = new Callback<TableColumn<Laboratorio, Void>, TableCell<Laboratorio, Void>>() {
      @Override
      public TableCell<Laboratorio, Void> call(final TableColumn<Laboratorio, Void> param) {
        final TableCell<Laboratorio, Void> cell = new TableCell<Laboratorio, Void>() {

          private final Button btnEditar = new Button("Editar");
          private final Button btnDeletar = new Button("Deletar");

          {
            btnEditar.setOnAction((ActionEvent event) -> {
              Laboratorio lab = getTableView().getItems().get(getIndex());
              _labControl.setLab(lab);
              executor.navigate("updateLabBoundary");
            });

            btnDeletar.setOnAction((ActionEvent event) -> {
              Laboratorio lab = getTableView().getItems().get(getIndex());
              int confirm = JOptionPane.showConfirmDialog(null, "Deletar o laboratório " + lab.getNumero() + "?");
              if (confirm == 0) {
                _labControl.deleteLab(lab);
                appTable(_labControl.listLabs());
              }
            });
          }

          HBox buttons = new HBox(btnEditar, btnDeletar);
          {
            buttons.setSpacing(10);
            buttons.setAlignment(Pos.CENTER);
          }

          @Override
          public void updateItem(Void item, boolean empty) {
            super.updateItem(item, empty);
            if (empty) {
              setGraphic(null);
            } else {
              setGraphic(buttons);
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

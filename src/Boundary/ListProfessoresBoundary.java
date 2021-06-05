package Boundary;

import Control.UsuarioControl;
import Entity.Usuario;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.*;
import javafx.util.Callback;
import javax.swing.*;

public class ListProfessoresBoundary implements TelaStrategy {
  private UsuarioControl _usuarioControl = new UsuarioControl();
  private ExecutorAcoes executor;

  public ListProfessoresBoundary(ExecutorAcoes executor) {
    this.executor = executor;
  }

  private TableView<Usuario> tabela = new TableView<>();

  public Pane getBoundary() {
    GridPane panePrincipal = new GridPane();
    panePrincipal.setAlignment(Pos.CENTER);

    Label titulo = new Label("Professores");
    titulo.getStyleClass().add("titulo");

    Button btnCadastrar = new Button("Cadastrar");
    btnCadastrar.setOnAction(e -> {
      executor.navigate("createProfessorBoundary");
    });

    Region region1 = new Region();
    HBox.setHgrow(region1, Priority.ALWAYS);

    HBox hbox = new HBox(titulo, region1, btnCadastrar);
    hbox.setPadding(new Insets(0, 0, 10, 0));

    panePrincipal.add(hbox, 1, 0);

    panePrincipal.add(appTable(_usuarioControl.listProfessores()), 1, 1);

    return panePrincipal;
  }

  private TableView appTable(ObservableList<Usuario> professores) {
    tabela.getColumns().clear();

    tabela.setItems(professores);

    TableColumn<Usuario, String> colunaNumero = new TableColumn<>("Nome");
    colunaNumero.setCellValueFactory(new PropertyValueFactory<>("nome"));

    TableColumn<Usuario, String> colunaDesc = new TableColumn<>("E-mail");
    colunaDesc.setCellValueFactory(new PropertyValueFactory<>("email"));
    colunaDesc.setMinWidth(450);

    tabela.getColumns().addAll(colunaNumero, colunaDesc);

    addButtonToTable();

    return tabela;

  }

  private void addButtonToTable() {
    TableColumn<Usuario, Void> colBtn = new TableColumn("Ações");
    colBtn.setMinWidth(250);

    Callback<TableColumn<Usuario, Void>, TableCell<Usuario, Void>> cellFactory = new Callback<TableColumn<Usuario, Void>, TableCell<Usuario, Void>>() {
      @Override
      public TableCell<Usuario, Void> call(final TableColumn<Usuario, Void> param) {
        final TableCell<Usuario, Void> cell = new TableCell<Usuario, Void>() {

          private final Button btnEditar = new Button("Editar");
          private final Button btnDeletar = new Button("Deletar");

          {
            btnEditar.setOnAction((ActionEvent event) -> {
              Usuario usuario = getTableView().getItems().get(getIndex());
              _usuarioControl.setProfessor(usuario);
              executor.navigate("updateLabBoundary");
            });

            btnDeletar.setOnAction((ActionEvent event) -> {
              Usuario usuario = getTableView().getItems().get(getIndex());
              int confirm = JOptionPane.showConfirmDialog(null, "Deletar o professor " + usuario.getNome() + "?");
              if (confirm == 0) {
                _usuarioControl.deleteProfessor(usuario);
                appTable(_usuarioControl.listProfessores());
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

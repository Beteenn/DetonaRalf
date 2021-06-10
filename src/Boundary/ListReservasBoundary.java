package Boundary;

import Control.ReservaControl;
import Entity.Reserva;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.*;
import javafx.util.Callback;
import java.time.LocalDateTime;

public class ListReservasBoundary implements TelaStrategy {
  private ReservaControl _reservaControl = new ReservaControl();
  private ExecutorAcoes executor;

  public ListReservasBoundary(ExecutorAcoes executor) {
    this.executor = executor;
  }

  private TableView<Reserva> tabela = new TableView<>();

  public Pane getBoundary() {
    GridPane panePrincipal = new GridPane();
    panePrincipal.setAlignment(Pos.CENTER);

    Label titulo = new Label("Minhas Reservas");
    titulo.getStyleClass().add("titulo");

    Button btnReservar = new Button("Reservar");
    btnReservar.setOnAction(e -> {
      executor.navigate("createReservaBoundary");
    });

    Region region1 = new Region();
    HBox.setHgrow(region1, Priority.ALWAYS);

    HBox hbox = new HBox(titulo, region1, btnReservar);
    hbox.setPadding(new Insets(0, 0, 10, 0));

    panePrincipal.add(hbox, 1, 0);

    panePrincipal.add(appTable(_reservaControl.listReservas()), 1, 1);

    return panePrincipal;
  }

  private TableView appTable(ObservableList<Reserva> reservas) {
    tabela.getColumns().clear();

    tabela.setItems(reservas);

    TableColumn<Reserva, String> colunaNumero = new TableColumn<>("Número");
    colunaNumero.setCellValueFactory(new PropertyValueFactory<>("numeroLab"));

    TableColumn<Reserva, String> colunaDesc = new TableColumn<>("Descrição");
    colunaDesc.setCellValueFactory(new PropertyValueFactory<>("descricaoLab"));
    colunaDesc.setPrefWidth(300);

    TableColumn<Reserva, LocalDateTime> colunaReserva = new TableColumn<>("Reserva");
    colunaReserva.setCellValueFactory(new PropertyValueFactory<>("reservaDate"));
    colunaReserva.setPrefWidth(150);

    TableColumn<Reserva, LocalDateTime> colunaEntrega = new TableColumn<>("Entrega");
    colunaEntrega.setCellValueFactory(new PropertyValueFactory<>("entregaDate"));
    colunaEntrega.setPrefWidth(150);

    tabela.getColumns().addAll(colunaNumero, colunaDesc, colunaReserva, colunaEntrega);

    addButtonToTable();

    return tabela;

  }

  private void addButtonToTable() {
    TableColumn<Reserva, Void> colBtn = new TableColumn("Ações");
    colBtn.setPrefWidth(250);

    Callback<TableColumn<Reserva, Void>, TableCell<Reserva, Void>> cellFactory = new Callback<TableColumn<Reserva, Void>, TableCell<Reserva, Void>>() {
      @Override
      public TableCell<Reserva, Void> call(final TableColumn<Reserva, Void> param) {
        final TableCell<Reserva, Void> cell = new TableCell<Reserva, Void>() {

          private final Button btnEditar = new Button("Editar");
          private final Button btnDeletar = new Button("Deletar");

          {
            btnEditar.setOnAction((ActionEvent event) -> {
              Reserva reserva = getTableView().getItems().get(getIndex());
              System.out.println("Reserva aquii -> " + reserva.getDescricaoLab());
              _reservaControl.setReserva(reserva);
              System.out.println("Property aqui -> " + _reservaControl.getLabTela());
              executor.navigate("editReservaBoundary");
            });

            btnDeletar.setOnAction((ActionEvent event) -> {
              Reserva reserva = getTableView().getItems().get(getIndex());
              _reservaControl.deleteReserva(reserva);
              appTable(_reservaControl.listReservas());
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

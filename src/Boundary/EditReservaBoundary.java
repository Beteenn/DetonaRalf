package Boundary;

import Control.ReservaControl;
import Control.UsuarioControl;
import Entity.Laboratorio;
import Entity.Reserva;
import Entity.Usuario;
import javafx.beans.binding.Bindings;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;

import javax.swing.*;

public class EditReservaBoundary implements TelaStrategy {
  private ReservaControl reservaControl = new ReservaControl();
  private ExecutorAcoes executor;

  public EditReservaBoundary(ExecutorAcoes executor) {
    this.executor = executor;
  }

  public Pane getBoundary() {
    GridPane panePrincipal = new GridPane();

    panePrincipal.setVgap(15);
    panePrincipal.setHgap(15);
    panePrincipal.setAlignment(Pos.CENTER);

    Label tituloPagina = new Label("Editar reserva");
    tituloPagina.getStyleClass().add("titulo");
    Label labelLab = new Label("Laboratorio");
    ComboBox comboLabs = new ComboBox<String>(reservaControl.listLabsTela());
    Label labeldataInicio = new Label("Hora Inicio");
    ComboBox comboDataInicio = new ComboBox<String>(reservaControl.datasInicio);
    Label labeldataFinal = new Label("Hora Final");
    ComboBox comboDataFinal = new ComboBox<String>(reservaControl.datasFinal);
    Button buttonAtualizar = new Button("Atualizar");

    panePrincipal.add(tituloPagina, 1, 0, 2, 1);
    panePrincipal.add(labelLab, 0, 1);
    panePrincipal.add(comboLabs, 1, 1);
    panePrincipal.add(labeldataInicio, 0, 2);
    panePrincipal.add(comboDataInicio, 1, 2);
    panePrincipal.add(labeldataFinal, 0, 3);
    panePrincipal.add(comboDataFinal, 1, 3);
    panePrincipal.add(buttonAtualizar, 1, 4);

    reservaControl.horasIniciaisDisponiveis();
    reservaControl.horasFinaisDisponiveis();

    comboLabs.valueProperty().bindBidirectional(reservaControl.labTelaProperty());
    comboDataInicio.valueProperty().bindBidirectional(reservaControl.horaInicialProperty());
    comboDataFinal.valueProperty().bindBidirectional(reservaControl.horaFinalProperty());

    comboLabs.getSelectionModel().selectFirst();
    comboDataInicio.getSelectionModel().selectFirst();
    comboDataFinal.getSelectionModel().selectFirst();

    buttonAtualizar.setOnAction(e -> {
      if (reservaControl.updateReserva()) {
        JOptionPane.showMessageDialog(null, "Reserva atualizada com sucesso!");
        executor.navigate("listReservasBoundary");
      } else {
        JOptionPane.showMessageDialog(null, "Erro ao atualizar Reserva!", "Erro", JOptionPane.ERROR_MESSAGE);
      }
    });

    return panePrincipal;
  }
}

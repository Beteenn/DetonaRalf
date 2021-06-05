package Boundary;

import Control.ReservaControl;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;

import javax.swing.*;

public class CreateReservaBoundary implements TelaStrategy {
    private ReservaControl reservaControl = new ReservaControl();
    private ExecutorAcoes executor;

    public CreateReservaBoundary(ExecutorAcoes executor) {
        this.executor = executor;
    }

    @Override
    public Pane getBoundary() {
        GridPane panePrincipal = new GridPane();
        panePrincipal.setVgap(15);
        panePrincipal.setHgap(15);
        panePrincipal.setAlignment(Pos.CENTER);

        Label tituloLabel = new Label("Cadastro de Reserva");
        tituloLabel.getStyleClass().add("titulo");

        HBox pageHeader = new HBox(tituloLabel);

        Label labelLab = new Label("Laboratorio");
        ComboBox comboLabs = new ComboBox<String>(reservaControl.listLabsTela());
        Label labeldataInicio = new Label("Hora Inicio");
        ComboBox comboDataInicio = new ComboBox<String>(reservaControl.datasInicio);
        Label labeldataFinal = new Label("Hora Final");
        ComboBox comboDataFinal = new ComboBox<String>(reservaControl.datasFinal);
        Button buttonReservar = new Button("Reservar");

        comboDataInicio.setDisable(true);
        comboDataFinal.setDisable(true);


        panePrincipal.add(pageHeader, 1, 0, 2, 1);
        panePrincipal.add(labelLab, 0, 1);
        panePrincipal.add(comboLabs, 1, 1);
        panePrincipal.add(labeldataInicio, 0, 2);
        panePrincipal.add(comboDataInicio, 1, 2);
        panePrincipal.add(labeldataFinal, 0, 3);
        panePrincipal.add(comboDataFinal, 1, 3);
        panePrincipal.add(buttonReservar, 1, 4);

        // reservaControl.clearLab();
//        StringConverter dateToStringConverter = new LocalDateStringConverter();
//        StringConverter intToStringConverter = new IntegerStringConverter();
        comboLabs.valueProperty().bindBidirectional(reservaControl.labTelaProperty());
        comboDataInicio.valueProperty().bindBidirectional(reservaControl.horaInicialProperty());
        comboDataFinal.valueProperty().bindBidirectional(reservaControl.horaFinalProperty());

        buttonReservar.setOnAction(e -> {
             if (reservaControl.insertReserva()) {
//                executor.navigate("");
                 System.out.println("Reservado");
             } else {
             JOptionPane.showMessageDialog(null, "Não foi possivel reservar!", "Erro",
             JOptionPane.ERROR_MESSAGE);
             }
        });

        comboLabs.setOnAction(e -> {
            reservaControl.horasIniciaisDisponiveis();
            comboDataInicio.setDisable(false);
        });

        comboDataInicio.setOnAction(e -> {
            reservaControl.horasFinaisDisponiveis();
            comboDataFinal.setDisable(false);
        });

        return panePrincipal;
    }
}

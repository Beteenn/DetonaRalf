package Boundary;

import Control.ReservaControl;
import javafx.beans.binding.Bindings;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.layout.*;
import javafx.util.StringConverter;
import javafx.util.converter.IntegerStringConverter;
import javafx.util.converter.LocalDateStringConverter;

import javax.swing.JOptionPane;

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
        reservaControl.listLabs();

        Label tituloLabel = new Label("Cadastro de Reserva");
        tituloLabel.getStyleClass().add("titulo");

        HBox pageHeader = new HBox(tituloLabel);

        Label labelLab = new Label("Laboratorio");
        ComboBox comboLabs = new ComboBox<String>(reservaControl.labs);
        Label labeldataInicio = new Label("Hora Inicio");
        ComboBox comboDataInicio = new ComboBox<String>(reservaControl.datasInicio);
        Label labeldataFinal = new Label("Hora Final");
        ComboBox comboDataFinal = new ComboBox<String>(reservaControl.datasFinal);
        Button buttonReservar = new Button("Reservar");

        panePrincipal.add(pageHeader, 1, 0, 2, 1);
        panePrincipal.add(labelLab, 0, 1);
        panePrincipal.add(comboLabs, 1, 1);
        panePrincipal.add(labeldataInicio, 0, 2);
        panePrincipal.add(comboDataInicio, 1, 2);
        panePrincipal.add(labeldataFinal, 0, 3);
        panePrincipal.add(comboDataFinal, 1, 3);
        panePrincipal.add(buttonReservar, 1, 4);

        // reservaControl.clearLab();
        StringConverter dateToStringConverter = new LocalDateStringConverter();
        // Bindings.bindBidirectional(comboLabs.getValue(), reservaControl.(),
        // intToStringConverter);
        // Bindings.bindBidirectional(comboDataInicio.getValue(),
        // reservaControl.dataReservaProperty());
        // Bindings.bindBidirectional(comboDataFinal.getValue(),
        // reservaControl.dataEntregaProperty());

        buttonReservar.setOnAction(e -> {
            System.out.println("LAB " + comboLabs.getValue());
            System.out.println("INICIO " + comboDataInicio.getValue());
            System.out.println("FINAL " + comboDataFinal.getValue());

            // if (reservaControl.insertReserva()) {
            // executor.navigate("listProfessoresBoundary");
            // } else {
            // JOptionPane.showMessageDialog(null, "Não foi possivel cadastrar o
            // laboratório", "Erro",
            // JOptionPane.ERROR_MESSAGE);
            // }
        });

        return panePrincipal;
    }

}

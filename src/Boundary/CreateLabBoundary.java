package Boundary;

import Control.LaboratorioControl;
import javafx.beans.binding.Bindings;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.*;
import javafx.util.StringConverter;
import javafx.util.converter.IntegerStringConverter;

import java.awt.HeadlessException;
import java.sql.SQLException;

import javax.swing.JOptionPane;

public class CreateLabBoundary implements TelaStrategy{
    private LaboratorioControl _labControl = new LaboratorioControl();
    private ExecutorAcoes executor;

    public CreateLabBoundary(ExecutorAcoes executor) {
        this.executor = executor;
    }

    @Override
    public Pane getBoundary() {
        GridPane panePrincipal = new GridPane();
        panePrincipal.setVgap(15);
        panePrincipal.setHgap(15);
        panePrincipal.setAlignment(Pos.CENTER);

        Label tituloLabel = new Label("Cadastro de Laboratórios");
        tituloLabel.setStyle("-fx-font-size: 20px");

        HBox pageHeader = new HBox(tituloLabel);

        Label labelNumero = new Label("Número");
        TextField inputNumero = new TextField();
        Label labelDescricao = new Label("Descrição");
        TextField inputDescricao = new TextField();
        Button buttonCadastrar = new Button("Cadastrar");

        panePrincipal.add(pageHeader, 1, 0, 2, 1);
        panePrincipal.add(labelNumero, 0, 1);
        panePrincipal.add(inputNumero, 1, 1);
        panePrincipal.add(labelDescricao, 0, 2);
        panePrincipal.add(inputDescricao, 1, 2);
        panePrincipal.add(buttonCadastrar, 1, 3);
        panePrincipal.setStyle("-fx-background-color: #FFFFFF");

        _labControl.clearLab();

        StringConverter intToStringConverter = new IntegerStringConverter();
        Bindings.bindBidirectional(inputNumero.textProperty(), _labControl.numeroProperty(), intToStringConverter);
        Bindings.bindBidirectional(inputDescricao.textProperty(), _labControl.descricaoProperty());

        buttonCadastrar.setOnAction(e -> {
            try {
                if (_labControl.insertLab()) {
                    executor.navigate("listLabsBoundary");
                } else {
                    JOptionPane.showMessageDialog(null, "Não foi possivel cadastrar o laboratório", "Erro",
                            JOptionPane.ERROR_MESSAGE);
                }
            } catch (HeadlessException | SQLException e1) {
                // TODO Auto-generated catch block
                e1.printStackTrace();
            }
        });

        return panePrincipal;
    }

}

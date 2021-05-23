package Boundary;

import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.*;

public class UpdateLabBoundary {

    public Pane getCreateLabBoundary(){
        GridPane panePrincipal = new GridPane();
        panePrincipal.setVgap(15);
        panePrincipal.setHgap(15);
        panePrincipal.setAlignment(Pos.CENTER);

        Label tituloLabel = new Label("Edição de Laboratórios");
        tituloLabel.setStyle("-fx-font-size: 20px");

        HBox pageHeader = new HBox(tituloLabel);

        Label labelNumero = Shared.appLabel("Número");
        TextField inputNumero = Shared.appInput();
        Label labelDescricao = Shared.appLabel("Descrição");
        TextField inputDescricao = Shared.appInput();
        Button buttonSalvar = Shared.appButtonNormal("Salvar");

        panePrincipal.add(pageHeader,1, 0,2,1);
        panePrincipal.add(labelNumero,0,1);
        panePrincipal.add(inputNumero,1,1);
        panePrincipal.add(labelDescricao,0,2);
        panePrincipal.add(inputDescricao,1,2);
        panePrincipal.add(buttonSalvar,1,3);
        panePrincipal.setStyle("-fx-background-color: #FFFFFF");

        return panePrincipal;
    }
}

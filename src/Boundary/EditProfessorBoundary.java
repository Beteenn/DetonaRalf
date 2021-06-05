package Boundary;

import Control.UsuarioControl;
import Entity.Usuario;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;

import javax.swing.*;

public class EditProfessorBoundary implements TelaStrategy {
  private final UsuarioControl usuarioControl = new UsuarioControl();
  private ExecutorAcoes executor;

  public EditProfessorBoundary(ExecutorAcoes executor) {
    this.executor = executor;
  }

  public Pane getBoundary() {
    GridPane panePrincipal = new GridPane();

    panePrincipal.setVgap(15);
    panePrincipal.setHgap(15);
    panePrincipal.setAlignment(Pos.CENTER);

    Label tituloPagina = new Label("Editar professor");
    tituloPagina.getStyleClass().add("titulo");
    Label labelNome = new Label("Nome");
    TextField inputNome = new TextField();
    Label labelEmail = new Label("Email");
    TextField inputEmail = new TextField();
    Button buttonEntrar = new Button("Atualizar");

    panePrincipal.add(tituloPagina, 1, 0, 2, 1);
    panePrincipal.add(labelNome, 0, 1);
    panePrincipal.add(inputNome, 1, 1);
    panePrincipal.add(labelEmail, 0, 2);
    panePrincipal.add(inputEmail, 1, 2);
    panePrincipal.add(buttonEntrar, 1, 3);

    buttonEntrar.setOnAction(e -> {
      if (usuarioControl.updateUsuario(inputNome.getText(), inputEmail.getText())) {
        JOptionPane.showMessageDialog(null, "Professor atualizado com sucesso!");
        //TODO: add list professor view on navigate
        executor.navigate("listProfessoresBoundary");
      } else {
        JOptionPane.showMessageDialog(null, "Erro ao atualizar professor!", "Erro",
                JOptionPane.ERROR_MESSAGE);
      }
    });

    return panePrincipal;
  }
}


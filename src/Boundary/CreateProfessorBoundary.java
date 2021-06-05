package Boundary;

import Control.UsuarioControl;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;

import javax.swing.JOptionPane;

public class CreateProfessorBoundary implements TelaStrategy {
  private final UsuarioControl usuarioControl = new UsuarioControl();

  public Pane getBoundary() {
    GridPane panePrincipal = new GridPane();
    panePrincipal.setStyle("-fx-background-color: #FFFFFF");
    panePrincipal.setVgap(15);
    panePrincipal.setHgap(15);
    panePrincipal.setAlignment(Pos.CENTER);

    Label tituloPagina = new Label("Cadastrar Professor");
    Label labelNome = new Label("Nome");
    Label labelEmail = new Label("E-mail");
    Label labelSenha = new Label("Senha");
    Label labelConfirmarSenha = new Label("Confirmar senha");
    TextField inputNome = new TextField();
    TextField inputEmail = new TextField();
    TextField inputSenha = new TextField();
    TextField inputConfirmarSenha = new TextField();
    Button buttonCadastrar = new Button("Cadastre-se");

    panePrincipal.add(tituloPagina, 1, 0, 2, 1);
    panePrincipal.add(labelNome, 0, 1);
    panePrincipal.add(inputNome, 1, 1);
    panePrincipal.add(labelEmail, 0, 2);
    panePrincipal.add(inputEmail, 1, 2);
    panePrincipal.add(labelSenha, 0, 3);
    panePrincipal.add(inputSenha, 1, 3);
    panePrincipal.add(labelConfirmarSenha, 0, 4);
    panePrincipal.add(inputConfirmarSenha, 1, 4);
    panePrincipal.add(buttonCadastrar, 1, 5);

    buttonCadastrar.setOnAction(e -> {
      int confirm = JOptionPane.showConfirmDialog(null, "Usuário cadastrado com sucesso!");
      if (confirm == 0) {
        if (usuarioControl.insertUsuario(inputNome.getText(), inputEmail.getText(), inputSenha.getText(),
                inputConfirmarSenha.getText()))
          JOptionPane.showMessageDialog(null, "Usuário cadastrado com sucesso!");
      }
    });

    return panePrincipal;
  }
}

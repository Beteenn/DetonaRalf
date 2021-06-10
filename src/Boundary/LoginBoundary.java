package Boundary;

import Control.AuthControl;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;

import javax.swing.*;

public class LoginBoundary implements TelaStrategy {

  private ExecutorAcoes executor;
  private AuthControl authControl = new AuthControl();

  public LoginBoundary(ExecutorAcoes executor) {
    this.executor = executor;
  }

  public Pane getBoundary() {
    GridPane panePrincipal = new GridPane();

    panePrincipal.setVgap(15);
    panePrincipal.setHgap(15);
    panePrincipal.setAlignment(Pos.CENTER);

    Label tituloPagina = new Label("Detona Ralf");
    tituloPagina.getStyleClass().add("titulo-logo");
    Label labelEmail = new Label("E-mail");
    TextField inputEmail = new TextField();
    Label labelSenha = new Label("Senha");
    PasswordField inputSenha = new PasswordField();
    // TextField inputSenha = new TextField();
    Button buttonEntrar = new Button("Entrar");

    panePrincipal.add(tituloPagina, 1, 0, 2, 1);
    panePrincipal.add(labelEmail, 0, 1);
    panePrincipal.add(inputEmail, 1, 1);
    panePrincipal.add(labelSenha, 0, 2);
    panePrincipal.add(inputSenha, 1, 2);
    panePrincipal.add(buttonEntrar, 1, 3);

    buttonEntrar.setOnAction(e -> {
      Integer currentUserPerfilId = authControl.login(inputEmail.getText(), inputSenha.getText());
      if (currentUserPerfilId == null)
        JOptionPane.showMessageDialog(null, "Error", "Login inválido. Tente novamente!", JOptionPane.ERROR_MESSAGE);
      else if (currentUserPerfilId == 1)
        executor.navigate("homeAdminBoundary");
      else if (currentUserPerfilId == 2)
        executor.navigate("homeProfessorBoundary");
    });

    return panePrincipal;
  }
}

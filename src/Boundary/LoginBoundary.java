package Boundary;

import Control.AuthControl;
import Control.ViewControl;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javax.swing.JOptionPane;

public class LoginBoundary {
  private AuthControl authControl;

  public LoginBoundary(AuthControl authControl) {
    this.authControl = authControl;
  }

  public Pane getLoginBoundary() {
    GridPane panePrincipal = new GridPane();
    panePrincipal.setStyle("-fx-background-color: #FFFFFF");
    panePrincipal.setVgap(15);
    panePrincipal.setHgap(15);
    panePrincipal.setAlignment(Pos.CENTER);

    Label tituloPagina = Shared.appTitle("Detona Ralf");
    Label labelEmail = Shared.appLabel("E-mail");
    TextField inputEmail = Shared.appInput();
    Label labelSenha = Shared.appLabel("Senha");
    TextField inputSenha = Shared.appInput();
    Button buttonEntrar = Shared.appButtonNormal("Entrar");

    panePrincipal.add(tituloPagina, 1, 0, 2, 1);
    panePrincipal.add(labelEmail, 0, 1);
    panePrincipal.add(inputEmail, 1, 1);
    panePrincipal.add(labelSenha, 0, 2);
    panePrincipal.add(inputSenha, 1, 2);
    panePrincipal.add(buttonEntrar, 1, 3);

    buttonEntrar.setOnAction(e -> {
      Integer currentUserPerfilId = authControl.login(inputEmail.getText(), inputSenha.getText());
      if (currentUserPerfilId == null)
        JOptionPane.showMessageDialog(null, "Error", "Login inválido. Tente novamente!",
                JOptionPane.ERROR_MESSAGE);
      else ViewControl.setPageView("homeBoundary");
    });

    return panePrincipal;
  }
}

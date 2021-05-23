package Boundary;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class LoginBoundary extends Application {

  @Override
  public void start(Stage stage) throws Exception {
    GridPane gp = new GridPane();
    gp.setStyle("-fx-background-color: #FFFFFF");
    gp.setHgap(15);
    gp.setVgap(15);
    BorderPane panePrincipal = new BorderPane();
    Scene scn = new Scene(panePrincipal, 1280, 720);

    Label tituloPagina = Shared.appTitle("Detona Ralf");
    Label labelEmail = Shared.appLabel("E-mail");
    TextField inputEmail = Shared.appInput();
    Label labelSenha = Shared.appLabel("Senha");
    TextField inputSenha = Shared.appInput();
    Button buttonEntrar = Shared.appButtonNormal("Entrar");

    gp.add(tituloPagina,0, 0);
    gp.add(labelEmail,0, 1);
    gp.add(inputEmail,1, 1);
    gp.add(labelSenha,0, 2);
    gp.add(inputSenha,1, 2);
    gp.add(buttonEntrar,1, 3);

    panePrincipal.setCenter(gp);

    buttonEntrar.setOnAction(e -> {
      System.out.println("Entrando");
    });

    stage.setScene(scn);
    stage.setTitle("Detona Ralf");
    stage.show();

  }

  public static void main(String[] args) {
    Application.launch(LoginBoundary.class, args);
  }
}

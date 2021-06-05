package Boundary;

import Control.LaboratorioControl;
import Repository.ILabDao;
import Repository.LabDao;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.event.EventTarget;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

public class Main extends Application implements ExecutorAcoes {

    private LaboratorioControl labControl = new LaboratorioControl();

    private TelaStrategy createLabBoundary = new CreateLabBoundary(this);
    private TelaStrategy listLabsBoundary = new ListLabsBoundary(this);
    private TelaStrategy homeBoundary = new HomeBoundary(this);
    private TelaStrategy updateLabBoundary = new UpdateLabBoundary(this);
    private TelaStrategy loginBoundary = new LoginBoundary(this);

    private Header header = new Header();

    public static BorderPane bp = new BorderPane();

    private Map<String, TelaStrategy> mapaTelas = new HashMap<>();

    private void gerarMapaTelas() {
        mapaTelas.put("createLabBoundary", createLabBoundary);
        mapaTelas.put("listLabsBoundary", listLabsBoundary);
        mapaTelas.put("homeBoundary", homeBoundary);
        mapaTelas.put("updateLabBoundary", updateLabBoundary);
        mapaTelas.put("loginBoundary", loginBoundary);
    }

    @Override
    public void start(Stage primaryStage) {
        Scene scn = new Scene(bp, 1280, 720);

        gerarMapaTelas();

        bp.setCenter(loginBoundary.getBoundary());

        primaryStage.setScene(scn);
        primaryStage.setTitle("Detona Ralf");
        primaryStage.show();
    }

    public static void main(String[] args) {
        Application.launch(Main.class, args);
    }

    @Override
    public void navigate(String acao) {
        TelaStrategy tela = mapaTelas.get(acao);
        boolean isHome = false;
        if (acao.equals("homeBoundary")) isHome = true;
        bp.setTop(header.getTopBar(isHome));
        bp.setCenter(tela.getBoundary());
    }

}

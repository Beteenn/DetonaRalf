package Boundary;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main extends Application implements ExecutorAcoes {

    private TelaStrategy createLabBoundary = new CreateLabBoundary(this);
    private TelaStrategy listLabsBoundary = new ListLabsBoundary(this);
    private TelaStrategy homeAdminBoundary = new HomeAdminBoundary(this);
    private TelaStrategy homeProfessorBoundary = new HomeProfessorBoundary(this);
    private TelaStrategy listProfessoresBoundary = new ListProfessoresBoundary(this);
    private TelaStrategy updateLabBoundary = new UpdateLabBoundary(this);
    private TelaStrategy loginBoundary = new LoginBoundary(this);
    private TelaStrategy createProfessorBoundary = new CreateProfessorBoundary(this);
    private TelaStrategy editProfessorBoundary = new EditProfessorBoundary(this);
    private TelaStrategy createReservaBoundary = new CreateReservaBoundary(this);
    private TelaStrategy listReservasBoundary = new ListReservasBoundary(this);

    private Header header = new Header(this);

    public static BorderPane bp = new BorderPane();

    private Map<String, TelaStrategy> mapaTelas = new HashMap<>();
    private List<String> historicoTelas = new ArrayList<String>();

    private void gerarMapaTelas() {
        mapaTelas.put("createLabBoundary", createLabBoundary);
        mapaTelas.put("listLabsBoundary", listLabsBoundary);
        mapaTelas.put("homeAdminBoundary", homeAdminBoundary);
        mapaTelas.put("updateLabBoundary", updateLabBoundary);
        mapaTelas.put("loginBoundary", loginBoundary);
        mapaTelas.put("createProfessorBoundary", createProfessorBoundary);
        mapaTelas.put("listProfessoresBoundary", listProfessoresBoundary);
        mapaTelas.put("homeProfessorBoundary", homeProfessorBoundary);
        mapaTelas.put("editProfessorBoundary", editProfessorBoundary);
        mapaTelas.put("createReservaBoundary", createReservaBoundary);
        mapaTelas.put("listReservasBoundary", listReservasBoundary);
    }

    @Override
    public void start(Stage primaryStage) {
        Scene scn = new Scene(bp, 1280, 720);

        gerarMapaTelas();

        bp.setCenter(loginBoundary.getBoundary());

        scn.getStylesheets().add(getClass().getResource("style.css").toExternalForm());

        primaryStage.setScene(scn);
        primaryStage.setTitle("Detona Ralf");
        primaryStage.show();
    }

    public static void main(String[] args) {
        Application.launch(Main.class, args);
    }

    @Override
    public void navigate(String acao) {
        if (!acao.equals("voltar")) {
            historicoTelas.add(acao);
//        } else if (historicoTelas.size() >= 2) {
        } else {
            acao = historicoTelas.get(historicoTelas.size() - 2);
            historicoTelas.remove(historicoTelas.size() - 1);
        }
        TelaStrategy tela = mapaTelas.get(acao);
        boolean isHome = false;
        if (acao.contains("home"))
            isHome = true;

        bp.setTop(header.getTopBar(isHome));
        bp.setCenter(tela.getBoundary());
    }

}

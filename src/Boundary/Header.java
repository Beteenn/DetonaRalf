package Boundary;

import javafx.application.Platform;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.Priority;

public class Header {

    private ExecutorAcoes executor;

    public Header(ExecutorAcoes executor) {
        this.executor = executor;
    }

    public Pane getTopBar(boolean isHome) {
        GridPane header = new GridPane();
        header.setStyle("-fx-background-color: #FFFFFF");
        header.setPadding(new Insets(10));
        header.setHgap(10);

        ColumnConstraints col1 = new ColumnConstraints();
        col1.setHgrow(Priority.ALWAYS);
        header.getColumnConstraints().add(col1);

        Label logo = new Label("Detona Ralf");
        logo.setStyle("-fx-font-size: 30px");
        Button btnVoltar = new Button("Voltar");
        Button btnSair = new Button("Sair");

        if (!isHome) {
            header.getChildren().addAll(logo, btnVoltar, btnSair);
            GridPane.setColumnIndex(btnVoltar, 1);
        } else {
            header.getChildren().addAll(logo, btnSair);
        }

        GridPane.setColumnIndex(logo, 0);
        GridPane.setColumnIndex(btnSair, 2);

        btnVoltar.setOnAction((e) -> {
            executor.navigate("voltar");
        });

        btnSair.setOnAction((e) -> {
            Platform.exit();
            System.exit(0);
        });

        return header;
    }
}

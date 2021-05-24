package Boundary;

import Entity.Laboratorio;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.*;
import javafx.util.Callback;


public class Shared {
  public static GridPane appTopBar(boolean isHome) {
    GridPane header = new GridPane();
    header.setStyle("-fx-background-color: #FFFFFF");
    header.setPadding(new Insets(10));
    header.setHgap(10);

    ColumnConstraints col1 = new ColumnConstraints();
    col1.setHgrow(Priority.ALWAYS);
    header.getColumnConstraints().add(col1);

    Label logo = new Label("Detona Ralf");
    logo.setStyle("-fx-font-size: 30px");
    Button btnVoltar = appButtonNormal("Voltar");
    Button btnSair = appButtonNormal("Sair");

    if (!isHome) {
      header.getChildren().addAll(logo, btnVoltar, btnSair);
      GridPane.setColumnIndex(btnVoltar, 1);
    } else {
      header.getChildren().addAll(logo, btnSair);
    }

    GridPane.setColumnIndex(logo, 0);
    GridPane.setColumnIndex(btnSair, 2);

    btnVoltar.setOnAction((e)->{
      System.out.println("Voltando");
      Main main = new Main();
      main.setPreviousView();
    });

    btnSair.setOnAction((e)->{
      System.out.println("Saindo");
    });
    
    return header;
  }

  public static Button appButtonNormal(String texto) {
    Button botao = new Button(texto);
    botao.setMinSize(100, 10);
    botao.setStyle("-fx-background-color: #FF234B; -fx-text-fill: #FFFFFF; -fx-font-size: 14px");

    return botao;
  }

  public static Button appButtonLarge(String texto) {
    Button card = new Button(texto);
    card.setMinSize(250, 90);
    card.setStyle("-fx-background-color: #FF234B; -fx-text-fill: #FFFFFF; -fx-font-size: 14px");

    return card;
  }

  public static MenuButton appDropDownButton() {
    MenuButton dropDown = new MenuButton();
    dropDown.getItems().addAll(appItemMenu("Opcao 1"), appItemMenu("Opcao 2"));
    dropDown.setMinSize(250, 10);
    dropDown.setStyle("-fx-background-color: #FFFFFF; -fx-text-fill: #000000; -fx-font-size: 14px; -fx-border-color: #757575; -fx-border-insets: 1px");

    return dropDown;
  }

  public static MenuItem appItemMenu(String texto) {
    MenuItem item = new MenuItem(texto);
    item.setStyle("-fx-background-color: #FFFFFF; -fx-text-fill: #000000; -fx-font-size: 14px;");

    return item;
  }

  public static TableView appTable(ObservableList<Laboratorio> labs) {
    TableView<Laboratorio> tabela = new TableView<>();

    TableColumn<Laboratorio, String> colunaId = new TableColumn<>("Id");
    TableColumn<Laboratorio, String> colunaDesc = new TableColumn<>("Descrição");
    TableColumn<Laboratorio, String> colunaNumero = new TableColumn<>("Número");

    colunaId.setCellValueFactory(new PropertyValueFactory<>("id"));
    colunaDesc.setCellValueFactory(new PropertyValueFactory<>("descricao"));
    colunaNumero.setCellValueFactory(new PropertyValueFactory<>("numero"));

    colunaDesc.setMinWidth(500);

    tabela.getColumns().addAll(colunaId, colunaDesc, colunaNumero);
    tabela.setItems(labs);

    return tabela;

  }

  public static TextField appInput() {
    TextField input = new TextField();
    input.setMinSize(250, 10);
    input.setStyle("-fx-background-color: #FFFFFF; -fx-text-fill: #000000; -fx-font-size: 14px; -fx-border-color: #757575; -fx-border-insets: 1px");

    return input;
  }

  public static Label appLabel(String texto) {
    Label label = new Label(texto);
    label.setStyle("-fx-font-size: 20px");

    return label;
  }

  public static Label appTitle(String texto) {
    Label label = new Label(texto);
    label.setStyle("-fx-font-size: 40px");

    return label;
  }
}

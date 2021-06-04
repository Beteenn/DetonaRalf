package Control;

import Boundary.*;
import Repository.ILabDao;
import Repository.LabDao;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;

import java.sql.SQLException;

public class ViewControl {

  private static ILabDao labDao;

  static {
    try {
      labDao = new LabDao();
    } catch (ClassNotFoundException e) {
      e.printStackTrace();
    } catch (SQLException throwables) {
      throwables.printStackTrace();
    }
  }

  private final static LaboratorioControl _labControl = new LaboratorioControl(labDao);

  private final static ListLabsBoundary listLabsBoundary = new ListLabsBoundary(_labControl);
  private final static HomeBoundary homeBoundary = new HomeBoundary();
  private final static LoginBoundary loginBoundary = new LoginBoundary();
  private final static CreateLabBoundary createLabBoundary = new CreateLabBoundary(_labControl);
  private final static UpdateLabBoundary updateLabBoundary = new UpdateLabBoundary(_labControl);

  public static void setPageView(String page) {
    boolean isHome = false;
    Pane pageComponent = homeBoundary.getHomeBoundary();

    GridPane gp = new GridPane();
    gp.setStyle("-fx-background-color: #FFFFFF");
    gp.setHgap(100);
    gp.setVgap(15);

    if (page.equals("homeBoundary")) {
      isHome = true;
    }

    switch (page) {
      case "homeBoundary":
        pageComponent = homeBoundary.getHomeBoundary();
        break;
      case "listLabsBoundary":
        pageComponent = listLabsBoundary.getListLabsBoundary();
        break;
      case "createLabBoundary":
        pageComponent = createLabBoundary.getCreateLabBoundary();
        break;
      case "updateLabBoundary":
        pageComponent = updateLabBoundary.getUpdateLabBoundary();
        break;
    }

    Main.panePrincipal.setTop(Shared.appTopBar(isHome));
    Main.panePrincipal.setCenter(pageComponent);

    Main.stage.setScene(Main.scn);
  }

}

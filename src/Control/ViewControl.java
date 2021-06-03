package Control;

import Boundary.*;
import Repository.ILabDao;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;

public class ViewControl {

  private static ILabDao labDao;
  private static LaboratorioControl _labControl = new LaboratorioControl(labDao);

  private static ListLabsBoundary listLabsBoundary = new ListLabsBoundary(_labControl);
  private static HomeBoundary homeBoundary = new HomeBoundary();
  private static LoginBoundary loginBoundary = new LoginBoundary();
  private static CreateLabBoundary createLabBoundary= new CreateLabBoundary(_labControl);
  private static UpdateLabBoundary updateLabBoundary= new UpdateLabBoundary(_labControl);


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

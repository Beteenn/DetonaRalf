package Control;

import Entity.Laboratorio;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Repository {
  private ObservableList<Laboratorio> labs = FXCollections.observableArrayList();

  public void addLab(Laboratorio lab) {
    labs.add(lab);
  }

  public boolean updateLab(Laboratorio lab) {
    for (Laboratorio labRep : this.labs) {
      if (lab.getId() == labRep.getId()) {
        labRep.setNumero(lab.getNumero());
        labRep.setDescricao(lab.getDescricao());
        return true;
      }
    }

    return false;
  }

  public boolean removeLab(Laboratorio lab) {
    for (Laboratorio labRep : this.labs) {
      if (labRep.getId() == lab.getId()) {
        labs.remove(lab);
        System.out.println(labs.size());
        return true;
      }
    }
    return false;
  }

  public ObservableList<Laboratorio> getLabs() {
    return labs;
  }

  public void setLabs(ObservableList<Laboratorio> labs) {
    this.labs = labs;
  }

  public boolean exists(Laboratorio lab) {
    for (Laboratorio labRep : this.labs) {
      if (lab.getNumero() == labRep.getNumero()) {
        return true;
      }
    }

    return false;
  }

}

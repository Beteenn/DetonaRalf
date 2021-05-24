package Control;

import Boundary.Main;
import Entity.Laboratorio;
import javafx.beans.property.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class LaboratorioControl {
  private Main mainView = new Main();
  private Repository _repLab = new Repository();

  private LongProperty id = new SimpleLongProperty(0);
  private StringProperty descricao = new SimpleStringProperty("");
  private IntegerProperty numero = new SimpleIntegerProperty(0);

  public boolean addLab() {
    Laboratorio lab = getLab();

    if (lab.getNumero() == 0) {
      System.out.println("Falta o numero");
      return false;
    }

    if (lab.getDescricao().equals("")) {
      System.out.println("Falta desc");
      return false;
    }

    if (_repLab.exists(lab)) {
      System.out.println("Numero ja cadastrado");
      return false;
    }

    lab.setId(_repLab.getLabs().size() + 1);
    _repLab.addLab(lab);

    clearLab();

    return true;
  }

  public boolean updateLab() {
    Laboratorio lab = getLab();

    return _repLab.updateLab(lab);
  }

  public void list() {
    ObservableList<Laboratorio> labs = _repLab.getLabs();
    for (Laboratorio labRep : labs) {
      System.out.println(labRep.getId());
      System.out.println(labRep.getNumero());
      System.out.println(labRep.getDescricao());
      System.out.println("---------------------------");
    }
  }

  public void navigatePages(String namePage) {
    mainView.setPageView(namePage);
  }

  public void clearLab() {
    descricao.setValue("");
    numero.setValue(0);
  }

  public void removeLab(Laboratorio lab) {
    _repLab.removeLab(lab);
  }

  public Laboratorio getLab() {
    Laboratorio lab = new Laboratorio();
    lab.setId(id.get());
    lab.setDescricao(descricao.get());
    lab.setNumero(numero.get());

    return lab;
  }

  public void setLab(Laboratorio lab) {
    if (lab != null) {
      id.set(lab.getId());
      descricao.set(lab.getDescricao());
      numero.set(lab.getNumero());
    }
  }

  //region Getters
  public ObservableList<Laboratorio> getLabs() {
    return _repLab.getLabs();
  }

  public long getId() {
    return id.get();
  }

  public LongProperty idProperty() {
    return id;
  }

  public String getDescricao() {
    return descricao.get();
  }

  public StringProperty descricaoProperty() {
    return descricao;
  }

  public int getNumero() {
    return numero.get();
  }

  public IntegerProperty numeroProperty() {
    return numero;
  }
  //endregion


}

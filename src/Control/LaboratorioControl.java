package Control;

import Entity.Laboratorio;
import javafx.beans.property.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class LaboratorioControl {

  private ObservableList<Laboratorio> labs = FXCollections.observableArrayList();

  private LongProperty id = new SimpleLongProperty(0);
  private StringProperty descricao = new SimpleStringProperty("");
  private IntegerProperty numero = new SimpleIntegerProperty(0);

  public void addLab() {
    Laboratorio lab = new Laboratorio();
    lab.setId(1);
    lab.setDescricao("Testando");
    labs.add(lab);
  }

  public void removeLab() {
    int index = labs.size() - 1;
    if (index >= 0) {
      labs.remove(index);
    }
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
    return labs;
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

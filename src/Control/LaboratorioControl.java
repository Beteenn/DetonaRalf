package Control;

import Entity.Laboratorio;
import Repository.ILabDao;
import Repository.LabDao;
import javafx.beans.property.*;
import javafx.collections.ObservableList;

import java.sql.SQLException;

public class LaboratorioControl {

  private ILabDao _labDao;

  {
    try {
      _labDao = new LabDao();
    } catch (ClassNotFoundException | SQLException e) {
      e.printStackTrace();
    }
  }

  private ObservableList<Laboratorio> labs;

  private static IntegerProperty id = new SimpleIntegerProperty(0);
  private static StringProperty descricao = new SimpleStringProperty("");
  private static IntegerProperty numero = new SimpleIntegerProperty(0);

  public ObservableList<Laboratorio> listLabs() {
    try {
      labs = _labDao.listLabs();
    } catch (SQLException e) {
      e.printStackTrace();
    }

    return labs;
  }

  public Laboratorio getLab() {
    Laboratorio lab = new Laboratorio();
    lab.setId(4);
    try {
      lab = _labDao.getLab(lab);
    } catch (SQLException e) {
      e.printStackTrace();
    }

    return lab;

  }

  public boolean insertLab() {
    Laboratorio lab = new Laboratorio();
    lab.setDescricao(descricao.get());
    lab.setNumero(numero.get());
    try {
      _labDao.insertLab(lab);
    } catch (SQLException e) {
      e.printStackTrace();
    }

    return true;
  }

  public boolean updateLab() {

    try {
      _labDao.updateLab(getLabProperty());
    } catch (SQLException throwables) {
      throwables.printStackTrace();
    }

    return true;

  }

  public void deleteLab(Laboratorio lab) {
    try {
      _labDao.deleteLab(lab.getId());
    } catch (SQLException throwables) {
      throwables.printStackTrace();
    }

    listLabs();
  }

  public void clearLab() {
    descricao.setValue("");
    numero.setValue(0);
  }

  public Laboratorio getLabProperty() {
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

  // region Getters
  // public ObservableList<Laboratorio> getLabs() {
  // return _labDao.getLabs();
  // }

  public int getId() {
    return id.get();
  }

  public IntegerProperty idProperty() {
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
  // endregion

}

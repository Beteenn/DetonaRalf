package Control;

import Entity.Laboratorio;
import Repository.ILabDao;
import javafx.beans.property.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.SQLException;

public class LaboratorioControl {

  private ILabDao _labDao;
  private ObservableList<Laboratorio> labs;

  public LaboratorioControl(ILabDao labDao) {
    _labDao = labDao;
  }

  private IntegerProperty id = new SimpleIntegerProperty(0);
  private StringProperty descricao = new SimpleStringProperty("");
  private IntegerProperty numero = new SimpleIntegerProperty(0);

  public ObservableList<Laboratorio> listLabs() throws SQLException {
    labs = _labDao.listLabs();

    return labs;
  }

  public Laboratorio getLab() throws SQLException {
    Laboratorio lab = new Laboratorio();
    lab.setId(4);
    return _labDao.getLab(lab);

  }

  public boolean insertLab() throws SQLException {
    Laboratorio lab = new Laboratorio();
    lab.setDescricao(descricao.get());
    lab.setNumero(numero.get());
    _labDao.insertLab(lab);

    return true;
  }

  public boolean updateLab() throws SQLException {

    _labDao.updateLab(getLabProperty());

    return true;

  }

  public void deleteLab(Laboratorio lab) throws SQLException {
    _labDao.deleteLab(lab.getId());

    listLabs();
  }

  public void navigatePages(String namePage) {
    ViewControl.setPageView(namePage);
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

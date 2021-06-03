package Control;

import Entity.Laboratorio;
import Repository.ILabDao;
import Repository.LabDao;
//import Repository.LaboratorioRepository;
import javafx.beans.property.*;
import javafx.collections.ObservableList;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class LaboratorioControl {

  private ILabDao _labDao;

  public LaboratorioControl(ILabDao labDao) {
    _labDao = labDao;
  }

  private LongProperty id = new SimpleLongProperty(0);
  private StringProperty descricao = new SimpleStringProperty("");
  private IntegerProperty numero = new SimpleIntegerProperty(0);


  public List<Laboratorio> listLabs() throws SQLException {
    List<Laboratorio> labs = new ArrayList<>();
    labs = _labDao.listLabs();

    return labs;
  }

  public Laboratorio getLab() throws SQLException {
    Laboratorio lab = new Laboratorio();
    lab.setId(4);
    return _labDao.getLab(lab);

  }

  public void insertLab() throws SQLException {
    Laboratorio lab = new Laboratorio();
//    lab.setNumero(14);
    lab.setDescricao("Testando a criação criada");
    _labDao.insertLab(lab);
  }

  public void updateLab() throws SQLException {
    Laboratorio lab = new Laboratorio();
    lab.setId(4);

    lab = _labDao.getLab(lab);

    lab.setDescricao("Descricao atualizada pelo metodo que atualiza o atualizado");

    _labDao.updateLab(lab);

  }

  public void deleteLab() throws SQLException {
    Laboratorio lab = new Laboratorio();
    lab.setId(3);

    _labDao.deleteLab(lab);
    System.out.println("Deletadassassasos");
  }







  public void navigatePages(String namePage) {
    ViewControl.setPageView(namePage);
  }

  public void clearLab() {
    descricao.setValue("");
    numero.setValue(0);
  }

//  public Laboratorio getLab() {
//    Laboratorio lab = new Laboratorio();
//    lab.setId(id.get());
//    lab.setDescricao(descricao.get());
//    lab.setNumero(numero.get());
//
//    return lab;
//  }

  public void setLab(Laboratorio lab) {
    if (lab != null) {
      id.set(lab.getId());
      descricao.set(lab.getDescricao());
      numero.set(lab.getNumero());
    }
  }

  //region Getters
//  public ObservableList<Laboratorio> getLabs() {
//    return _labDao.getLabs();
//  }

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

package Repository;

import Entity.Laboratorio;
import javafx.collections.ObservableList;

import java.sql.SQLException;

public interface ILabDao {
  void insertLab(Laboratorio lab) throws SQLException;

  void updateLab(Laboratorio lab) throws SQLException;

  void deleteLab(int labId) throws SQLException;

  Laboratorio getLab(int id) throws SQLException;

  ObservableList<Laboratorio> listLabs() throws SQLException;
}

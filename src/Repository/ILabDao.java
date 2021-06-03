package Repository;

import Entity.Laboratorio;

import java.sql.SQLException;
import java.util.List;

public interface ILabDao {
  void insertLab(Laboratorio lab) throws SQLException;
  void updateLab(Laboratorio lab) throws SQLException;
  void deleteLab(Laboratorio lab) throws SQLException;
  Laboratorio getLab(Laboratorio lab) throws SQLException;
  List<Laboratorio> listLabs() throws SQLException;
}

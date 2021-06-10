package Repository;

import Entity.Reserva;
import javafx.collections.ObservableList;

import java.sql.SQLException;

public interface IReservaDao {

  Reserva getReserva(Reserva reserva) throws SQLException;

  ObservableList<Reserva> listReservas() throws SQLException;

  void insertReserva(Reserva reserva) throws SQLException;

  void updateReserva(Reserva reserva) throws SQLException;

  void deleteReserva(Reserva reserva) throws SQLException;

}

package Repository;

import Entity.Reserva;

import java.sql.SQLException;
import java.util.List;

public interface IReservaDao {

  Reserva getReserva(Reserva reserva) throws SQLException;

  List<Reserva> listReservas() throws SQLException;

  void insertReserva(Reserva reserva) throws SQLException;

  void updateReserva(Reserva reserva) throws SQLException;

  void deleteReserva(Reserva reserva) throws SQLException;

}

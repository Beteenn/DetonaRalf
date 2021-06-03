package Control;

import Entity.Reserva;
import Repository.IReservaDao;

import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ReservaControl {

  private IReservaDao _reservaDao;

  public ReservaControl(IReservaDao reservaDao) {
      _reservaDao = reservaDao;
    }

    //private LongProperty id = new SimpleLongProperty(0);
    //private StringProperty descricao = new SimpleStringProperty("");
    //private IntegerProperty numero = new SimpleIntegerProperty(0);


    public List<Reserva> listreservas() throws SQLException {
      List<Reserva> reservas = new ArrayList<>();
      reservas = _reservaDao.listReservas();

      return reservas;
    }

    public Reserva getReserva() throws SQLException {
      Reserva reserva = new Reserva();
      reserva.setId(2);
      return _reservaDao.getReserva(reserva);

    }

    public void insertReserva() throws SQLException {

      Timestamp reservaDate = new Timestamp(new Date().getTime());

      Reserva reserva = new Reserva();
      reserva.setLabId(1);
      reserva.setUsuarioId(1);
      reserva.setReservaDate(Instant.now());
      reserva.setEntregaDate(Instant.now());
      _reservaDao.insertReserva(reserva);
    }

    public void updateReserva() throws SQLException {
      Reserva reserva = new Reserva();
      reserva.setId(2);

      reserva = _reservaDao.getReserva(reserva);

      reserva.setLabId(2);

      _reservaDao.updateReserva(reserva);

    }

    public void deleteReserva() throws SQLException {
      Reserva reserva = new Reserva();
      reserva.setId(2);

      _reservaDao.deleteReserva(reserva);
      System.out.println("Reserva deletada");
    }
}

package Control;

import Entity.Laboratorio;
import Entity.Reserva;
import Repository.IReservaDao;
import Repository.ReservaDao;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ReservaControl {

  private IReservaDao _reservaDao;
  {
    try {
      _reservaDao = new ReservaDao();
    } catch (ClassNotFoundException | SQLException e) {
      e.printStackTrace();
    }
  }

  LaboratorioControl labControl = new LaboratorioControl();

  public static ObservableList<String> labs = FXCollections.observableArrayList();
  public static ObservableList<String> datasInicio = FXCollections.observableArrayList("Data 1", "Data 2", "Data 3");
  public static ObservableList<String> datasFinal = FXCollections.observableArrayList("Data Final 1", "Data Final 2",
      "Data Final 3");

  private IntegerProperty id = new SimpleIntegerProperty(0);
  private IntegerProperty usuarioId = new SimpleIntegerProperty(0);
  private IntegerProperty labId = new SimpleIntegerProperty(0);
  private StringProperty dataReserva = new SimpleStringProperty("");
  private StringProperty dataEntrega = new SimpleStringProperty("");

  public ObservableList<String> listLabs() {
    ObservableList<Laboratorio> tempLabs;
    tempLabs = labControl.listLabs();
    for (Laboratorio lab : tempLabs) {
      labs.add(lab.getNumero() + " - " + lab.getDescricao());
    }

    return labs;
  }

  public List<Reserva> listreservas() {
    List<Reserva> reservas = new ArrayList<>();
    try {
      reservas = _reservaDao.listReservas();
    } catch (SQLException e) {
      e.printStackTrace();
    }

    return reservas;
  }

  public Reserva getReserva() {
    Reserva reserva = new Reserva();
    reserva.setId(2);
    try {
      reserva = _reservaDao.getReserva(reserva);
    } catch (SQLException e) {
      e.printStackTrace();
    }

    return reserva;
  }

  public boolean insertReserva() {

    Timestamp reservaDate = new Timestamp(new Date().getTime());

    Reserva reserva = new Reserva();
    reserva.setLabId(1);
    reserva.setUsuarioId(1);
    reserva.setReservaDate(Instant.now());
    reserva.setEntregaDate(Instant.now());
    try {
      _reservaDao.insertReserva(reserva);
    } catch (SQLException e) {
      e.printStackTrace();
    }

    return true;
  }

  public void updateReserva() {
    Reserva reserva = new Reserva();
    reserva.setId(2);

    try {
      reserva = _reservaDao.getReserva(reserva);
    } catch (SQLException e) {
      e.printStackTrace();
    }

    reserva.setLabId(2);

    try {
      _reservaDao.updateReserva(reserva);
    } catch (SQLException e) {
      e.printStackTrace();
    }

  }

  public void deleteReserva() {
    Reserva reserva = new Reserva();
    reserva.setId(2);

    try {
      _reservaDao.deleteReserva(reserva);
    } catch (SQLException e) {
      e.printStackTrace();
    }
    System.out.println("Reserva deletada");
  }

  public int getId() {
    return id.get();
  }

  public IntegerProperty idProperty() {
    return id;
  }

  public int getUsuarioId() {
    return usuarioId.get();
  }

  public IntegerProperty usuarioIdProperty() {
    return usuarioId;
  }

  public int getLabId() {
    return labId.get();
  }

  public IntegerProperty labIdProperty() {
    return labId;
  }

  public String getDataReserva() {
    return dataReserva.get();
  }

  public StringProperty dataReservaProperty() {
    return dataReserva;
  }

  public String getDataEntrega() {
    return dataEntrega.get();
  }

  public StringProperty dataEntregaProperty() {
    return dataEntrega;
  }

}

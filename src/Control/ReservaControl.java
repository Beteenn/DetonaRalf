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
import java.time.*;
import java.util.ArrayList;
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

  ObservableList<Laboratorio> labsDisponiveis;

  AuthControl authControl = new AuthControl();

  public ReservaControl() {
    carregaHoras();
    labsDisponiveis = labControl.listLabs();
  }

  private final List<Integer> horasInicio = new ArrayList<Integer>();
  private final List<Integer> horasFim = new ArrayList<Integer>();

  public void carregaHoras() {
    for (int i = 9; i < 23; i++) {
      horasInicio.add(i);
    }
    for (int i = 9; i < 23; i++) {
      horasFim.add(i);
    }
  }

  LaboratorioControl labControl = new LaboratorioControl();

  public static ObservableList<String> labs = FXCollections.observableArrayList();
  public static ObservableList<String> datasInicio = FXCollections.observableArrayList();
  public static ObservableList<String> datasFinal = FXCollections.observableArrayList();

  public void horasIniciaisDisponiveis() {
    for (Integer i : horasInicio) {
      datasInicio.add(i.toString() + ":00");
    }
  }

  public void horasFinaisDisponiveis() {
    for (Integer i : horasFim) {
      datasFinal.add(i.toString() + ":00");
    }
  }

  private ObservableList<Reserva> reservas;

  private static IntegerProperty id = new SimpleIntegerProperty(0);
  private StringProperty labTela = new SimpleStringProperty("");
  private StringProperty horaInicial = new SimpleStringProperty("");
  private StringProperty horaFinal = new SimpleStringProperty("");

  public ObservableList<String> listLabsTela() {
    for (Laboratorio lab : labsDisponiveis) {
      labs.add(lab.getNumero() + " - " + lab.getDescricao());
    }

    return labs;
  }

  public ObservableList<Reserva> listReservas() {
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
    if (labTela.get().equals("") || horaInicial.get().equals("") || horaFinal.get().equals(""))
      return false;

    int numeroLab = Integer.parseInt(labTela.get().split(" - ")[0]);
    String descricaoLab = labTela.get().split(" - ")[1];

    Laboratorio lab = null;

    for (Laboratorio _lab : labsDisponiveis) {
      if (_lab.getNumero() == numeroLab && _lab.getDescricao().equals(descricaoLab))
        lab = _lab;
    }

    if (lab == null)
      return false;

    Reserva reserva = new Reserva();
    reserva.setLabId(lab.getId());
    reserva.setUsuarioId(authControl.getCurrentUser().getId());
    reserva.setReservaDate(LocalDate.now().atTime(Integer.parseInt(horaInicial.get().split(":")[0]), 0));
    reserva.setEntregaDate(LocalDate.now().atTime(Integer.parseInt(horaFinal.get().split(":")[0]), 0));
    try {
      _reservaDao.insertReserva(reserva);
    } catch (SQLException e) {
      e.printStackTrace();
    }

    return true;
  }

  public boolean updateReserva() {
    Reserva reserva = new Reserva();

    try {
      _reservaDao.updateReserva(reserva);
    } catch (SQLException e) {
      e.printStackTrace();
    }

    reserva.setLabId(2);

    try {
      _reservaDao.updateReserva(reserva);
    } catch (SQLException e) {
      e.printStackTrace();
    }

    return true;

  }

  public void deleteReserva(Reserva reserva) {
    try {
      _reservaDao.deleteReserva(reserva);
    } catch (SQLException e) {
      e.printStackTrace();
    }
    System.out.println("Reserva deletada");
  }

  public String getLabTela() {
    return labTela.get();
  }

  public StringProperty labTelaProperty() {
    return labTela;
  }

  public String getHoraInicial() {
    return horaInicial.get();
  }

  public StringProperty horaInicialProperty() {
    return horaInicial;
  }

  public String getHoraFinal() {
    return horaFinal.get();
  }

  public StringProperty horaFinalProperty() {
    return horaFinal;
  }

  public int getId() {
    return id.get();
  }

  public IntegerProperty idProperty() {
    return id;
  }

  public void setReserva(Reserva reserva) {
    if (reserva != null) {
      labTela.set(labControl.getLab(reserva.getLabId()).getDescricao());
      horaInicial.set(reserva.getReservaDate().toString());
      id.set(reserva.getId());
      horaFinal.set(reserva.getEntregaDate().toString());
    }
  }

  public Reserva getLabProperty() {
    Reserva reserva = new Reserva();
    // reserva.setId(id.get());
    // reserva.setEntregaDate(horaInicial.get());
    // reserva.setDescricaoLab(descricao.get());
    // reserva.setNumero(numero.get());

    return reserva;
  }
}

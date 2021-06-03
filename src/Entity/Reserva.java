package Entity;


import java.time.Instant;

public class Reserva {
  private int id;
  private int usuarioId;
  private int labId;
  private Instant reservaDate;
  private Instant entregaDate;

  // region Getters and Setters
  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public int getUsuarioId() {
    return usuarioId;
  }

  public void setUsuarioId(int usuarioId) {
    this.usuarioId = usuarioId;
  }

  public int getLabId() {
    return labId;
  }

  public void setLabId(int labId) {
    this.labId = labId;
  }

  public Instant getReservaDate() {
    return reservaDate;
  }

  public void setReservaDate(Instant reservaDate) {
    this.reservaDate = reservaDate;
  }

  public Instant getEntregaDate() {
    return entregaDate;
  }

  public void setEntregaDate(Instant entregaDate) {
    this.entregaDate = entregaDate;
  }
// endregion


}

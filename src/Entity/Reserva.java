package Entity;


import java.time.LocalDateTime;

public class Reserva {
  private int id;
  private int usuarioId;
  private int labId;
  private LocalDateTime reservaDate;
  private LocalDateTime entregaDate;

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

  public LocalDateTime getReservaDate() {
    return reservaDate;
  }

  public void setReservaDate(LocalDateTime reservaDate) {
    this.reservaDate = reservaDate;
  }

  public LocalDateTime getEntregaDate() {
    return entregaDate;
  }

  public void setEntregaDate(LocalDateTime entregaDate) {
    this.entregaDate = entregaDate;
  }
// endregion


}

package Repository;

import Entity.Reserva;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ReservaDao implements IReservaDao{
  private Connection connection;

  public ReservaDao() throws ClassNotFoundException, SQLException{
    IGenericDao dao = new GenericDao();
    connection = dao.getConnection();
  }

  @Override
  public Reserva getReserva(Reserva reserva) throws SQLException {
    String sql = "SELECT * FROM reserva WHERE id = ?";
    PreparedStatement ps = connection.prepareStatement(sql);
    ps.setInt(1, reserva.getId());
    ResultSet rs = ps.executeQuery();
    if (rs.next()){
      reserva.setLabId(rs.getInt("laboratorio_id"));
      reserva.setUsuarioId(rs.getInt("usuario_id"));
      reserva.setEntregaDate(rs.getTimestamp("entrega").toLocalDateTime());
      reserva.setReservaDate(rs.getTimestamp("reserva").toLocalDateTime());
    }

    rs.close();
    ps.close();

    return reserva;
  }

  @Override
  public List<Reserva> listReservas() throws SQLException {
    List<Reserva> reservas = new ArrayList<>();
    String sql = "SELECT * FROM Reserva";
    PreparedStatement ps = connection.prepareStatement(sql);
    ResultSet rs = ps.executeQuery();
    while(rs.next()){
      Reserva reserva = new Reserva();
      System.out.println(rs.getInt("id"));
      reservas.add(reserva);
    }
    rs.close();
    ps.close();

    return reservas;
  }

  @Override
  public void insertReserva(Reserva reserva) throws SQLException {
    String sql = "INSERT INTO reserva (laboratorio_id, usuario_id, reserva, entrega) VALUES (?,?,?,?)";
    PreparedStatement ps = connection.prepareStatement(sql);
    ps.setInt(1, reserva.getLabId());
    ps.setInt(2, reserva.getUsuarioId());
    ps.setTimestamp(3, Timestamp.valueOf(reserva.getReservaDate()));
    ps.setTimestamp(4, Timestamp.valueOf(reserva.getEntregaDate()));
    ps.execute();
    ps.close();
  }

  @Override
  public void updateReserva(Reserva reserva) throws SQLException {
    String sql = "UPDATE reserva SET laboratorio_id = ?, usuario_id = ?, reserva = ?, entrega = ? WHERE id = ?";
    PreparedStatement ps = connection.prepareStatement(sql);
    ps.setInt(1, reserva.getLabId());
    ps.setInt(2, reserva.getUsuarioId());
    ps.setTimestamp(3, Timestamp.valueOf(reserva.getReservaDate()));
    ps.setTimestamp(4, Timestamp.valueOf(reserva.getEntregaDate()));
    ps.setInt(5, reserva.getId());
    ps.execute();
    ps.close();
  }

  @Override
  public void deleteReserva(Reserva reserva) throws SQLException {
    String sql = "DELETE FROM reserva WHERE id = ?";
    PreparedStatement ps = connection.prepareStatement(sql);
    ps.setInt(1, reserva.getId());
    ps.execute();
    ps.close();
  }
}

package Repository;

import Entity.Laboratorio;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class LabDao implements ILabDao{
  private Connection connection;

  public LabDao() throws ClassNotFoundException, SQLException{
    IGenericDao dao = new GenericDao();
    connection = dao.getConnection();
  }
  
  @Override
  public void insertLab(Laboratorio lab) throws SQLException {
    String sql = "INSERT INTO laboratorio (descricao, numero) VALUES (?,?)";
    PreparedStatement ps = connection.prepareStatement(sql);
    ps.setString(1, lab.getDescricao());
    ps.setInt(2, lab.getNumero());
    ps.execute();
    ps.close();

  }

  @Override
  public void updateLab(Laboratorio lab) throws SQLException {
    String sql = "UPDATE laboratorio SET descricao = ?, numero = ? WHERE id = ?";
    PreparedStatement ps = connection.prepareStatement(sql);
    ps.setString(1, lab.getDescricao());
    ps.setInt(2, lab.getNumero());
    ps.setInt(3, (int)lab.getId());
    ps.execute();
    ps.close();
  }

  @Override
  public void deleteLab(Laboratorio lab) throws SQLException {
    String sql = "DELETE FROM laboratorio WHERE id = ?";
    PreparedStatement ps = connection.prepareStatement(sql);
    ps.setInt(1, (int)lab.getId());
    ps.execute();
    ps.close();
  }

  @Override
  public Laboratorio getLab(Laboratorio lab) throws SQLException {
    String sql = "SELECT * FROM laboratorio WHERE id = ?";
    PreparedStatement ps = connection.prepareStatement(sql);
    ps.setInt(1, (int)lab.getId());
    ResultSet rs = ps.executeQuery();
    if (rs.next()){
      lab.setId(rs.getInt("id"));
      lab.setDescricao(rs.getString("descricao"));
      lab.setNumero(rs.getInt("numero"));
    }

    rs.close();
    ps.close();

    return lab;
  }

  @Override
  public List<Laboratorio> listLabs() throws SQLException {
    List<Laboratorio> labs = new ArrayList<>();
    String sql = "SELECT * FROM laboratorio";
    PreparedStatement ps = connection.prepareStatement(sql);
    ResultSet rs = ps.executeQuery();
    while(rs.next()){
      Laboratorio lab = new Laboratorio();
      System.out.println(rs.getInt("id"));
      labs.add(lab);
    }
    rs.close();
    ps.close();

    return labs;
  }
}

package Repository;

import Entity.Usuario;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UsuarioDao implements IUsuarioDao {

  private Connection connection;

  public UsuarioDao() throws ClassNotFoundException, SQLException {
    IGenericDao dao = new GenericDao();
    connection = dao.getConnection();
  }

  @Override
  public void insertUsuario(Usuario usuario) throws SQLException {
    String sql = "INSERT INTO usuario(nome, email, senha, perfil_id) VALUES (?, ?, ?, ?)";
    PreparedStatement ps = connection.prepareStatement(sql);
    ps.setString(1, usuario.getNome());
    ps.setString(2, usuario.getEmail());
    ps.setString(3, usuario.getSenha());
    ps.setInt(4, usuario.getPerfilId());
    ps.execute();
    ps.close();
  }

  @Override
  public void updateUsuario(Usuario usuario) throws SQLException {
    String sql = "UPDATE usuario SET nome = ?, email = ?, senha = ?, perfil_id = ? WHERE id = ?";
    PreparedStatement ps = connection.prepareStatement(sql);
    ps.setString(1, usuario.getNome());
    ps.setString(2, usuario.getEmail());
    ps.setString(3, usuario.getSenha());
    ps.setInt(4, usuario.getPerfilId());
    ps.setInt(5, usuario.getId());
    ps.execute();
    ps.close();
  }

  @Override
  public void deleteUsuario(Usuario usuario) throws SQLException {
    String sql = "DELETE FROM usuario WHERE id = ?";
    PreparedStatement ps = connection.prepareStatement(sql);
    ps.setInt(1, usuario.getId());
    ps.execute();
    ps.close();
  }

  @Override
  public Usuario getUsuario(Usuario usuario) throws SQLException {
    String sql = "SELECT * from usuario WHERE id = ?";
    PreparedStatement ps = connection.prepareStatement(sql);
    ps.setInt(1, usuario.getId());
    ResultSet rs = ps.executeQuery();
    if (rs.next()) {
      usuario.setId(rs.getInt("id"));
      System.out.println(rs.getString("nome"));
    }

    ps.close();
    rs.close();

    return usuario;
  }

  public Usuario getUsuarioByLogin(String email, String senha) throws SQLException {
    String sql = "SELECT * from usuario WHERE email = ? AND senha = ?";
    PreparedStatement ps = connection.prepareStatement(sql);
    ps.setString(1, email);
    ps.setString(2, senha);
    ResultSet rs = ps.executeQuery();

    if (rs.next()) {
      Usuario usuario = new Usuario();
      usuario.setId(rs.getInt("id"));
      usuario.setEmail(rs.getString("email"));
      usuario.setNome(rs.getString("nome"));
      usuario.setSenha(rs.getString("senha"));
      usuario.setPerfilId(rs.getInt("perfil_id"));

      ps.close();
      rs.close();

      return usuario;
    }

    ps.close();
    rs.close();

    return null;
  }

  @Override
  public ObservableList<Usuario> listProfessores() throws SQLException {
    ObservableList<Usuario> professores = FXCollections.observableArrayList();
    String sql = "SELECT * FROM usuario WHERE perfil_id = 2";
    PreparedStatement ps = connection.prepareStatement(sql);
    ResultSet rs = ps.executeQuery();
    while (rs.next()) {
      Usuario professor = new Usuario();
      professor.setId(rs.getInt("id"));
      professor.setEmail(rs.getString("email"));
      professor.setNome(rs.getString("nome"));
      professores.add(professor);
    }
    rs.close();
    ps.close();

    return professores;
  }

}

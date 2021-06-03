package Repository;

import Entity.Usuario;

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

}

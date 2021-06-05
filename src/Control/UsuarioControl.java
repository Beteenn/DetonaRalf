package Control;

import Entity.Usuario;
import Repository.IUsuarioDao;
import Repository.UsuarioDao;

import javax.swing.JOptionPane;
import java.sql.SQLException;

public class UsuarioControl {
  private IUsuarioDao _usuarioDao;

  {
    try {
      _usuarioDao = new UsuarioDao();
    } catch (ClassNotFoundException | SQLException e) {
      e.printStackTrace();
    }
  }

  public Usuario getUsuario() throws SQLException {
    Usuario usuario = new Usuario();
    usuario.setId(1);

    return _usuarioDao.getUsuario(usuario);
  }

  public Boolean insertUsuario(String nome, String email, String senha, String confirmarSenha) {
    if (!senha.equals(confirmarSenha))
      JOptionPane.showMessageDialog(null, "Senhas não conferem! Tente novamente",
              "Erro", JOptionPane.ERROR_MESSAGE);

    try {
      Usuario usuario = new Usuario();
      usuario.setNome(nome);
      usuario.setEmail(email);
      usuario.setPerfilId(1);
      usuario.setSenha(senha);
      _usuarioDao.insertUsuario(usuario);
      return true;
    } catch (Exception e) {
      System.out.print(e.getMessage());
    }

    return false;
  }

  public void updateUsuario() throws SQLException {
    Usuario usuario = new Usuario();
    usuario.setId(2);
    usuario.setNome("Cleyton Editado");
    usuario.setEmail("email@editado.com");
    usuario.setPerfilId(1);
    usuario.setSenha("1234");

    _usuarioDao.updateUsuario(usuario);
  }

  public void deleteUsuario() throws SQLException {
    Usuario usuario = new Usuario();
    usuario.setId(6);

    _usuarioDao.deleteUsuario(usuario);
  }
}

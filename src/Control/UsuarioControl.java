package Control;

import Entity.Usuario;
import Repository.IUsuarioDao;

import java.sql.SQLException;

public class UsuarioControl {
  private IUsuarioDao _usuarioDao;

  public UsuarioControl(IUsuarioDao usuarioDao) {
    _usuarioDao = usuarioDao;
  }

  public Usuario getUsuario() throws SQLException {
    Usuario usuario = new Usuario();
    usuario.setId(1);

    return _usuarioDao.getUsuario(usuario);
  }

  public void insertUsuario() throws SQLException {
    Usuario usuario = new Usuario();
    usuario.setNome("Cleyton");
    usuario.setEmail("email@email.com");
    usuario.setPerfilId(1);
    usuario.setSenha("1234");

    _usuarioDao.insertUsuario(usuario);
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

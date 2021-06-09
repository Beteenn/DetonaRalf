package Control;

import Entity.Usuario;
import Repository.IUsuarioDao;
import Repository.UsuarioDao;

import java.sql.SQLException;

public class AuthControl {
  private IUsuarioDao usuarioDao;

  {
    try {
      usuarioDao = new UsuarioDao();
    } catch (ClassNotFoundException | SQLException e) {
      e.printStackTrace();
    }
  }

  private static Usuario currentUser;

  public Integer login(String email, String senha) {
    try {
      currentUser = usuarioDao.getUsuarioByLogin(email, senha);
      System.out.println(currentUser.getPerfilId());
      return currentUser.getPerfilId();
    } catch (Exception e) {
      System.out.print(e.getMessage());
    }

    return null;
  }

  //TODO
  public void logout() {}

  // getter
  public Usuario getCurrentUser() { return currentUser; }
}




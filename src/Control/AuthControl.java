package Control;

import Entity.Usuario;
import Repository.IUsuarioDao;

public class AuthControl {
  private final IUsuarioDao usuarioDao;
  private static Usuario currentUser;

  public AuthControl(IUsuarioDao _usuarioDao) {
    usuarioDao = _usuarioDao;
  }

  public Integer login(String email, String senha) {
    try {
      currentUser = usuarioDao.getUsuarioByLogin(email, senha);
      return currentUser.getPerfilId();
    } catch (Exception e) {
      System.out.print(e.getMessage());
    }

    return null;
  }

  //TODO
  public void logout() {}

  // getter
  public static Usuario getCurrentUser() { return currentUser; }
}




package Control;

import Entity.Laboratorio;
import Entity.Usuario;
import Repository.IUsuarioDao;
import Repository.UsuarioDao;
import javafx.beans.property.*;
import javafx.collections.ObservableList;

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

  private ObservableList<Usuario> professores;

  private static IntegerProperty id = new SimpleIntegerProperty(0);
  private static IntegerProperty perfilId = new SimpleIntegerProperty(0);
  private static StringProperty email = new SimpleStringProperty("");
  private static StringProperty nome = new SimpleStringProperty("");
  private static StringProperty senha = new SimpleStringProperty("");
  private static StringProperty confirmarSenha = new SimpleStringProperty("");

  public Usuario getUsuario() {
    Usuario usuario = new Usuario();
    usuario.setId(1);

    try {
      usuario = _usuarioDao.getUsuario(usuario);
    } catch (SQLException e) {
      e.printStackTrace();
    }

    return usuario;
  }

  public Boolean insertUsuario() {
    if (!senha.get().equals(confirmarSenha.get())) {
      JOptionPane.showMessageDialog(null, "Senhas não conferem! Tente novamente", "Erro", JOptionPane.ERROR_MESSAGE);
      return false;
    }

    Usuario usuario = new Usuario();
    usuario.setNome(nome.get());
    usuario.setEmail(email.get());
    usuario.setSenha(senha.get());
    usuario.setPerfilId(2);

    try {
      _usuarioDao.insertUsuario(usuario);
      return true;
    } catch (Exception e) {
      System.out.print(e.getMessage());
    }

    return false;
  }

  public Boolean updateUsuario(String nome, String email) {
    if (nome.isEmpty() | email.isEmpty()) return false;
    try {
      Usuario usuario = getUsuarioProperty();
      usuario.setNome(nome);
      usuario.setEmail(email);

      _usuarioDao.updateUsuario(usuario);
      return true;
    } catch (SQLException throwables) {
      throwables.printStackTrace();
    }
    return false;
  }

  // public void updateUsuario() {
  // Usuario usuario = new Usuario();
  // usuario.setId(2);
  // usuario.setNome("Cleyton Editado");
  // usuario.setEmail("email@editado.com");
  // usuario.setPerfilId(1);
  // usuario.setSenha("1234");

  // try {
  // _usuarioDao.updateUsuario(usuario);
  // } catch (SQLException e) {
  // e.printStackTrace();
  // }
  // }

  public ObservableList<Usuario> listProfessores() {
    try {
      professores = _usuarioDao.listProfessores();
    } catch (SQLException e) {
      e.printStackTrace();
    }

    return professores;
  }

  public void deleteProfessor(Usuario usuario) {
    try {
      _usuarioDao.deleteUsuario(usuario);
    } catch (SQLException e) {
      e.printStackTrace();
    }
  }

  public void deleteUsuario() {
    Usuario usuario = new Usuario();
    usuario.setId(6);

    try {
      _usuarioDao.deleteUsuario(usuario);
    } catch (SQLException e) {
      e.printStackTrace();
    }
  }

  public Usuario getUsuarioProperty() {
    Usuario usuario = new Usuario();
    usuario.setId(id.get());
    usuario.setNome(nome.getName());
    usuario.setEmail(email.get());
    usuario.setSenha(senha.get());
    usuario.setPerfilId(perfilId.get());

    return usuario;
  }

  // region Getters
  public void setProfessor(Usuario professor) {
    if (professor != null) {
      id.set(professor.getId());
      perfilId.set(professor.getPerfilId());
      nome.set(professor.getNome());
      email.set(professor.getEmail());
      senha.set(professor.getSenha());
    }
  }

  public int getId() {
    return id.get();
  }

  public IntegerProperty idProperty() {
    return id;
  }

  public int getPerfilId() {
    return perfilId.get();
  }

  public IntegerProperty perfilIdProperty() {
    return perfilId;
  }

  public String getEmail() {
    return email.get();
  }

  public StringProperty emailProperty() {
    return email;
  }

  public String getNome() {
    return nome.get();
  }

  public StringProperty nomeProperty() {
    return nome;
  }

  public String getSenha() {
    return senha.get();
  }

  public StringProperty senhaProperty() {
    return senha;
  }

  public String getConfirmarSenha() {
    return confirmarSenha.get();
  }

  public StringProperty confirmarSenhaProperty() {
    return confirmarSenha;
  }
  // endregion

}

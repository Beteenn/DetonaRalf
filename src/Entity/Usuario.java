package Entity;

public class Usuario {

  private int id;
  private String nome;
  private String email;
  private String senha;
  private int perfilId;

  // region Getters and Setters
  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getNome() {
    return nome;
  }

  public void setNome(String nome) {
    this.nome = nome;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getSenha() {
    return senha;
  }

  public void setSenha(String senha) {
    this.senha = senha;
  }

  public int getPerfilId() {
    return perfilId;
  }

  public void setPerfilId(int perfilId) {
    this.perfilId = perfilId;
  }
  // endregion


}

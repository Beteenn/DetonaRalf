package Repository;

import Entity.Usuario;

import java.sql.SQLException;
import java.util.Optional;

public interface IUsuarioDao {

    void insertUsuario(Usuario usuario) throws SQLException;
    void updateUsuario(Usuario usuario) throws SQLException;
    void deleteUsuario(Usuario usuario) throws SQLException;
    Usuario getUsuario(Usuario usuario) throws SQLException;
    Usuario getUsuarioByLogin(String email, String senha) throws SQLException;

}

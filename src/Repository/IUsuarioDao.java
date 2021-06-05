package Repository;

import Entity.Usuario;
import javafx.collections.ObservableList;
import java.sql.SQLException;

public interface IUsuarioDao {

    void insertUsuario(Usuario usuario) throws SQLException;

    void updateUsuario(Usuario usuario) throws SQLException;

    void deleteUsuario(Usuario usuario) throws SQLException;

    Usuario getUsuario(Usuario usuario) throws SQLException;

    Usuario getUsuarioByLogin(String email, String senha) throws SQLException;

    ObservableList<Usuario> listProfessores() throws SQLException;

}

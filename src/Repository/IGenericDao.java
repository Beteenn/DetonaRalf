package Repository;

import java.sql.Connection;
import java.sql.SQLException;

public interface IGenericDao {

  Connection getConnection() throws ClassNotFoundException, SQLException;

}

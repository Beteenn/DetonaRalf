import Control.LaboratorioControl;
import Control.ReservaControl;
import Control.UsuarioControl;
import Repository.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class TesteConexaoBD {

  public static void main(String[] args) {

    try {
      ILabDao labDao = new LabDao();
      IReservaDao reservaDao = new ReservaDao();
      IUsuarioDao usuarioDao = new UsuarioDao();
      LaboratorioControl labControl = new LaboratorioControl(labDao);
      ReservaControl reservaControl = new ReservaControl(reservaDao);
      UsuarioControl usuarioControl = new UsuarioControl(usuarioDao);

//      usuarioControl.getUsuario();
//      usuarioControl.insertUsuario();
//      usuarioControl.updateUsuario();
//      usuarioControl.deleteUsuario();

      // reservaControl.insertReserva();
      // reservaControl.listreservas();
      // reservaControl.getReserva();
      // reservaControl.updateReserva();
      // reservaControl.deleteReserva();
      // reservaControl.listreservas();

      // labControl.insertLab();
      // labControl.updateLab();
      // labControl.listLabs();
      // labControl.deleteLab();
      // labControl.getLab();
      // labControl.listLabs();

      // Class.forName("com.mysql.cj.jdbc.Driver");
      // Connection connection = DriverManager.getConnection(
      // "jdbc:mysql://localhost:3306/DetonaRalf","root","123456");
      //
      // Statement stmt = connection.createStatement();
      // ResultSet rs = stmt.executeQuery("select * from laboratorio");
      // while(rs.next())
      // System.out.println(rs.getInt(1)+" "+rs.getString(2)+" "+rs.getString(3));
      // connection.close();

    } catch (Exception e) {
      System.out.println(e);
    }
  }
}

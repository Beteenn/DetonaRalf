import java.sql.Connection;
import java.sql.DriverManager;

public class TesteConexaoBD {

  public static void main(String[] args) {

    try{
      Class.forName("com.mysql.cj.jdbc.Driver");
      Connection con=DriverManager.getConnection(
              "jdbc:mysql://localhost:3306/DetonaRalf","root","admin");

    }catch(Exception e){ System.out.println(e);}
  }
}

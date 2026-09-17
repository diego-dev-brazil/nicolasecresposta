import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
public class DatabaseConnection {
   private static final String URL = "jdbc:sqlserver://localhost:1433;databaseName=EmpresaDB;encrypt=false;trustServerCertificate=true;";
   private static final String USER = "admin";
   private static final String PASSWORD = "Senha@123";

   public static Connection getConnection() throws SQLException {
       return DriverManager.getConnection(URL, USER, PASSWORD);
   }
}


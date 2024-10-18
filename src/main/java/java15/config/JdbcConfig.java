package java15.config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JdbcConfig {

     private  final static String url = "jdbc:postgresql://localhost:5432/java15";
     private  final static String user = "postgres";
     private  final static String password = "Urmat0204";


     public static Connection getConnection() {
         Connection connection = null;
         try {
             connection = DriverManager.getConnection(url,user,password);
//             System.out.println("success jdbc connection ! ");
         }catch (SQLException e) {
             System.out.println(e.getMessage());
         }
         return connection;
     }



}

package DAO;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {

    private static Connection connection = null;
    static final String DB_URL = "jdbc:sqlite:banco-prog2.sqlite3";
  
    
    static final String USER = "sa";
    static final String PASS = "sa";
    
   
    public static Connection conectar() {
        try {
            connection = DriverManager.getConnection(DB_URL, USER, PASS);
            System.out.println("Conexão realizada!");    
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return connection;
    }
    
    public static void descontecar(){
        if(connection != null){
            try {
                connection.close();
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }
        }
    }
    
    public static Connection getConnection(){
        if(connection == null)
            conectar();
        return connection;
    }
}
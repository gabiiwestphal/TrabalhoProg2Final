/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Model.Amigo;
import Model.Multa;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


public class MultaDAO {
    
     public static void createTable() {
        Connection connection = Conexao.getConnection();
        String criarTabela = "CREATE TABLE IF NOT EXISTS MULTA"
                + "(id INTEGER PRIMARY KEY AUTOINCREMENT,"
                + "valor INT NOT NULL,"
                + "amigo_id INT NOT NULL,"
                + "FOREIGN KEY (amigo_id) REFERENCES AMIGO (id))";

        
        Statement stmt = null;
        
        try {
            stmt = connection.createStatement();
            stmt.execute(criarTabela);
        } catch(SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    
    public static boolean salvarMulta(Multa mult, Amigo amigo, double taxa) {
        createTable();
        Connection connection = Conexao.getConnection();
        String sql = "INSERT INTO MULTA (valor, amigo_id) VALUES (?, ?)";
        PreparedStatement pstmt;
        
        try {
            pstmt = connection.prepareStatement(sql);
            pstmt.setDouble(1, taxa);
            pstmt.setInt(2, amigo.getId());
            
            pstmt.execute();
            
            System.out.println("Multa gravada com sucesso!");
            
            final ResultSet resultado = pstmt.getGeneratedKeys();
            
            if(resultado.next()) {
                int id = resultado.getInt(1);
                mult.setId(id);
            }
            return true;
        } catch(SQLException e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    public static List<Multa> recuperarTodasMultas() {
        createTable();
        List<Multa> multas = new ArrayList<>();
        Connection connection = Conexao.getConnection();
        String sql = "SELECT * FROM MULTA";
        Statement stmt;
        
        try {
            stmt = connection.createStatement();
            ResultSet resultado = stmt.executeQuery(sql);

            while (resultado.next()) {
                int id = resultado.getInt("id");
                int valor = resultado.getInt("valor");
                
                Multa m = null;
                                              
                m.setId(id);
                multas.add(m);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return null;
        }
        return multas;
    }
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Model.Caixa;
import Model.Revista;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class CaixaDAO {
    
    public static void createTable() {
        Connection connection = Conexao.getConnection();
        String criarTabela = "CREATE TABLE IF NOT EXISTS CAIXA"
                + "(id INTEGER PRIMARY KEY AUTOINCREMENT,"
                + "cor VARCHAR(255) NOT NULL,"
                + "qtdRevistas INTEGER NOT NULL,"
                + "etiqueta VARCHAR (255) NOT NULL)";
        
        Statement stmt = null;
        
        try {
            stmt = connection.createStatement();
            stmt.execute(criarTabela);
        } catch(SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    
    public static boolean salvarCaixa(Caixa c) {
        createTable();
        Connection connection = Conexao.getConnection();
        String sql = "INSERT INTO CAIXA (cor, qtdRevistas, etiqueta) VALUES (?, ?, ?)";
        PreparedStatement pstmt;
        
        try {
            pstmt = connection.prepareStatement(sql);
            pstmt.setString(1, c.getCor());
            pstmt.setInt(2, c.getQtdRevistas());
            pstmt.setString(3, c.getEtiqueta());
            
            pstmt.execute();
            
            System.out.println("Caixa gravada com sucesso!");
            
            final ResultSet resultado = pstmt.getGeneratedKeys();
            
            if(resultado.next()) {
                int id = resultado.getInt(1);
                c.setId(id);
            }
            return true;
        } catch(SQLException e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    public static boolean atualizarCaixa(Caixa c) {
        createTable();
        Connection connection = Conexao.getConnection();
        String sql = "UPDATE CAIXA SET cor=?, qtdRevistas=?, etiqueta=? WHERE ID=?";
        PreparedStatement pstmt;
        
        try {
            pstmt = connection.prepareStatement(sql);
            pstmt.setString(1, c.getCor());
            pstmt.setInt(2, c.getQtdRevistas());
            pstmt.setString(3, c.getEtiqueta());
            pstmt.setInt(4, c.getId());
            pstmt.execute();
            
            System.out.println("Caixa atualizada com sucesso!");
            return true;
        } catch(SQLException e) {
            System.out.println(e.getMessage());
            return false;
        }
    }
    
    public static boolean atualizarQtdRevistaCaixa(Caixa c, String texto) {
        createTable();
        Connection connection = Conexao.getConnection();
        String sql = "UPDATE CAIXA SET qtdRevistas=? WHERE ID=?";
        PreparedStatement pstmt;
        
        try {
            pstmt = connection.prepareStatement(sql);
            
            if(texto.equals("+")) {
                pstmt.setInt(1, c.getQtdRevistas() + 1);
            } else {
                pstmt.setInt(1, c.getQtdRevistas() - 1);
            }
            
            pstmt.setInt(2, c.getId());
            pstmt.execute();
            
            System.out.println("Caixa atualizada com sucesso!");
            return true;
        } catch(SQLException e) {
            System.out.println(e.getMessage());
            return false;
        }
    }
    
    public static List<Caixa> recuperarTodasCaixas() {
        createTable();
        List<Caixa> caixas = new ArrayList<>();
        Connection connection = Conexao.getConnection();
        String sql = "SELECT * FROM CAIXA";
        Statement stmt;
        
        try {
            stmt = connection.createStatement();
            ResultSet resultado = stmt.executeQuery(sql);

            while (resultado.next()) {
                int id = resultado.getInt("id");
                String cor = resultado.getString("cor");
                int qtdRevistas = resultado.getInt("qtdRevistas");
                String etiqueta = resultado.getString("etiqueta");
                
                Caixa c = new Caixa(cor, qtdRevistas, etiqueta);
                c.setId(id);
                caixas.add(c);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return null;
        } 
        return caixas;
    }

    public static Caixa recuperarCaixaRevista(Revista revista) {
        createTable();
        Caixa caixa = null;
        Connection connection = Conexao.getConnection();
        String sql = "SELECT * FROM CAIXA WHERE id=?";
        PreparedStatement  pstmt;
        
        try {
            pstmt = connection.prepareStatement(sql);
            pstmt.setInt(1, revista.getId());
            pstmt.execute();
            
            ResultSet resultado = pstmt.executeQuery();

            while (resultado.next()) {
                int id = resultado.getInt("id");
                
                String cor = resultado.getString("cor");
                int qtdRevistas = resultado.getInt("qtdRevistas");
                String etiqueta = resultado.getString("etiqueta");
                
                
                caixa = new Caixa(cor, qtdRevistas, etiqueta);
           
                caixa.setId(id);             
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return null;
        }
        
        return caixa;

    }
}

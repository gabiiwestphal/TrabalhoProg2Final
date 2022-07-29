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

public class RevistaDAO {
    
   public static void createTable() {
        Connection connection = Conexao.getConnection();
        String criarTabela = "CREATE TABLE IF NOT EXISTS REVISTA"
                + "(id INTEGER PRIMARY KEY AUTOINCREMENT,"
                + "nome VARCHAR(255) NOT NULL,"
                + "ano INTEGER(4) NOT NULL,"
                + "colecao VARCHAR(255) NOT NULL,"
                + "edicao VARCHAR(255) NOT NULL,"
                + "codigoDeBarras VARCHAR(255) NOT NULL,"
                + "categoria VARCHAR(255) NOT NULL,"
                + "caixa_id INTEGER,"
                + "FOREIGN KEY (caixa_id) REFERENCES CAIXA (id))";

        
        Statement stmt = null;
        
        try {
            stmt = connection.createStatement();
            stmt.execute(criarTabela);
        } catch(SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    
    public static boolean salvarRevista(Revista r) {
        createTable();
        Connection connection = Conexao.getConnection();
        String sql = "INSERT INTO REVISTA (nome, ano, colecao, edicao, codigoDeBarras, categoria) VALUES (?, ?, ?, ?,?,?)";
        PreparedStatement pstmt;
        
        try {
            pstmt = connection.prepareStatement(sql);
            pstmt.setString(1, r.getNome());
            pstmt.setInt(2, r.getAno());
            pstmt.setString(3, r.getColecao());
            pstmt.setString(4, r.getEdicao());
            pstmt.setString(5, r.getCodigoDeBarras());
            pstmt.setString(6, r.getCategoria());
            
            pstmt.execute();
            
            System.out.println("Revista gravada com sucesso!");
            
            final ResultSet resultado = pstmt.getGeneratedKeys();
            
            if(resultado.next()) {
                int id = resultado.getInt(1);
                r.setId(id);
            }
            return true;
        } catch(SQLException e) {
            System.out.println(e.getMessage());
            return false;
        }
    }
    
    public static Revista recuperarRevistaCaixa(String codigo) {
        createTable();
        Revista revista;
        Connection connection = Conexao.getConnection();
        String sql = "SELECT * FROM REVISTA WHERE codigoDeBarras =?";
        PreparedStatement pstmt;
        
        try {
            pstmt = connection.prepareStatement(sql);
            pstmt.setString(1, codigo);
            pstmt.execute();
            ResultSet resultado = pstmt.executeQuery();

            while (resultado.next()) {
                int id = resultado.getInt("id");
                String nome = resultado.getString("nome");
                int ano = resultado.getInt("ano");
                String colecao = resultado.getString("colecao");
                String edicao = resultado.getString("edicao");
                String codigoDeBarras = resultado.getString("codigoDeBarras");
                String categoria = resultado.getString("categoria");
                
                Caixa caixa = null;
                int caixa_id = resultado.getInt("caixa_id");
                
                for(Caixa c : CaixaDAO.recuperarTodasCaixas()) {
                    if(c.getId() == caixa_id) {
                        caixa = c;
                    }
                }
                
                revista = new Revista(nome, ano, colecao, edicao, codigoDeBarras, categoria, caixa);
                revista.setId(id);
                return revista;
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return null;
        }
        
        return null;
    }
    
    public static boolean colocarRevistaCaixa(Revista r, Caixa c) {
        createTable();
        Connection connection = Conexao.getConnection();
        String sql = "UPDATE REVISTA SET caixa_id=? WHERE ID=?";
        PreparedStatement pstmt;
        
        try {
            pstmt = connection.prepareStatement(sql);
            pstmt.setInt(1, c.getId());
            pstmt.setInt(2, r.getId());
            pstmt.execute();
            
            System.out.println("Revista atualizada com sucesso!");
            return true;
        } catch(SQLException e) {
            System.out.println(e.getMessage());
            return false;
        }
    }    
    
    public static boolean removerRevistaDaCaixa(Revista r) {
        createTable();
        Connection connection = Conexao.getConnection();
        String sql = "UPDATE REVISTA SET caixa_id=null WHERE ID=?";
        PreparedStatement pstmt;
        
        try {
            pstmt = connection.prepareStatement(sql);
            pstmt.setInt(1, r.getId());
            pstmt.execute();
            
            System.out.println("Revista atualizada com sucesso!");
            return true;
        } catch(SQLException e) {
            System.out.println(e.getMessage());
            return false;
        }
    }
    
    public static List<Revista> recuperarTodasRevistas() {
        createTable();
        List<Revista> revistas = new ArrayList<>();
        Connection connection = Conexao.getConnection();
        String sql = "SELECT * FROM REVISTA";
        Statement stmt;
        
        try {
            stmt = connection.createStatement();
            ResultSet resultado = stmt.executeQuery(sql);

            while (resultado.next()) {
                int id = resultado.getInt("id");
                String nome = resultado.getString("nome");
                int ano = Integer.parseInt(resultado.getString("ano"));
                String colecao = resultado.getString("colecao");
                String edicao = resultado.getString("edicao");
                String codigoDeBarras = resultado.getString("codigoDeBarras");
                String categoria = resultado.getString("categoria");
                
                Caixa c = null;

                for(Caixa caixa : CaixaDAO.recuperarTodasCaixas()) {
                    if(caixa.getId() == resultado.getInt("caixa_id")) {
                        c = caixa;
                    }
                }
                
                Revista r = new Revista(nome, ano, colecao, edicao, codigoDeBarras, categoria);
 
                r.setId(id);
                revistas.add(r);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return null;
        } 
        return revistas;
    }

    static Revista recuperarRevistaEmprestimo(int revista_id) {
        createTable();
        Revista revista  = null;
        Connection connection = Conexao.getConnection();
        String sql = "SELECT * FROM REVISTA WHERE id=?";
        PreparedStatement pstmt;
        
        try {
            pstmt = connection.prepareStatement(sql);
            pstmt.setInt(1, revista_id);
            pstmt.execute();
            ResultSet resultado = pstmt.executeQuery();

            while (resultado.next()) {
                int id = resultado.getInt("id");
                String nome = resultado.getString("nome");
                int ano = resultado.getInt("ano");
                String colecao = resultado.getString("colecao");
                String edicao = resultado.getString("edicao");
                String codigoDeBarras = resultado.getString("codigoDeBarras");
                String categoria = resultado.getString("categoria");
                
                revista = new Revista(nome, ano, colecao, edicao, codigoDeBarras, categoria);
           
                revista.setId(id);             
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return null;
        }
        
        return revista;
    }
}

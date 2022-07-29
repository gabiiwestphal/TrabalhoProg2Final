/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Model.Amigo;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class AmigoDAO {
    public static void createTable() {
        Connection connection = Conexao.getConnection();
        String criarTabela = "CREATE TABLE IF NOT EXISTS AMIGO"
                + "(id INTEGER PRIMARY KEY AUTOINCREMENT,"
                + "nome VARCHAR(255) NOT NULL,"
                + "cpf INTEGER(11) NOT NULL,"
                + "endereco VARCHAR(255) NOT NULL,"
                + "telefone VARCHAR(255) NOT NULL)";
        
        Statement stmt = null;
        
        try {
            stmt = connection.createStatement();
            stmt.execute(criarTabela);
        } catch(SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    
    public static boolean salvarAmigo(Amigo a) {
        createTable();
        Connection connection = Conexao.getConnection();
        String sql = "INSERT INTO AMIGO (nome, cpf, endereco, telefone) VALUES (?, ?, ?, ?)";
        PreparedStatement pstmt;
        
        try {
            pstmt = connection.prepareStatement(sql);
            pstmt.setString(1, a.getNome());
            pstmt.setString(2, a.getCpf());
            pstmt.setString(3, a.getEndereco());
            pstmt.setString(4, a.getTelefone());
            
            pstmt.execute();
            
            System.out.println("Amigo gravado com sucesso!");
            
            final ResultSet resultado = pstmt.getGeneratedKeys();
            
            if(resultado.next()) {
                int id = resultado.getInt(1);
                a.setId(id);
            }
            return true;
        } catch(SQLException e) {
            System.out.println(e.getMessage());
            return false;
        }
    }
    
    public static boolean atualizarAmigo(Amigo a) {
        createTable();
        Connection connection = Conexao.getConnection();
        String sql = "UPDATE AMIGO SET nome=?, cpf=?, endereco=?, telefone=? WHERE ID=?";
        PreparedStatement pstmt;
        
        try {
            pstmt = connection.prepareStatement(sql);
            pstmt.setString(1, a.getNome());
            pstmt.setString(2, a.getCpf());
            pstmt.setString(3, a.getEndereco());
            pstmt.setString(4, a.getTelefone());
            pstmt.setInt(5, a.getId());
            pstmt.execute();
            
            System.out.println("Amigo atualizado com sucesso!");
            return true;
        } catch(SQLException e) {
            System.out.println(e.getMessage());
            return false;
        }
    }
    
    public static List<Amigo> recuperarTodosAmigos() {
        createTable();
        List<Amigo> amigos = new ArrayList<>();
        Connection connection = Conexao.getConnection();
        String sql = "SELECT * FROM AMIGO";
        Statement stmt;
        
        try {
            stmt = connection.createStatement();
            ResultSet resultado = stmt.executeQuery(sql);

            while (resultado.next()) {
                int id = resultado.getInt("id");
                String nome = resultado.getString("nome");
                String cpf = resultado.getString("cpf");
                String endereco = resultado.getString("endereco");
                String telefone = resultado.getString("telefone");
                
                Amigo a = new Amigo(nome, cpf, endereco, telefone);
                a.setId(id);
                amigos.add(a);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return null;
        } 
        return amigos;
    }

    static Amigo recuperarAmigoEmprestimo(int amigo_id) {
        createTable();
        Amigo amigo = null;
        Connection connection = Conexao.getConnection();
        String sql = "SELECT * FROM AMIGO WHERE id=?";
        PreparedStatement pstmt;
        
        try {
            pstmt = connection.prepareStatement(sql);
            pstmt.setInt(1, amigo_id);
            pstmt.execute();
            ResultSet resultado = pstmt.executeQuery();

            while (resultado.next()) {
                int id = resultado.getInt("id");
                String nome = resultado.getString("nome");
                String cpf = resultado.getString("cpf");
                String endereco = resultado.getString("endereco");
                String telefone = resultado.getString("telefone");
                
                amigo = new Amigo(nome, cpf, endereco, telefone);
           
                amigo.setId(id);             
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return null;
        }
        
        return amigo;
    }
       
}

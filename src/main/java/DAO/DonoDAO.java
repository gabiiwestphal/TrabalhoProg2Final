/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Model.Dono;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class DonoDAO {
    
       public static void createTable() {
        Connection connection = Conexao.getConnection();
        String criarTabela = "CREATE TABLE IF NOT EXISTS DONO"
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
    
    public static boolean salvarDono(Dono d) {
        createTable();
        Connection connection = Conexao.getConnection();
        String sql = "INSERT INTO DONO (nome, cpf, endereco, telefone) VALUES (?, ?, ?, ?)";
        PreparedStatement pstmt;
        
        try {
            pstmt = connection.prepareStatement(sql);
            pstmt.setString(1, d.getNome());
            pstmt.setString(2, d.getCpf());
            pstmt.setString(3, d.getEndereco());
            pstmt.setString(4, d.getTelefone());
            
            pstmt.execute();
            
            System.out.println("Dono gravado com sucesso!");
            
            final ResultSet resultado = pstmt.getGeneratedKeys();
            
            if(resultado.next()) {
                int id = resultado.getInt(1);
                d.setId(id);
            }
            return true;
        } catch(SQLException e) {
            System.out.println(e.getMessage());
            return false;
        }
    }
    
    public static boolean atualizarDono(Dono d) {
        createTable();
        Connection connection = Conexao.getConnection();
        String sql = "UPDATE DONO SET nome=?, cpf=?, endereco=?, telefone=? WHERE ID=?";
        PreparedStatement pstmt;
        
        try {
            pstmt = connection.prepareStatement(sql);
            pstmt.setString(1, d.getNome());
            pstmt.setString(2, d.getCpf());
            pstmt.setString(3, d.getEndereco());
            pstmt.setString(4, d.getTelefone());
            pstmt.setInt(5, d.getId());
            pstmt.execute();
            
            System.out.println("Dono atualizado com sucesso!");
            return true;
        } catch(SQLException e) {
            System.out.println(e.getMessage());
            return false;
        }
    }
    
    public static List<Dono> recuperarTodosDonos() {
        createTable();
        List<Dono> donos = new ArrayList<>();
        Connection connection = Conexao.getConnection();
        String sql = "SELECT * FROM DONO";
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
                
                Dono d = new Dono(nome, cpf, endereco, telefone);
                d.setId(id);
                donos.add(d);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return null;
        } 
        return donos;
    }

    static Dono recuperarDonoEmprestimo(int dono_id) {
        createTable();
        Dono dono = null;
        Connection connection = Conexao.getConnection();
        String sql = "SELECT * FROM DONO WHERE id=?";
        PreparedStatement pstmt;
        
        try {
            pstmt = connection.prepareStatement(sql);
            pstmt.setInt(1, dono_id);
            pstmt.execute();
            ResultSet resultado = pstmt.executeQuery();

            while (resultado.next()) {
                int id = resultado.getInt("id");
                String nome = resultado.getString("nome");
                String cpf = resultado.getString("cpf");
                String endereco = resultado.getString("endereco");
                String telefone = resultado.getString("telefone");
                
                dono = new Dono(nome, cpf, endereco, telefone);
           
                dono.setId(id);             
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return null;
        }
        
        return dono;
    }
       
}

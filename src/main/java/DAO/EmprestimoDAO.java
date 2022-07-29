/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Exception.CampoVazioException;
import Exception.CodigoDeBarraExistenteException;
import Model.Amigo;
import Model.Dono;
import Model.Emprestimo;
import Model.Multa;
import Model.Revista;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class EmprestimoDAO {
    
    public static void createTable() {
        Connection connection = Conexao.getConnection();
        String criarTabela = "CREATE TABLE IF NOT EXISTS EMPRESTIMO"
                + "(id INTEGER PRIMARY KEY AUTOINCREMENT,"
                + "dataEmprestimo VARCHAR(255) NOT NULL,"
                + "dono_id INTEGER,"
                + "amigo_id INTEGER,"
                + "revista_id INTEGER,"
                + "multa_id INTEGER,"
                + "FOREIGN KEY (dono_id) REFERENCES DONO (id),"
                + "FOREIGN KEY (amigo_id) REFERENCES AMIGO (id),"
                + "FOREIGN KEY (revista_id) REFERENCES REVISTA (id),"
                + "FOREIGN KEY (multa_id) REFERENCES MULTA (id))";
        
        Statement stmt = null;
        
        try {
            stmt = connection.createStatement();
            stmt.execute(criarTabela);
        } catch(SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    
    public static boolean salvarEmprestimo(Emprestimo emprestimo) {
        createTable();
        Connection connection = Conexao.getConnection();
        String sql = "INSERT INTO EMPRESTIMO (dataEmprestimo, dono_id, amigo_id, revista_id) VALUES (?, ?, ?, ?)";
        PreparedStatement pstmt;
        
        try {
            pstmt = connection.prepareStatement(sql);
            pstmt.setString(1, String.valueOf(emprestimo.getDataEmprestimo()));          
            pstmt.setInt(2, emprestimo.getDono().getId());
            pstmt.setInt(3, emprestimo.getAmigo().getId());
            pstmt.setInt(4, emprestimo.getRevista().getId());
            
            pstmt.execute();
            
            System.out.println("Emprestimo gravado com sucesso!");
            
            final ResultSet resultado = pstmt.getGeneratedKeys();
            
            if(resultado.next()) {
                int id = resultado.getInt(1);
                emprestimo.setId(id);
            }
            return true;
        } catch(SQLException e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    public static List<Emprestimo> recuperarTodosEmprestimos() throws CampoVazioException, CodigoDeBarraExistenteException {
        createTable();
        List<Emprestimo> emprestimos = new ArrayList<>();
        Connection connection = Conexao.getConnection();
        String sql = "SELECT * FROM EMPRESTIMO";
        Statement stmt;
        
        try {
            stmt = connection.createStatement();
            ResultSet resultado = stmt.executeQuery(sql);

            while (resultado.next()) {
                int id = resultado.getInt("id");
                LocalDate dataEmprestimo = LocalDate.parse(resultado.getString("dataHora"));
                
                Dono d = null;
                Amigo a = null;
                Revista r = null;
                Multa m = null;
                
                for(Dono dono : DonoDAO.recuperarTodosDonos()) {
                    if(dono.getId() == resultado.getInt("dono_id")) {
                        d = dono;
                    }
                }
                
                for(Amigo amigo : AmigoDAO.recuperarTodosAmigos()) {
                    if(amigo.getId() == resultado.getInt("amigo_id")) {
                        a = amigo;
                    }
                }
                
                for(Revista revista : RevistaDAO.recuperarTodasRevistas()) {
                    if(revista.getId() == resultado.getInt("revista_id")) {
                        r = revista;
                    }
                }
                
                 for(Multa multa : MultaDAO.recuperarTodasMultas()) {
                    if(multa.getId() == resultado.getInt("multa_id")) {
                        m = multa;
                    }
                }
                
                Emprestimo emprestimo = new Emprestimo();
                emprestimo.setDataHora(dataEmprestimo);
                emprestimo.setDono(d);
                emprestimo.setAmigo(a);
                emprestimo.setRevista(r);
                emprestimo.setMulta(m);
                emprestimo.setId(id);
                emprestimos.add(emprestimo);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return null;
        }
        return emprestimos;
    }
    
    public static Emprestimo recuperarEmprestimoAmigo(Revista revista) {
        createTable();
        Emprestimo emprestimo = null;
        Connection connection = Conexao.getConnection();
        String sql = "SELECT * FROM EMPRESTIMO WHERE revista_id=?";
        PreparedStatement pstmt;
        
        try {
            pstmt = connection.prepareStatement(sql);
            pstmt.setInt(1, revista.getId());
            pstmt.execute();
            ResultSet resultado = pstmt.executeQuery();

            while (resultado.next()) {
                int id = resultado.getInt("id");
                
                int dono_id = resultado.getInt("dono_id");
                int amigo_id = resultado.getInt("amigo_id");
                int revista_id = resultado.getInt("revista_id");
                
                LocalDate dataEmprestimo = LocalDate.parse(resultado.getString("dataEmprestimo"));
                Dono dono = DonoDAO.recuperarDonoEmprestimo(dono_id);
                Amigo a = AmigoDAO.recuperarAmigoEmprestimo(amigo_id);
                Revista r = RevistaDAO.recuperarRevistaEmprestimo(revista_id);
                
                emprestimo = new Emprestimo(dataEmprestimo, dono, a, r);
           
                emprestimo.setId(id);             
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return null;
        }
        
        return emprestimo;
    }

    public static boolean removerEmprestimo(Emprestimo emp) {
        createTable();
        Connection connection = Conexao.getConnection();
        String sql = "DELETE FROM EMPRESTIMO WHERE ID = ?";
        PreparedStatement pstmt;
        
        try {
            pstmt = connection.prepareStatement(sql);
            pstmt.setInt(1, emp.getId());
            pstmt.execute();
            System.out.println("Empréstimo removido com sucesso!");
            return true;
        } catch(SQLException e) {
            System.out.println(e.getMessage());
            return false;
        }
    }
}

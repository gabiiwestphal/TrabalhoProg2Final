/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import DAO.AmigoDAO;
import DAO.DonoDAO;
import Exception.CampoVazioException;
import Exception.CpfExistenteException;
import java.util.ArrayList;
import java.util.List;

public abstract class Pessoa 
{
    protected String nome;
    protected String cpf;
    protected String endereco;
    protected String telefone;
    protected int id;
  
    static protected List<Emprestimo> emprestimos = new ArrayList<>();

    public Pessoa() {
    }

    public Pessoa(String nome, String cpf, String endereco, String telefone) {
        this.nome = nome;
        this.cpf = cpf;
        this.endereco = endereco;
        this.telefone = telefone;
    }
    

  
    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) throws CampoVazioException, CpfExistenteException {
        if(cpf.isBlank()){
            throw new CampoVazioException();
            
        }
        
        List<Amigo> amigos = AmigoDAO.recuperarTodosAmigos();
        
        List<Dono> donos = DonoDAO.recuperarTodosDonos();

         for(Amigo amg : amigos) {
            if(amg.getCpf().equals(cpf)) {
                throw new CpfExistenteException();
            }
        }
         
        for(Dono don : donos) {
            if(don.getCpf().equals(cpf)) {
                throw new CpfExistenteException();
            }
        }
                              
        this.cpf = cpf;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
   
    
    public void addEmprestimo(Emprestimo emprestimo) {
        this.emprestimos.add(emprestimo);
    }

    public void removeEmprestimo(Emprestimo emprestimo) {
        this.emprestimos.remove(emprestimo);
    }

    public List<Emprestimo> getEmprestimos() {
        return emprestimos;
    }
 
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) throws CampoVazioException {
       if(nome.isBlank()){
           throw new CampoVazioException();
       }
        this.nome = nome;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) throws CampoVazioException{
        if(endereco.isBlank()){
            throw new CampoVazioException();
        }
        this.endereco = endereco;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) throws CampoVazioException{
        if (telefone.isBlank()){
            throw new CampoVazioException();
        }
        this.telefone = telefone;
    }

    @Override
    public String toString() {
        return "ID: " + id + "nome:" + nome + ", cpf: " + cpf + 
                ", endereco:" + endereco + ", telefone:" + telefone;
    }    
}


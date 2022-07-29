/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import DAO.CaixaDAO;

public class Amigo extends Pessoa {
    
    public Amigo() {
        super();
    }
    
    public Amigo(String nome, String cpf, String endereco, String telefone) {
        super(nome, cpf, endereco, telefone);
    }
    
    public void devolverRevista(Revista r) {
        for(Emprestimo e : this.getEmprestimos()) {
            if(e.getRevista().getCodigoDeBarras().equals(r.getCodigoDeBarras())) {
                this.getEmprestimos().remove(e);               
            }
        }
        
        CaixaDAO caixaDAO = new CaixaDAO();
        for(Caixa c : caixaDAO.recuperarTodasCaixas()){
            if(r.getCaixa().getEtiqueta().equals(c.getEtiqueta())){
                c.addRevista(r);
                c.addRevistaContador();
            }
        }
    }
    
    @Override
    public String toString() {
        return "Tipo: Amigo " + super.toString();
    }
}

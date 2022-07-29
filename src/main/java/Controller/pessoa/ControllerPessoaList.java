/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller.pessoa;

import DAO.AmigoDAO;
import DAO.DonoDAO;
import Model.Amigo;
import Model.Dono;
import Model.Pessoa;
import View.Pessoa.PessoaListView;
import java.util.ArrayList;
import java.util.List;


public class ControllerPessoaList {
    
    private PessoaListView plv;

    public ControllerPessoaList(PessoaListView plv) {
        this.plv = plv;
        exibirTela();
        listarPessoas();
    }
    
     private void listarPessoas() {
         List<Pessoa> pessoas = new ArrayList<>();
        
        String texto = "";
        
        for(Amigo amg : AmigoDAO.recuperarTodosAmigos()) {
           pessoas.add(amg);
        }
        
        for(Dono don : DonoDAO.recuperarTodosDonos()) {
            pessoas.add(don);
        }
        
        for(Pessoa p : pessoas) {
            texto += p.toString() + "\n";
        }
        
        plv.exibirListagem(texto);
    }
     
     public void exibirTela() {
        plv.exibir();
    }

    
}

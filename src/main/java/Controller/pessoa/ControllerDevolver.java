/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller.pessoa;

import DAO.AmigoDAO;
import DAO.EmprestimoDAO;
import DAO.MultaDAO;
import DAO.RevistaDAO;
import Model.Amigo;
import Model.Emprestimo;
import Model.Multa;
import Model.Revista;
import View.Pessoa.DevolverView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;

public class ControllerDevolver {
    
     private DevolverView dv;

    public ControllerDevolver(DevolverView dv) {
        this.dv = dv;
        popularComboBox();
        inicializarAcaoBotao();
        exibirTela();
    }

    private void inicializarAcaoBotao() {
        dv.adicionarAcaoBotaoCadastrar(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                    Revista revista  = dv.getRevista();
                    Emprestimo emprestimo = EmprestimoDAO.recuperarEmprestimoAmigo(revista);              
                    
                    Amigo amigo = dv.getAmigo();
                    
                    if(verificarDataDevolucao(emprestimo)) {
                        devolverRevista(emprestimo);
                        dv.exibirMensagem("Devolução realizada com sucesso!");
                    } else {
                        Multa multa = new Multa(amigo, 1);
                        double taxa = multa.calcularTaxa(subtrairDatas(emprestimo)); 
                        MultaDAO.salvarMulta(multa, amigo, taxa);
                        dv.exibirMensagem("Devolução realizada com sucesso! Multa pendente: " + Math.abs(multa.calcularTaxa(subtrairDatas(emprestimo))));
                    }
            }
        });
    }
    
    private void devolverRevista(Emprestimo e) {       
        EmprestimoDAO.removerEmprestimo(e);
    }
    
    private boolean verificarDataDevolucao(Emprestimo e) {
        LocalDate diaAtual = LocalDate.now();

        return diaAtual.isBefore(e.getDataEntrega());
    }
    
     private long subtrairDatas(Emprestimo e) {
        LocalDate diaAtual = LocalDate.now();

        Period period = Period.between(diaAtual, e.getDataEntrega());

        return period.getDays();
    }

  
    private void popularComboBox() {

        List<Amigo> amigos = new ArrayList<>();
        List<Revista> revistas = new ArrayList<>();

        for (Amigo a : AmigoDAO.recuperarTodosAmigos()) {
            amigos.add(a);
        }

        for(Revista r : RevistaDAO.recuperarTodasRevistas()) {
           revistas.add(r);
            }           

        dv.popularComboBoxAmigo(amigos);
        dv.popularComboBoxRevista(revistas);
    }

    public void exibirTela() {
        dv.exibir();
    }
}


/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller.revistas;

import DAO.RevistaDAO;
import Exception.CampoVazioException;
import Exception.CodigoDeBarraExistenteException;
import Model.Caixa;
import Model.Revista;
import View.revista.RevistaCreateView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ControllerRevistaCreate {
  
    private Revista revista;
    private RevistaCreateView rcv;

    public ControllerRevistaCreate(RevistaCreateView rcv) {
        this.rcv = rcv;
        inicializarAcaoBotao();
        exibirTela();
    }

    private void inicializarAcaoBotao() {
        rcv.adicionarAcaoBotaoCadastrar(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nome = rcv.getNome();
                int ano = Integer.parseInt(rcv.getAno());
                String colecao = rcv.getColecao();
                String edicao = rcv.getEdicao();
                String codigoDeBarras = rcv.getCodigoDeBarras();
                String categoria = rcv.getCategoria();

                try {
                    revista = new Revista();
                    
                    revista.setNome(nome);
                    revista.setAno(ano);
                    revista.setColecao(colecao);
                    revista.setEdicao(edicao);
                    try {
                        revista.setCodigoDeBarra(codigoDeBarras);
                    } catch (CodigoDeBarraExistenteException ex) {
                        System.out.println(ex.getMessage());
                    }
                    revista.setCategoria(categoria);
                    addRevista(revista);
                    rcv.exibirMensagem("Revista cadastrada com sucesso!");
                    rcv.limparTela();
                } catch (CampoVazioException ex) {
                    rcv.exibirMensagem(ex.getMessage());
                }
                
            }
        });
    }

    private void addRevista(Revista r) {
        RevistaDAO.salvarRevista(r);
    }
    
    public void exibirTela() {
        rcv.exibir();
    }

}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller.caixa;

import DAO.CaixaDAO;
import DAO.RevistaDAO;
import Exception.CampoVazioException;
import Model.Caixa;
import Model.Revista;
import View.caixa.CaixaCreateView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ControllerCaixaCreate {
    
     private Caixa caixa;
    private CaixaCreateView ccv;

    public ControllerCaixaCreate(CaixaCreateView ccv) {
        this.ccv = ccv;
        inicializarAcaoBotao();
        exibirTela();
    }

    private void inicializarAcaoBotao() {
        ccv.adicionarAcaoBotaoCadastrar(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String cor = ccv.getCor();
               // int qtdRevistas = ccv.getQtdRevistas();
                String etiqueta = ccv.getEtiqueta();

                try {
                    caixa = new Caixa();
                    
                    caixa.setCor(cor);
                    caixa.setEtiqueta(etiqueta);
                    caixa.setEtiqueta(etiqueta);
                    addCaixa(caixa);
                    ccv.exibirMensagem("Caixa cadastrada com sucesso!");
                    ccv.limparTela();
                } catch (CampoVazioException ex) {
                    ccv.exibirMensagem(ex.getMessage());
                }
            }
        });
    }

    private void addCaixa(Caixa c) {
        CaixaDAO.salvarCaixa(c);
    }
    
    public void exibirTela() {
        ccv.exibir();
    }
}

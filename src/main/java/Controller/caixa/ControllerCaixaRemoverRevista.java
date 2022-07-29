/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller.caixa;

import DAO.CaixaDAO;
import DAO.RevistaDAO;
import Model.Caixa;
import Model.Revista;
import View.caixa.CaixaRemoverRevistaView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ControllerCaixaRemoverRevista {
    
    private CaixaRemoverRevistaView vcrv;
    
    public ControllerCaixaRemoverRevista(CaixaRemoverRevistaView vcrv) {
        this.vcrv = vcrv;
        popularComboBox();
        inicializarAcaoBotao();
        exibirTela();
    }
    
    private void inicializarAcaoBotao() {
        vcrv.adicionarAcaoBotaoRemover(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Caixa tempCaixa = vcrv.getCaixa();
                Revista tempRevista = vcrv.getRevista();
                
                //DAO revista - removerRevistaDaCaixa
                RevistaDAO.removerRevistaDaCaixa(tempRevista);
                //caixa - diminuir qtdRevista
                CaixaDAO.atualizarQtdRevistaCaixa(tempCaixa, "-");
                
                vcrv.exibirMensagem("Revista removida com sucesso!");
                
                limparComboBox();
                popularComboBox();
            }
        });
    }
    
    private void limparComboBox() {
        vcrv.limparComboBox();
    }
    
    private void popularComboBox() {
        vcrv.popularCbCaixa(CaixaDAO.recuperarTodasCaixas());
        vcrv.popularCbRevista(RevistaDAO.recuperarTodasRevistas());
    }
    
    public void exibirTela() {
        vcrv.exibir();
    }
}

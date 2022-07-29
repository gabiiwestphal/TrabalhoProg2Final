/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller.caixa;

import DAO.CaixaDAO;
import DAO.RevistaDAO;
import Model.Caixa;
import Model.Revista;
import View.caixa.BuscarRevistaView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ControllerBuscarRevista {
    
    private BuscarRevistaView brv;
    
    public ControllerBuscarRevista(BuscarRevistaView brv) {
        this.brv = brv;
        popularCbCaixa();
        inicializarAcaoBotao();
        exibirTela();       
    }
    
    public void inicializarAcaoBotao() {
        brv.adicionarAcaoBotaoBuscar(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Caixa caixa = brv.getCaixa();
                String codigoBarras = brv.getCodigoBarras();
                
                Revista r = RevistaDAO.recuperarRevistaCaixa(codigoBarras);
                
                if(r != null && r.getCaixa().getId() == caixa.getId()) {
                    brv.mostrarRevistaDaCaixa(r.toString() + "\n");
                } else {
                    brv.mostrarRevistaDaCaixa("Não existe essa revista na caixa. \n");
                }
            }
        });
    }
    
    private void popularCbCaixa() {
        brv.preencherCB(CaixaDAO.recuperarTodasCaixas());
    }
    
    public void exibirTela() {
        brv.exibir();
    }
}

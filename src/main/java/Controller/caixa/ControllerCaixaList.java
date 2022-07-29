/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller.caixa;

import DAO.CaixaDAO;
import Model.tabela.CaixaTableModel;
import View.caixa.CaixaListView;

public class ControllerCaixaList {
    
    private CaixaListView clv;
    private CaixaTableModel rtm;
    
    public ControllerCaixaList(CaixaListView clv, CaixaTableModel rtm) {
        this.clv = clv;
        this.rtm = rtm;
        setTableModel();
        inicializarTelaListarDados();
    }
    
    private void setTableModel(){
        clv.setTableModel(this.rtm);
    }
    
    public void exibir(){
        clv.exibirTela();
    }
    
    public void atualizarDados(){
        rtm.fireTableDataChanged();
    }
    
   private void inicializarTelaListarDados() {
        rtm = new CaixaTableModel(CaixaDAO.recuperarTodasCaixas());
    }
}

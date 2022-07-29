/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller.revistas;

import DAO.RevistaDAO;
import Model.tabela.RevistaTableModel;
import View.revista.RevistaListView;


public class ControllerRevistaList {
    
    private RevistaListView rlv;
    private RevistaTableModel rtm;
    
    public ControllerRevistaList(RevistaListView rlv, RevistaTableModel rtm) {
        this.rlv = rlv;
        this.rtm = rtm;
        setTableModel();
        inicializarTelaListarDados();
    }
    
    private void setTableModel(){
        rlv.setTableModel(this.rtm);
    }
    
    public void exibir(){
        rlv.exibirTela();
    }
    
    public void atualizarDados(){
        rtm.fireTableDataChanged();
    }
    
    private void inicializarTelaListarDados()  {
        rtm = new RevistaTableModel(RevistaDAO.recuperarTodasRevistas());
    }
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model.tabela;

import Exception.CampoVazioException;
import Model.Caixa;
import java.util.List;
import javax.swing.table.AbstractTableModel;

public class CaixaTableModel extends AbstractTableModel {
    
     private List<Caixa> caixas;
    
    private final String[] nomeColunas = {"Cor", "Quantidade de revistas", "Etiqueta"};
    private final int COLUNA_COR = 0;
    private final int COLUNA_QTDREVISTAS = 1;
    private final int COLUNA_ETIQUETA = 2;
;
    
    public CaixaTableModel(List<Caixa> caixas) {
        this.caixas = caixas;
    }
    
    @Override
    public int getRowCount() {
        return caixas.size();
    }

    @Override
    public int getColumnCount() {
        return nomeColunas.length;
    }

    @Override
    public String getColumnName(int column) {
        return nomeColunas[column];
    }
    
    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Caixa caix = this.caixas.get(rowIndex);
        String valor = null;
        switch(columnIndex){
            case COLUNA_COR:
                valor = caix.getCor();
                break;
            case COLUNA_QTDREVISTAS:
                valor = String.valueOf(caix.getQtdRevistas());
                break;
            case COLUNA_ETIQUETA:
                valor = caix.getEtiqueta();
                break;           
        }
        return valor;
    }
    
    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return false;
    }
    
    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
    	Caixa caix = this.caixas.get(rowIndex);
        
        try {
            switch (columnIndex) {
            case COLUNA_COR:
                caix.setCor((String) aValue);
                break;
            case COLUNA_QTDREVISTAS:
                 caix.getQtdRevistas();
                break;
            case COLUNA_ETIQUETA:
                caix.setEtiqueta((String) aValue);
                break;             
            }  
        } catch(CampoVazioException e) {
            System.out.println(e.getMessage());        
        fireTableDataChanged();
    }
}
}


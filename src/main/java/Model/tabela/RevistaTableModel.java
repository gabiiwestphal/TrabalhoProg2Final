/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model.tabela;

import Exception.CampoVazioException;
import Exception.CodigoDeBarraExistenteException;
import Model.Caixa;
import Model.Revista;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.AbstractTableModel;

public class RevistaTableModel extends AbstractTableModel {
    
    private List<Revista> revistas;
    
    private final String[] nomeColunas = {"Nome", "Ano", "Coleção", "Edição", "Código de barras", "Caixa"};
    private final int COLUNA_NOME = 0;
    private final int COLUNA_ANO = 1;
    private final int COLUNA_COLECAO = 2;
    private final int COLUNA_EDICAO = 3;
    private final int COLUNA_CODIGODEBARRA = 4;
    private final int COLUNA_CAIXA = 5;
    
    public RevistaTableModel(List<Revista> revistas) {
        this.revistas = revistas;
    }
    
    @Override
    public int getRowCount() {
        return revistas.size();
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
        Revista rev = this.revistas.get(rowIndex);
        String valor = null;
        switch(columnIndex){
            case COLUNA_NOME:
                valor = rev.getNome();
                break;
            case COLUNA_ANO:
                valor = String.valueOf(rev.getAno());
                break;
            case COLUNA_COLECAO:
                valor = rev.getColecao();
                break;
            case COLUNA_EDICAO:
                valor = String.valueOf(rev.getEdicao());
                break;
            case COLUNA_CODIGODEBARRA:
                valor = rev.getCodigoDeBarras();
                break;               
           case COLUNA_CAIXA:
                valor = String.valueOf(rev.getCaixa());
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
    	Revista rev = this.revistas.get(rowIndex);
        
        try {
            switch (columnIndex) {
            case COLUNA_NOME:
                rev.setNome((String) aValue);
                break;
            case COLUNA_ANO:
                 rev.setAno(Integer.parseInt((String) aValue));
                break;
            case COLUNA_COLECAO:
                rev.setColecao((String) aValue);
                break; 
            case COLUNA_EDICAO:
                rev.setEdicao((String) aValue);
                break;
            case COLUNA_CODIGODEBARRA:
                rev.setCodigoDeBarra((String) aValue);
                break;               
           case COLUNA_CAIXA:
                rev.setCaixa((Caixa) aValue);
                break;
            }  
        } catch(CampoVazioException e) {
            System.out.println(e.getMessage()); 
        } catch (CodigoDeBarraExistenteException ex) {
            Logger.getLogger(RevistaTableModel.class.getName()).log(Level.SEVERE, null, ex);
        }
        fireTableDataChanged();
    }
    
}

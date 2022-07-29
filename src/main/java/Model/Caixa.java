/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import Exception.CampoVazioException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Caixa implements Comparable<Caixa> {
    private int id;
    private String cor;
    private int qtdRevistas;
    private String etiqueta;

    private Set<Revista> revistas;
    private Map<String, Revista> obterRevistasPorCodigo;

    public Caixa() {
    }

    
    public Caixa(String cor, int qtdRevistas, String etiqueta) {
        this.obterRevistasPorCodigo = new HashMap<>();
        this.revistas = new HashSet<>();
        this.cor = cor;
        this.etiqueta = etiqueta;
        this.qtdRevistas = qtdRevistas;
    }
    
    public void addRevista(Revista revista) {
        this.revistas.add(revista);
    }
    
    public void removeRevista(Revista revista) {
        this.revistas.remove(revista);
    }
    
    public void addRevistaMap(Revista revista) {
        this.obterRevistasPorCodigo.put(revista.getCodigoDeBarras(), revista);
    }
    
    public Revista buscarRevistaPorCodigo(String codigo) {
        return this.obterRevistasPorCodigo.get(codigo);
    }

    public int getQtdRevistas() {
        return this.qtdRevistas;
    }
    
    public void addRevistaContador() {
        this.qtdRevistas++;
    }
    
    public void reduzirRevistaContador() {
        this.qtdRevistas--;
    }
    
    public Set<Revista> getRevistas() {
        return revistas;
    }   
    
    public String getCor() {
        return cor;
    }

    public void setCor(String cor) throws CampoVazioException{
        if(cor.isBlank()){
            throw new CampoVazioException();
        }
            
        this.cor = cor;
    }

    public String getEtiqueta() {
        return etiqueta;
    }

    public void setEtiqueta(String etiqueta) throws CampoVazioException{
       if(etiqueta.isBlank()){
           throw new CampoVazioException();
                   
       }
        this.etiqueta = etiqueta;
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Cor: " + cor + ", Etiqueta: " + etiqueta + ", Quantidade de revistas: " + qtdRevistas;
    }   

    @Override
    public int compareTo(Caixa c) {
        if(this.getQtdRevistas() < c.getQtdRevistas()) {
            return -1;
        } else if(this.getQtdRevistas() > c.getQtdRevistas()) {
            return 1;
        } else {
            return 0;
        }
    }  
}

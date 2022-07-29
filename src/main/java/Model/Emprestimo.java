/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import Exception.EmprestimoException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Emprestimo 
{
    private int id;
    private LocalDate dataEmprestimo;
    private LocalDate dataEntrega;
    private Dono dono;
    private Amigo amigo;
    private Revista revista;
    private Multa multa;
    

    public Emprestimo() {
    }
    
    
    
    public Emprestimo(LocalDate dataEmprestimo,Dono dono, Amigo amigo, Revista revista) {
        this.revista = revista;
        this.dataEmprestimo = dataEmprestimo;
        this.dono = dono;
        this.amigo = amigo;
        this.dataEntrega = gerarDataEntrega();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
       
    public static Emprestimo emprestar(LocalDate data, Dono dono, Amigo amigo, Revista revista) throws EmprestimoException {
        
        return new Emprestimo(data, dono, amigo, revista);
    }
    
    public LocalDate gerarDataEntrega() {
        return this.dataEmprestimo.plusDays(7);
    }

    public LocalDate getDataHora() {
        return dataEmprestimo;
    }
    
    public Revista getRevista() {
        return revista;
    }

    public void setDataHora(LocalDate dataHora) {
        this.dataEmprestimo = dataHora;
    }

    public LocalDate getDataEmprestimo() {
        return dataEmprestimo;
    }

    public LocalDate getDataEntrega() {
        return dataEntrega;
    }

    public Multa getMulta() {
        return multa;
    }
 
    public Dono getDono() {
        return dono;
    }

    public void setDono(Dono dono) {
        this.dono = dono;
    }

    public Amigo getAmigo() {
        return amigo;
    }

    public void setAmigo(Amigo amigo) {
        this.amigo = amigo;
    }

    public void setRevista(Revista revista) {
        this.revista = revista;
    }

    public void setMulta(Multa multa) {
        this.multa = multa;
    }
  
    
    public String getDataFormatada() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        String dataFormatada = dataEmprestimo.format(formatter);
        return dataFormatada;
    }

    @Override
    public String toString() {
        return "data:" + getDataFormatada() + ", dono:" + dono + ", amigo:" + amigo;
    }
}

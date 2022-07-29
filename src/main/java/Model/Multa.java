/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

public class Multa implements Taxa {
   
   protected int id;
   private int valor;
   private Amigo amigo;

   public Multa() {
       
   }
   
   public Multa(Amigo amigo, int valor) {
       this.valor = valor;
       this.amigo = amigo;
   }
   
    public Amigo getAmigo() {
        return amigo;
    }

    public void setAmigo(Amigo amigo) {
        this.amigo = amigo;
    }
   
   
   
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
   

    public Multa(int valor) {
        this.valor = valor;
    }

    public int getValor() {
        return valor;
    }

    public String toString() {
        return "valor: " + this.valor;
    }

    @Override
    public double calcularTaxa(long dias) {
        return (this.valor * dias);
    }   
}

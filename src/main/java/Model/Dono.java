/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

public class Dono extends Pessoa {
    
    public Dono() {
       super();
    } 
    
    public Dono (String nome, String cpf, String endereco, String telefone) {
        super(nome, cpf, endereco, telefone);
    }
    @Override
    public String toString() {
        return "Tipo: Dono " + super.toString();
    }
}

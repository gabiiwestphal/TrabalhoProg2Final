/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Exception;

public class CpfExistenteException extends Exception {
    
    public CpfExistenteException(){
        super("Pessoa com esse cpf já está cadastrada");
    }
} 

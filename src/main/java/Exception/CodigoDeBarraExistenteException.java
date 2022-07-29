/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Exception;

public class CodigoDeBarraExistenteException extends Exception {
    
    public CodigoDeBarraExistenteException() {
        super("Revista com esse código já existe");
    }
}

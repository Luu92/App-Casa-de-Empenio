/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.edu.uacm.ModelDTO;

/**
 *
 * @author Internet
 */
public class ValidarDatos {
    
    public static boolean validarNombre(String nombre) {
        return nombre.matches("^[A-ZÁÉÍÓÚa-záéíóú]+[ ]?$");
    }

    public static boolean validarApellidos(String apellido) {
        return apellido.matches("^[A-ZÁÉÍÓÚa-záéíóú]+[ ][A-ZÁÉÍÓÚa-záéíóú]+[ ]?$");
    }

    public static boolean validarTelefono(String telefono) {
        return telefono.matches("^([0-9][0-9][-]?){5}$");
    }
    
}
